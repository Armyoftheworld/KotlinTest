package com.example.movieguide.api

import com.example.movieguide.model.MovieResponse
import com.example.movieguide.model.ReviewResponse
import com.example.movieguide.model.VideoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import rx.Observable

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
interface TMDBApi {

    @GET("/3/discover/movie")
    fun getVenues(@QueryMap map: Map<String, String>): Observable<MovieResponse>

    @GET("3/movie/{movieId}/videos")
    fun trailers(@Path("movieId") movieId: String): Observable<VideoResponse>

    @GET("3/movie/{movieId}/reviews")
    fun reviews(@Path("movieId") movieId: String): Observable<ReviewResponse>
}