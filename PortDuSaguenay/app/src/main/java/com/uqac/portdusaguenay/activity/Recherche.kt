package com.uqac.geoexplore.activity

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Spinner
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.uqac.geoexplore.Functions
import com.uqac.geoexplore.R
import com.uqac.geoexplore.model.Course
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_recherche.*
import kotlinx.android.synthetic.main.create_course.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch


class Recherche : AppCompatActivity() {
    private lateinit var db: FirebaseFirestore
    private lateinit var courseArraylist: ArrayList<Course>
    private lateinit var my_adapter: MyAdapter
    private lateinit var courseRecycleview : RecyclerView
    private lateinit var spinner_diff : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recherche)

        spinner_diff = findViewById<Spinner>(R.id.courseDifficulty)


        courseRecycleview = findViewById(R.id.courseList)
        courseRecycleview.layoutManager = LinearLayoutManager(this)
        courseRecycleview.setHasFixedSize(true)

        courseArraylist = arrayListOf()
        my_adapter = MyAdapter(courseArraylist)

        courseRecycleview.adapter = my_adapter


        EventChangeListener()
    }


    private fun EventChangeListener(){

        db = FirebaseFirestore.getInstance()
        db.collection("Course").addSnapshotListener(object : EventListener<QuerySnapshot> {
            override fun onEvent(value: QuerySnapshot?, error: FirebaseFirestoreException? ) {
                if(error !=null){
                    Log.e("Firestore Error", error.message.toString())
                    return
                }
                for(dc : DocumentChange in value?.documentChanges!!){
                    if(dc.type == DocumentChange.Type.ADDED) {
                        courseArraylist.add(dc.document.toObject(Course::class.java))
                    }
                }
                my_adapter.notifyDataSetChanged()
            }
        })

    }

    fun retour(view: View){
        val intent = Intent(this, Accueil::class.java)
        startActivity(intent)
    }

    fun submit(view: View) {
        var diff = spinner_diff.getSelectedItem().toString()

        var valeur :String=""
        
        if(diff=="Easy") valeur ="1"
        if(diff=="Medium") valeur ="2"
        if(diff=="Hard") valeur ="3"



        MainScope().launch {

            courseRecycleview.recycledViewPool.clear()
            courseArraylist.clear()

            courseArraylist.addAll(Functions.sortCourses(valeur))
            my_adapter.notifyDataSetChanged()



        }
    }



}


