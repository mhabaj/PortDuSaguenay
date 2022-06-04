package com.uqac.portdusaguenay.model

import android.text.format.DateFormat

class Comment(var author: User ?= null,
              var date: String ?= null,
              var textContent: String ?= null,
              var photos: String ?= null) {
    /*
    private lateinit  var author : User
    private lateinit  var date : DateFormat
    private lateinit  var textContent : String
    private lateinit  var photos : String

     */
}