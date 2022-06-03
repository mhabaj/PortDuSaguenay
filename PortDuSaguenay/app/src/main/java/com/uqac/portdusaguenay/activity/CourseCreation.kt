package com.uqac.geoexplore.activity

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.model.LatLng
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.uqac.geoexplore.R
import com.uqac.geoexplore.model.Course
import com.uqac.geoexplore.model.CourseMiscDetails
import com.uqac.geoexplore.model.Feed
import com.uqac.geoexplore.model.User
import java.time.Instant
import java.util.*
import kotlin.collections.ArrayList

class CourseCreation : AppCompatActivity() {
    private lateinit var courseName: EditText
    private lateinit var courseDescription: EditText
    private lateinit var courseLocation: EditText
    private lateinit var courseInterests: EditText
    private lateinit var difficultySpinner: Spinner

    private var difficulty: Int = 0
    private lateinit var locationLatLng: GeoPoint

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.create_course)

        courseName = findViewById(R.id.courseName)
        courseDescription = findViewById(R.id.courseDescription)
        courseLocation = findViewById(R.id.courseLocation)
        courseInterests = findViewById(R.id.courseInterests)
        difficultySpinner = findViewById(R.id.courseDifficulty)

        val locLatLng = intent.extras?.get("location") as LatLng
        locationLatLng = GeoPoint(locLatLng.latitude, locLatLng.longitude)
        courseLocation.setText(locationLatLng.latitude.toString() + ", " + locationLatLng.longitude.toString())



        val adapter = ArrayAdapter.createFromResource(this, R.array.difficulties, R.layout.difficulty_spinner_selected_item)
        adapter.setDropDownViewResource(R.layout.difficulty_spinner_item)
        difficultySpinner.adapter = adapter

        difficultySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                difficulty = position
            }

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addCourseInDatabase(view: android.view.View) {
        if (difficulty == 0) {
            Toast.makeText(applicationContext, "Please select a difficulty", Toast.LENGTH_LONG).show()
        }
        else {

            val db = Firebase.firestore
            val userdb = Firebase.auth.currentUser

            val currentUser = User(userdb?.uid.toString(), userdb?.displayName.toString(), userdb?.email.toString(),null)


            val courseDetails = CourseMiscDetails(currentUser, Date.from(Instant.now()).toString(), 0F, difficulty, courseDescription.text.toString())


            if (courseName.text.toString() == "") {
                Toast.makeText(applicationContext, "Please chose a name for the course", Toast.LENGTH_LONG).show()
            }
            else {
                val newCourse = Course(courseName.text.toString(), courseDetails, locationLatLng, groups = ArrayList())
                newCourse.feed = Feed()
                newCourse.feed!!.comments = ArrayList()

                db.collection("Course")
                    .add(newCourse)
                    .addOnSuccessListener { documentReference ->
                        Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    }
                    .addOnFailureListener { e ->
                        Log.w(TAG, "Error adding document", e)
                    }

                println("Course créée : " + newCourse.name)

                Toast.makeText(applicationContext, "Course successfully created", Toast.LENGTH_LONG).show()
                startActivity(Intent(this, Accueil::class.java))
            }


        }
    }
}