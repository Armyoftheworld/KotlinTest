package com.example.movieguide.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.movieguide.R
import com.example.movieguide.ui.fragment.ListingFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
                .add(R.id.container, ListingFragment(), ListingFragment::class.java.simpleName)
                .commit()
    }
}
