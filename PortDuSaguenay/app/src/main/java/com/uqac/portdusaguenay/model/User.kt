package com.uqac.geoexplore.model

import android.net.Uri


class User(var id: String?=null, var shownName: String?=null, var email: String?=null, var profileImageUrl: String? = null, var friends: List<String>?= null) {

    constructor(): this("", "", null, null,null)
    override fun toString(): String {
        return "User(id=$id, shownName=$shownName, email=$email,profileImageUrl=$profileImageUrl, friends=$friends)"
    }

}

