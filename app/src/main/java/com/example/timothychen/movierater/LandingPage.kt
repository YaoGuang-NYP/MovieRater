package com.example.timothychen.movierater

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.view.MenuItem
import android.view.View
import android.view.ContextMenu
import kotlinx.android.synthetic.main.activity_landing_page.*

class LandingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        registerForContextMenu(tvLanding)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if (v?.id == R.id.tvLanding) {
            menu?.add(1, 1001, 1, "Add")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1001) {
            val intent = Intent(this,AddMovie::class.java)
            startActivity(intent)
        }

        return super.onContextItemSelected(item)

    }
}
