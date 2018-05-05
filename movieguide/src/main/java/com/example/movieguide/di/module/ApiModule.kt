package com.example.movieguide.di.module

import com.example.movieguide.api.TMDBApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
@Module
class ApiModule {

    @Singleton
    @Provides
    @Named("baseUrl")
    fun provideBaseUrl(): String {
        return "http://api.themoviedb.org/"
    }

    @Singleton
    @Provides
    fun provideTMDBApi(retrofit: Retrofit): TMDBApi {
        return retrofit.create(TMDBApi::class.java)
    }
}