package com.uqac.portdusaguenay

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.uqac.portdusaguenay.model.User
import com.uqac.portdusaguenay.model.Course
import com.uqac.portdusaguenay.model.Group

import kotlinx.coroutines.tasks.await

/*
    Utility functions to retrieve data from firebase.
 */

class Functions {
    companion object {
        suspend fun getUserFromUid(uidToGet: String): User? {
            val db = Firebase.firestore
            val docRef = db.collection("User").document(uidToGet)
            return try {
                val documentSnapshot = docRef.get().await()
                documentSnapshot.toObject<User>()
            } catch (e: Exception) {
                null
            }
        }


        suspend fun sortCourses(
            difficulty: String? = null,
            note: String? = null,
            distance: String? = null
        ): ArrayList<Course> {

            var courseArraylist: ArrayList<Course> = ArrayList()

            //On recup les courses (A AMELIORER: Recuperer que les courses qui nous interessent

            if (!difficulty.isNullOrEmpty()) {

                val db = Firebase.firestore

                db.collection("Course").whereEqualTo("miscInfo.difficulty", difficulty.toInt())
                    .get()
                    .addOnSuccessListener { courses ->

                        for (course in courses) {
                            courseArraylist.add(course.toObject(Course::class.java))
                            Log.d(
                                "Function Recherche",
                                courseArraylist[courseArraylist.size - 1].toString()
                            )

                        }

                        //return courseArraylist
                    }.await()


            }

            return courseArraylist
        }


        suspend fun getCourseFromId(IdToGet: String): Course? {
            val db = Firebase.firestore
            val docRef = db.collection("Course").document(IdToGet)
            return try {
                val documentSnapshot = docRef.get().await()
                documentSnapshot.toObject<Course>()
            } catch (e: Exception) {
                null
            }

        }

        suspend fun retrieveUid(usersInGroup: ArrayList<String>): Group? {
            val db = Firebase.firestore
            val groupToAdd = Group(ArrayList())

            return try {
                for (userInGroup in usersInGroup) {
                    db.collection("User").whereEqualTo("shownName", userInGroup).get().addOnSuccessListener {
                            users ->
                        for (user in users) {
                            val userID = user.toObject<User>().id

                            println("Adding uid to group : $userID")
                            groupToAdd.participants?.add(userID!!)
                        }
                    }.await()
                }
                return groupToAdd
            } catch (e: java.lang.Exception) {
                null
            }
        }
    }
}



