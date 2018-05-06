package com.example.movieguide.ui.interceptor

import com.example.movieguide.api.TMDBApi
import com.example.movieguide.model.Review
import com.example.movieguide.model.ReviewResponse
import com.example.movieguide.model.Video
import com.example.movieguide.model.VideoResponse
import rx.Observable

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/6
 * @description
 */
class MovieDetailsInterceptorImpl(val tmdbApi: TMDBApi) : MovieDetailsInterceptor {
    override fun getReviews(id: String): Observable<ReviewResponse> {
        return tmdbApi.reviews(id)
    }

    override fun getTrailers(id: String): Observable<VideoResponse> {
        return tmdbApi.trailers(id)
    }
}