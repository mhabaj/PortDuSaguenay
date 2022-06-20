package com.uqac.portdusaguenay

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.uqac.portdusaguenay.activity.Accueil
import com.uqac.portdusaguenay.activity.DisplayCoursesMap

import com.uqac.portdusaguenay.activity.Enregistrer
import com.uqac.portdusaguenay.activity.LogIn


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var f_auth = FirebaseAuth.getInstance()

        if(f_auth.currentUser != null) {
            startActivity(Intent(applicationContext, DisplayCoursesMap::class.java))
            //finish()
        }
        setContentView(R.layout.activity_main)

    }


    fun signUp(view: View?) {
        val intent = Intent(this, Enregistrer::class.java)
        startActivity(intent)

    }

    fun logIn(view: View?) {
        val intent = Intent(this, LogIn::class.java)
        startActivity(intent)

    }


}
