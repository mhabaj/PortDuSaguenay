package com.uqac.geoexplore.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.uqac.geoexplore.R

class Accueil : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_accueil)


    }

    fun RechercherCourse(view: View){
        val intent = Intent(this, UnityActivity::class.java)
        startActivity(intent)
    }

    fun settings(view: View?) {
        val intent = Intent(this, Settings::class.java)
        startActivity(intent)

    }

    fun displayMap(view: android.view.View) {
        startActivity(Intent(this, DisplayCoursesMap::class.java))
    }

    fun profile(view: View?) {
        val intent = Intent(this, Profile::class.java)
        startActivity(intent)
    }

    fun createCourse(view: android.view.View) {
        startActivity(Intent(this, CourseCreationMap::class.java))
    }

}