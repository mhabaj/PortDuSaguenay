package com.uqac.portdusaguenay.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.uqac.portdusaguenay.MainActivity
import com.uqac.portdusaguenay.R
import com.uqac.portdusaguenay.R.*
import kotlinx.android.synthetic.main.activity_settings2.*

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_settings2)

        val db = Firebase.firestore
        val dbUser = Firebase.auth.currentUser

        findViewById<TextView>(R.id.profileName).text = dbUser?.displayName
    }

    fun LogOut(view: View?) {
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}