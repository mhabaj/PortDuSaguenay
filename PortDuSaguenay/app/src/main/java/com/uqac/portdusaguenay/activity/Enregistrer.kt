package com.uqac.geoexplore.activity

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.auth.ktx.userProfileChangeRequest
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.uqac.geoexplore.R
import com.uqac.geoexplore.model.User
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.activity_enregistrer.*
import java.util.*


class Enregistrer : AppCompatActivity() {

    private  var m_name :EditText? = null
    private var m_email:EditText? = null
    var m_image: CircleImageView? = null
    private var m_password: EditText? = null
    private val TAG = "MyActivity"
    private var progress_bar : ProgressBar? =null
    private var m_Resultat:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enregistrer)

        m_name = findViewById<EditText>(R.id.editTextTextPersonName)
        m_email = findViewById<EditText>(R.id.editTextTextEmailAddress)
        m_password = findViewById<EditText>(R.id.editTextTextPassword)
        progress_bar = findViewById<ProgressBar>(R.id.progressBarRecherche)
        m_Resultat = findViewById<TextView>(R.id.textAffichageResultat)
        m_image = findViewById(R.id.selectphoto_imageview_register)


    }


    fun Continue(view: View?) {
        var f_auth = FirebaseAuth.getInstance()

        val db = Firebase.firestore

        
        //Verification
        var email = m_email?.text.toString().trim()
        var password = m_password?.text.toString().trim()

        if(TextUtils.isEmpty(email)){
            m_email?.setError("Email is Required.")
            return
        }
        if(TextUtils.isEmpty(password)){
            m_password?.setError("Password is Required.")
            return
        }
        if(m_password?.length()!! <6 ){
            m_password?.setError("Password must have at least 6 characters.")
            return
        }

        progress_bar?.setVisibility(View.VISIBLE)
        m_Resultat?.setVisibility(View.VISIBLE)



        f_auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { taskId ->
            if(taskId.isSuccessful) {
                m_Resultat?.setText("User Created ")

                val dbUser = Firebase.auth.currentUser

                val profileUpdates = userProfileChangeRequest {
                    displayName = m_name?.text.toString()
                }
                dbUser!!.updateProfile(profileUpdates)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            val user = User(dbUser.uid.toString(),m_name?.text.toString(), dbUser.email.toString(),null, emptyList())
                            db.collection("User")
                                .document(Firebase.auth.currentUser?.uid.toString()).set(user)
                                .addOnSuccessListener {

                                    startActivity(Intent(applicationContext, Accueil::class.java))
                                }
                                .addOnFailureListener { e ->
                                    Log.w(TAG, "Error creating new User", e)
                                }
                        }
                    }

            }
            else {
                //m_Resultat?.setText("Error !!"+ taskId.exception)
                Toast.makeText(this, "Error : "+ taskId.exception!!.message, Toast.LENGTH_SHORT).show()

                progress_bar?.setVisibility(View.INVISIBLE)
            }
        }
    }


    fun LogIn(view: View?) {
        val intent = Intent(this, LogIn::class.java)
        startActivity(intent)

    }




}


