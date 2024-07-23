package com.example.unitconverter

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Load the ConverterFragment when the activity is first created
        if (savedInstanceState == null) {
            loadFragment(ConverterFragment())
        }

        // Handle button click to load the ConverterFragment
        val menuButton = findViewById<Button>(R.id.menu_button)
        menuButton.setOnClickListener {
            loadFragment(ConverterFragment())
        }
    }

    // Method to replace the fragment in the container
    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    // Inflate the menu options
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    // Handle menu item selection
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_converter -> {
                loadFragment(ConverterFragment())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
