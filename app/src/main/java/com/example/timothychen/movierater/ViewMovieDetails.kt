package com.example.timothychen.movierater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_view_movie_details.*

class ViewMovieDetails: AppCompatActivity() {

    class MovieDetails(title: String, overview: String, language: String, release_date: String, suitability: String){
        var title: String
        var overview: String
        var language: String
        var release_date: String
        var suitability: String

        init {
            this.title = title
            this.overview = overview
            this.language = language
            this.release_date = release_date
            this.suitability = suitability
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_movie_details)

        val movie_details = MovieDetails("Venom",
            "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego Venom to save his life",
            "English", "03-10-2018", "Yes")

        tvTitle.setText(movie_details.title)
        tvOverview.setText(movie_details.overview)
        tvLanguage.setText(movie_details.language)
        tvReleaseDate.setText(movie_details.release_date)
        tvSuitability.setText(movie_details.suitability)

    }

}