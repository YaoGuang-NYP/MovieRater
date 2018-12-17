package com.example.timothychen.movierater

import android.app.Application

class MovieEntity: Application(){
    var title: String = ""
    var description: String = ""
    var language: String = ""
    var release_date: String = ""
    var suitability: String = ""
    var rating: Float = 0F
    var review: String = ""

    init {
        this.title = title
        this.description = description
        this.language = language
        this.release_date = release_date
        this.suitability = suitability
        this.rating = rating
        this.review = review
    }
}