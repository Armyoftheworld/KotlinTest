package com.example.movieguide.ui.presenter

import com.example.movieguide.model.MovieResponse
import com.example.movieguide.ui.interceptor.ListingInterceptor
import com.example.movieguide.ui.view.ListingView
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
class ListingPresenterImpl(val interceptor: ListingInterceptor, private var listingView: ListingView?) : ListingPresenter {
    override fun setView(listingView: ListingView) {
        this.listingView = listingView
        getMovieLists()

    }

    private fun getMovieLists() {
        interceptor.getMovieLists()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ moviesResponse -> getMoviesSuccess(moviesResponse) },
                        { throwable -> getMoviesFailure(throwable) })
    }

    private fun getMoviesSuccess(movieResponse: MovieResponse?) {
        listingView?.showMovies(movieResponse?.movies)
    }

    private fun getMoviesFailure(throwable: Throwable?) {
        println(throwable?.stackTrace?.toString())
    }
}