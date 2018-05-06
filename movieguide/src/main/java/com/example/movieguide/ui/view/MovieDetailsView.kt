package com.example.movieguide.ui.view

import com.example.movieguide.model.Movie
import com.example.movieguide.model.Review
import com.example.movieguide.model.Video

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/6
 * @description
 */
interface MovieDetailsView {
    fun showDetails(movie: Movie)
    fun showTrailers(videos: List<Video>)
    fun showReviews(reviews: List<Review>)
    fun showFavorited()
    fun showUnFavorited()
}