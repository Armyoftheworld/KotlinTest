package com.example.movieguide.ui.presenter

import com.example.movieguide.model.Movie
import com.example.movieguide.ui.view.MovieDetailsView

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/6
 * @description
 */
interface MovieDetailsPresenter {

    fun showDetails(movie: Movie)
    fun showTrailers(movie: Movie)
    fun showReviews(movie: Movie)
    fun showFavoriteButton(movie: Movie)
    fun onFavoriteClick(movie: Movie)
    fun setView(movieDetailsView: MovieDetailsView)
    fun onDestory()
}