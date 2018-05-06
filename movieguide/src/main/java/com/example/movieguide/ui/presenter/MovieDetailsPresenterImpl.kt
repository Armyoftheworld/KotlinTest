package com.example.movieguide.ui.presenter

import com.example.movieguide.model.Movie
import com.example.movieguide.ui.interceptor.MovieDetailsInterceptor
import com.example.movieguide.ui.view.MovieDetailsView
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/6
 * @description
 */
class MovieDetailsPresenterImpl(val movieDetailsInterceptor: MovieDetailsInterceptor) : MovieDetailsPresenter {

    var isFavorite: Boolean = false
    var movieDetailView: MovieDetailsView? = null

    override fun showDetails(movie: Movie) {
        movieDetailView?.showDetails(movie)
    }

    override fun showTrailers(movie: Movie) {
        movieDetailsInterceptor.getTrailers(movie.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ videoResponse -> movieDetailView?.showTrailers(videoResponse.video) })
    }

    override fun showReviews(movie: Movie) {
        movieDetailsInterceptor.getReviews(movie.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ reviewResponse ->
                    movieDetailView?.showReviews(reviewResponse.reviews)
                })
    }

    override fun showFavoriteButton(movie: Movie) {
        if (isFavorite) {
            movieDetailView?.showFavorited()
        } else {
            movieDetailView?.showUnFavorited()
        }
    }

    override fun onFavoriteClick(movie: Movie) {
        isFavorite = !isFavorite
        if (isFavorite) {
            movieDetailView?.showFavorited()
        } else {
            movieDetailView?.showUnFavorited()
        }
    }

    override fun setView(movieDetailsView: MovieDetailsView) {
        this.movieDetailView = movieDetailsView
    }

    override fun onDestory() {
        this.movieDetailView = null
    }

}