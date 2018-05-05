package com.example.movieguide.ui.interceptor

import com.example.movieguide.api.TMDBApi
import com.example.movieguide.model.MovieResponse
import rx.Observable

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
class ListingInterceptorImpl(val tmdbApi: TMDBApi) : ListingInterceptor {
    override fun getMovieLists(): Observable<MovieResponse> {
        return tmdbApi.getVenues(createQueryMap())
    }

    private fun createQueryMap(): Map<String, String> {
        return hashMapOf(
                "language" to "en",
                "sort_by" to "popularity.desc"
        )
    }
}