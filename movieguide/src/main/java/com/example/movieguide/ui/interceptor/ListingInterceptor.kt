package com.example.movieguide.ui.interceptor

import com.example.movieguide.model.MovieResponse
import rx.Observable

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
interface ListingInterceptor {

    fun getMovieLists(): Observable<MovieResponse>
}