package com.uqac.portdusaguenay.activity

import android.Manifest
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.core.view.GravityCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.uqac.portdusaguenay.MainActivity
import com.uqac.portdusaguenay.R
import com.uqac.portdusaguenay.model.Course
import kotlinx.android.synthetic.main.activity_display_courses_map.*
import java.io.IOException
import kotlin.concurrent.thread

class DisplayCoursesMap : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnCircleClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var lastLocation: Location
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var searchView: SearchView

    private lateinit var courses: HashMap<Circle, Course>
    private lateinit var circles : ArrayList<Circle>

    private lateinit var selectedCourse: Course

    private var marker: Marker? = null

    private var startARButton: Button? = null
    private var courseButton: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        //Hide title bar
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar?.hide()

        //Set view
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_courses_map)


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)

        // Create SearchView listener
        searchView = findViewById<SearchView>(R.id.searchViewLocation);
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                searchLocation(searchView)
                return true
            }

            override fun onQueryTextChange(newText: String) = false
        })

        startARButton = findViewById(R.id.confirm_button)
        courseButton = findViewById(R.id.ARInfoButtons)

        thread {
            while (true) {
                Thread.sleep(1000)

                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_FINE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return@thread
                }
                fusedLocationProviderClient.lastLocation.addOnSuccessListener {
                        location ->
                    if (location != null) {
                        checkLocation(location)
                    }
                }

            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isZoomGesturesEnabled = true
        mMap.uiSettings.isMapToolbarEnabled = false


        mMap.setOnMarkerClickListener(this)
        mMap.setOnCircleClickListener(this)

        mMap.setPadding(0,150,0,135)

        setUpMap()

        circles = ArrayList()
        courses = HashMap()

        val db = Firebase.firestore
        db.collection("Course")
            .get()
            .addOnSuccessListener { result ->
                for (dbCourse in result) {
                    val course = dbCourse.toObject<Course>()
                    courses[addCircle(LatLng(course.location!!.latitude, course.location!!.longitude))] = course
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "Error getting documents: ", exception)
            }
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }

        mMap.isMyLocationEnabled = true

        fusedLocationProviderClient.lastLocation.addOnSuccessListener(this) { location ->
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 14f))
            }
        }
    }

    private fun addCircle(location: LatLng): Circle {
        return mMap.addCircle(
            CircleOptions().center(LatLng(location.latitude, location.longitude))
                .radius(100.0)
                .strokeWidth(3.0F)
                .strokeColor(Color.argb(99, 0, 174, 240))
                .fillColor(Color.argb(99, 0, 174, 240))
                .clickable(true)
        )
    }

    private fun addMarker(location: LatLng) {
        marker?.remove()
        marker = mMap.addMarker(MarkerOptions().position(location).title("New Course"))
    }

    override fun onMarkerClick(p0: Marker): Boolean = false

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }


    fun searchLocation(view: View?) {
        val location = searchView.query.toString()
        var addressList: List<Address>? = null
        if (location != null || location != "") {
            val geocoder = Geocoder(this)
            try {
                addressList = geocoder.getFromLocationName(location, 1)
                val address: Address = addressList!![0]
                val latLng = LatLng(address.latitude, address.longitude)

                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14f))
            }
            catch (e: IOException) {
                Toast.makeText(applicationContext, "Failed to find location", Toast.LENGTH_LONG).show()
            }
            catch (e: IndexOutOfBoundsException) {
                Toast.makeText(applicationContext, "Failed to find location", Toast.LENGTH_LONG).show()
            }

            // Hide keyboard
            val view = this.currentFocus
            if (view != null) {
                val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }

        }
    }

    override fun onCircleClick(circle: Circle) {
        addMarker(circle.center)
        courseButton!!.visibility = View.VISIBLE
        //findViewById<Button>(R.id.ARInfo).setText("Point selectionné: " + courses[circle]?.name)
        selectedCourse = courses[circle]!!

        findViewById<TextView>(R.id.ARName).visibility = View.VISIBLE
        findViewById<TextView>(R.id.ARName).text = courses[circle]?.name
    }

    fun selectCourse(view: android.view.View) {
        startActivity(Intent(this, CourseDetails::class.java)
            .putExtra("courseName", selectedCourse.name))
    }

    fun goToLocation(view: android.view.View) {
        var startPoint = LatLng(lastLocation.latitude, lastLocation.longitude)
        var destination =
            LatLng(selectedCourse.location!!.latitude, selectedCourse.location!!.longitude)

        println("Searching itinerary from " + startPoint.latitude + "," + startPoint.longitude + " to " + destination.latitude + "," + destination.longitude)

        // ItineraryTask(this, mMap, startPoint, destination).execute()

        val navUri = Uri.parse("http://maps.google.com/maps?&daddr=" +
                destination.latitude + "," + destination.longitude)
        startActivity(Intent(Intent.ACTION_VIEW).apply {
            data = navUri
        })

    }

    fun startARActivity(view: android.view.View) {
        val intent = Intent(this, UnityActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        startActivity(intent)
        
    }

    fun checkLocation(location: Location) {
        //locationButton!!.text = "Current loc : " + location.latitude + " - " + location.longitude

        var isWithinAR = false

        courses.forEach { course ->
            var courseLocation = Location("courseLocation")
            courseLocation.latitude = course.value.location!!.latitude
            courseLocation.longitude = course.value.location!!.longitude

            // Check if user is in a 10 meters radius of a AR point
            if (location.distanceTo(courseLocation) < 15) {
                startARButton!!.text = "Activer le mode Réalitée Augmentée"
                startARButton!!.visibility = View.VISIBLE
                // courseButton!!.visibility = View.GONE

                isWithinAR = true
            }
            else if (!isWithinAR) {
                startARButton!!.visibility = View.GONE
                if(this::selectedCourse.isInitialized)
                    courseButton!!.visibility = View.VISIBLE
            }
        }
    }

    fun LogOut(view: View?) {
        FirebaseAuth.getInstance().signOut()
        val intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun openSettings(view: View) {
        startActivity(Intent(this, Settings::class.java))
    }


}
