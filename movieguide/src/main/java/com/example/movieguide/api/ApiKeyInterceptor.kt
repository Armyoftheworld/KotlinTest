package com.example.movieguide.api

import com.example.movieguide.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
internal class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val originalUrl = originalRequest.url()
        val newUrl = originalUrl.newBuilder()
                .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
                .build()
        val newRequest = originalRequest.newBuilder().url(newUrl).build()
        return chain.proceed(newRequest)
    }

}