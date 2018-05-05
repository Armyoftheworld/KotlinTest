package com.example.movieguide.api

import com.example.movieguide.model.MovieResponse
import retrofit2.http.GET
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
}