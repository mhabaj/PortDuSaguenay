package com.uqac.portdusaguenay.activity

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.uqac.portdusaguenay.R
import com.uqac.portdusaguenay.model.Course
import com.uqac.portdusaguenay.model.Group
import kotlin.collections.ArrayList

class CourseDetails : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore

    private lateinit var joinButton: Button

    private lateinit var course: Course

    private lateinit var courseName: TextView
    private lateinit var courseDescription: TextView
    private lateinit var courseInterests: TextView
    private lateinit var courseDate: TextView
    private lateinit var courseTime: TextView
    private lateinit var courseDifficulty: TextView
    private lateinit var courseRating: TextView

    private lateinit var courseId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_course)

        val selectedCourseName = intent.extras!!["courseName"] as String

        joinButton = findViewById(R.id.joinBox)

        getCourseFromName(selectedCourseName)

    }

    private fun fillInformation() {
        courseName = findViewById(R.id.courseNameView)
        courseName.text = course.name

        courseDescription = findViewById(R.id.descriptionView)
        courseDescription.text = course.miscInfo?.description
        //courseDate.hint = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE)

        courseDifficulty = findViewById(R.id.courseDifficultyView)
        when (course.miscInfo?.difficulty) {
            1 -> courseDifficulty.text = "Difficulty: Easy"
            2 -> courseDifficulty.text = "Difficulty: Medium"
            3 -> courseDifficulty.text = "Difficulty: Hard"
        }


        courseRating = findViewById(R.id.courseRating)
        courseRating.text = "%.1f".format(course.miscInfo?.rating)
    }

    private fun getCourseFromName(name: String){
        db = Firebase.firestore
        db.collection("Course")
            .whereEqualTo("name", name)
            .get()
            .addOnSuccessListener { result ->
                course = result.first().toObject()
                courseId = result.first().id
                fillInformation()

                checkGroups()
            }
            .addOnFailureListener { exception ->
                Log.d(ContentValues.TAG, "Error getting documents: ", exception)
            }
    }

    fun openNav(view: android.view.View) {
        val navUri = Uri.parse("http://maps.google.com/maps?&daddr=" +
            course.location!!.latitude + "," + course.location!!.longitude)
        startActivity(Intent(Intent.ACTION_VIEW).apply {
            data = navUri
        })
    }

    fun joinCourse(view: android.view.View) {
        println("Joining course")

        val userdb = Firebase.auth.currentUser

        if (course.groups == null) {
            course.groups = ArrayList()
        }
        val newGroup = Group()
        newGroup.participants = ArrayList()
        newGroup.participants?.add(userdb?.uid!!)
        course.groups!!.add(newGroup)

        db.collection("Course").document(courseId).update("groups", course.groups)
        println("Course Joined: " + course.name)

        joinButton.isEnabled = false
        joinButton.text = "Course Joined"
        joinButton.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)

    }

    private fun checkGroups() {
        if (course.groups != null) {
            for (group in course.groups!!) {
                if (group.participants != null) {
                    if (group.participants!!.contains(Firebase.auth.currentUser?.uid)) {
                        joinButton.isEnabled = false
                        joinButton.text = "Course Joined"
                        joinButton.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null)

                    }
                }

            }
        }
    }


    private fun showErrorMessage() {
        Toast.makeText(this,"Error", Toast.LENGTH_SHORT).show();
    }
}