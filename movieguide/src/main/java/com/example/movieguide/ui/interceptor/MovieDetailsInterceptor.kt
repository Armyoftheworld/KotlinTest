package com.example.movieguide.ui.interceptor

import com.example.movieguide.model.ReviewResponse
import com.example.movieguide.model.VideoResponse
import rx.Observable

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/6
 * @description
 */
interface MovieDetailsInterceptor {
    fun getTrailers(id: String): Observable<VideoResponse>
    fun getReviews(id: String): Observable<ReviewResponse>
}