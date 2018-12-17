package com.example.timothychen.movierater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import kotlinx.android.synthetic.main.activity_main.*

class EditMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_movie)

        var movieEntity = applicationContext as MovieEntity

        val title = findViewById<EditText>(R.id.etMovieTitle)
        val description = findViewById<EditText>(R.id.etShortDescription)
        val release_date = findViewById<EditText>(R.id.etReleaseDate)

        // Set text value for respective EditText
        // Value taken from MovieEntity class
        title.setText(movieEntity.title)
        description.setText(movieEntity.description)
        release_date.setText(movieEntity.release_date)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_movie_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        var title = findViewById<EditText>(R.id.etMovieTitle)
        var description = findViewById<EditText>(R.id.etShortDescription)
        var release_date = findViewById<EditText>(R.id.etReleaseDate)

        var rgLanguage = findViewById<RadioGroup>(R.id.rgLanguage)
        var radioId = rgLanguage.checkedRadioButtonId
        var radioIdSelected: RadioButton = findViewById(radioId)

        var suitability = ""

        if (chkbxNotSuitable.isChecked){
            suitability = "No"
        } else if (!chkbxNotSuitable.isChecked){
            suitability = "Yes"
        }

        if (item?.itemId == R.id.miAdd)
        {

            if (title.text.isNullOrEmpty()){
                title.setError("Please Enter the Movie Title!")
            }

            if (description.text.isNullOrEmpty()){
                description.setError("Please Enter the Description of the Movie!")
            }

            if (release_date.text.isNullOrEmpty()){
                release_date.setError("Please fill in the Release Date of Movie!")
            }

            else{
                var movieEntity = applicationContext as MovieEntity
                movieEntity.title = title.text.toString()
                movieEntity.description = description.text.toString()
                movieEntity.release_date = release_date.text.toString()
                movieEntity.language = radioIdSelected.text.toString()
                movieEntity.suitability = suitability
                // Proceed to next activity: ViewMovieDetails
                val intent = Intent(applicationContext, ViewMovieDetails::class.java)
                startActivity(intent)

            }

        }

        else if (item?.itemId == R.id.miCancel){
            val intent = Intent(this,LandingPage::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)

    }

}
