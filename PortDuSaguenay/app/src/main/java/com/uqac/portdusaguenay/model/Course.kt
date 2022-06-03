package com.uqac.portdusaguenay.model



import com.google.android.gms.maps.model.LatLng
import com.google.firebase.firestore.GeoPoint

data class Course (var name: String ?= null,
                   var miscInfo:CourseMiscDetails ?= null,
                   var location: GeoPoint ?= null,
                   var groups: ArrayList<Group> ?= null,
                   var checkPoint: CheckPoint ?= null,
                   var feed: Feed ?= null) {


    override fun toString(): String {
        return "Course(name=$name, miscInfo=$miscInfo, location=$location, groups=$groups, checkPoint=$checkPoint, feed=$feed)\n"
    }

/* private lateinit var id : String
    private lateinit var name : String
    private lateinit var location : String
    private lateinit var groups : ArrayList<Group>
    private lateinit var checkPoints : ArrayList<CheckPoint>
    private lateinit var feed : Feed
    private lateinit var miscInfo : CourseMiscDetails

import com.google.android.gms.maps.model.LatLng
import com.google.firebase.firestore.GeoPoint

class Course {
    private lateinit var id : String
    lateinit var name : String
    lateinit var location : GeoPoint
    private lateinit var groups : Group
    private lateinit var checkPoints : ArrayList<CheckPoint>
    private lateinit var feed : Feed
    lateinit var miscInfo : CourseMiscDetails

*/
}