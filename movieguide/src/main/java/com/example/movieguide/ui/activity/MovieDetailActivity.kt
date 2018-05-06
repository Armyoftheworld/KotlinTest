package com.example.movieguide.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v4.app.NavUtils
import android.view.MenuItem
import com.example.movieguide.Constact
import com.example.movieguide.R
import com.example.movieguide.model.Movie
import com.example.movieguide.ui.fragment.MovieDetailFragment


/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/6
 * @description
 */
class MovieDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        val movie = intent.getParcelableExtra<Movie>(Constact.EXTRA_MOVIE)
        val fragment = MovieDetailFragment.getInstance(movie)
        supportFragmentManager
                .beginTransaction()
                .add(R.id.movie_details_container, fragment, fragment::class.simpleName)
                .commit()

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> NavUtils.navigateUpFromSameTask(this)
        }
        return super.onOptionsItemSelected(item)
    }
}