package com.uqac.portdusaguenay.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import com.uqac.portdusaguenay.MainActivity
import com.uqac.portdusaguenay.R.*

class Settings : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_settings2)
    }

    fun LogOut(view: View?) {
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}