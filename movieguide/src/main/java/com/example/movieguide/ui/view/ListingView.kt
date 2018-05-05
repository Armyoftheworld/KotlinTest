package com.example.movieguide.ui.view

import com.example.movieguide.model.Movie

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
interface ListingView {

    fun showMovies(movies: List<Movie>?)
}