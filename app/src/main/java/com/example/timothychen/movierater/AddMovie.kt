package com.example.timothychen.movierater

import android.support.v7.app.AppCompatActivity
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_main.*

class AddMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declaring of properties
        var name: String
        var description: String
        var rb: RadioButton
        var rg: RadioGroup
        var reason: String
        var language_selected: String
        var suitability: Boolean
        var violence: String
        var langused: String
        var date_release: String
        ///////////////////////////////

        // Hide and hidden of checkbox
        chkbxNotSuitable.isChecked = false
        llSuitable.visibility = View.INVISIBLE
        chkbxNotSuitable.setOnClickListener{
            if(chkbxNotSuitable.isChecked){
                llSuitable.visibility = View.VISIBLE
            } else {
                llSuitable.visibility = View.INVISIBLE
                chkViolence.isChecked = false
                chkLangUsed.isChecked = false
            }
        }

        // Assigning variable for rg
        rg = findViewById(R.id.languageRadioGroup)

        // Assigning default value for radio button
        English.isChecked = true

        // On click of add movie button
        btnSubmit.setOnClickListener{
            var radioButtonId: Int = rg.checkedRadioButtonId
            rb = findViewById(radioButtonId)

            name = etMovieTitle.text.toString()
            description = etShortDescription.text.toString()
            date_release = etReleaseDate.text.toString()
            suitability = chkbxNotSuitable.isChecked
            langused = ""
            violence = ""
            reason = ""
            language_selected = rb.text.toString()

            // Validation for RadioGroup
            if (rb.text.toString() == "English"){
                language_selected = "English"
            }
            else if (rb.text.toString() == "Chinese"){
                language_selected = "Chinese"
            }
            else if (rb.text.toString() == "Malay"){
                language_selected = "Malay"
            }
            else if (rb.text.toString() == "Tamil"){
                language_selected = "Tamil"
            }

            // Validation for Checkbox
            if ( chkLangUsed.isChecked == true && chkViolence.isChecked == true){
                suitability = false
                reason = "Reason:"
                langused = "Language"
                violence = "Violence"
            } else if(chkLangUsed.isChecked == true && chkViolence.isChecked == false){
                suitability = false
                reason = "Reason:"
                langused = "Language"
                violence = ""
            } else if (chkLangUsed.isChecked == false && chkViolence.isChecked == true){
                suitability = false
                reason = "Reason:"
                langused = ""
                violence = "Violence"
            } else {
                reason = ""
                suitability = true
            }


            // Validation
            if (name.isNullOrEmpty() && description.isNullOrEmpty() && date_release.isNullOrEmpty()){
                etMovieTitle.setError("Fill up Title please")
                etShortDescription.setError("Fill up Description please")
                etReleaseDate.setError("Fill up Release date please")
            }
             else{
                etMovieTitle.setError(null)
                etShortDescription.setError(null)
                etReleaseDate.setError(null)

                Toast.makeText(this,
                    "Title = $name\n" +
                    "Description = $description\n" +
                    "Language = $language_selected\n" +
                    "Release Date = $date_release\n" +
                    "Suitable for all ages = $suitability\n"+
                    "$reason\n $langused\n" +
                    "$violence", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
