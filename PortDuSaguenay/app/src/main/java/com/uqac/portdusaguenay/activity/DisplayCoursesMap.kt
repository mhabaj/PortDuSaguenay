package com.uqac.geoexplore.activity

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.location.Address
import android.location.Geocoder
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CircleOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.uqac.geoexplore.R
import com.uqac.geoexplore.model.Course
import java.io.IOException
import java.lang.IndexOutOfBoundsException

class DisplayCoursesMap : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnCircleClickListener {

    private lateinit var mMap: GoogleMap
    private lateinit var lastLocation: Location
    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient
    private lateinit var searchView: SearchView

    private lateinit var courses: HashMap<Circle, Course>
    private lateinit var circles : ArrayList<Circle>

    private lateinit var selectedCourse: Course

    private var marker: Marker? = null

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
                .radius(500.0)
                .strokeWidth(3.0F)
                .strokeColor(Color.argb(99, 51, 153, 51))
                .fillColor(Color.argb(50, 51, 153, 51))
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
        findViewById<Button>(R.id.confirm_button).isEnabled = true
        findViewById<Button>(R.id.confirm_button).setText("Course selected: " + courses[circle]?.name)
        selectedCourse = courses[circle]!!
    }

    fun selectCourse(view: android.view.View) {
        startActivity(Intent(this, CourseDetails::class.java)
            .putExtra("courseName", selectedCourse.name))
    }


}
