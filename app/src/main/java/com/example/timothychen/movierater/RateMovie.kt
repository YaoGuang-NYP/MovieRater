package com.example.timothychen.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_rate_movie.*

class RateMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rate_movie)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.rate_movie_menu, menu)
        return super.onCreateOptionsMenu(menu)

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val movieEntity = applicationContext as MovieEntity
        movieEntity.rating = ratingBar.rating
        movieEntity.review = etReview.text.toString()
        val intent = Intent(applicationContext,ViewMovieDetails::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)

    }
}
