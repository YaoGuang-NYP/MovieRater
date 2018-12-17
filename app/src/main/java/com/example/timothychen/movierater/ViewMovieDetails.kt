package com.example.timothychen.movierater

import android.content.Intent
import android.graphics.Movie
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_view_movie_details.*

class ViewMovieDetails: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_movie_details)
        supportActionBar

        registerForContextMenu(tvReview)

        var movieEntity = applicationContext as MovieEntity

        val title = findViewById<TextView>(R.id.tvTitle)
        val description = findViewById<TextView>(R.id.tvOverview)
        val release_date = findViewById<TextView>(R.id.tvReleaseDate)
        val language = findViewById<TextView>(R.id.tvLanguage)
        val suitability = findViewById<TextView>(R.id.tvSuitability)

        title.text = movieEntity.title
        description.text = movieEntity.description
        release_date.text = movieEntity.release_date
        language.text = movieEntity.language
        suitability.text = movieEntity.suitability

        if (movieEntity.rating > 0F)
        {
            ratingBar.layoutParams.height = ActionBar.LayoutParams.WRAP_CONTENT
            ratingBar.rating = movieEntity.rating
            ratingBar.visibility = View.VISIBLE
            tvReview.text = movieEntity.review
        }
    }


    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if(v?.id == R.id.tvReview){
            menu?.add(3,3001,1,"Add")
        }

    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == 3001)
        {
            val intent = Intent(this, RateMovie::class.java)
            startActivity(intent)
        }

        return super.onContextItemSelected(item)

    }

}