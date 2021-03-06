package com.example.timothychen.movierater

import com.example.timothychen.movierater.MovieEntity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class AddMovie : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar

        val rbEnglish = findViewById<RadioButton>(R.id.rbEnglish)
        rbEnglish.isChecked = true
    }

    // Hide Checkboxes
    fun btnHideCheckbox(v:View){
        val chkbx = findViewById<CheckBox>(R.id.chkbxNotSuitable)
        if (chkbx.isChecked){
            chkbxLangUsed.visibility = View.VISIBLE
            chkbxViolence.visibility = View.VISIBLE
        }
        else {
            chkbxLangUsed.visibility = View.INVISIBLE
            chkbxViolence.visibility = View.INVISIBLE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add_movie_menu, menu)
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

        if(item?.itemId == R.id.miClear)
        {
            title.text.clear()
            description.text.clear()
            release_date.text.clear()
            rbEnglish.isChecked = true
            chkbxNotSuitable.isChecked = false
            chkbxLangUsed.visibility = View.INVISIBLE
            chkbxViolence.visibility = View.INVISIBLE
        }

        return super.onOptionsItemSelected(item)

    }
}
