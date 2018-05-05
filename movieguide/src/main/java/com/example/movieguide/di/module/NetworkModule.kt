package com.example.movieguide.di.module

import android.content.Context
import com.example.movieguide.BuildConfig
import com.example.movieguide.api.ApiKeyInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(@Named("baseUrl") baseUrl: String, gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .build()
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(cache: Cache): OkHttpClient {
        val logInterceptor = HttpLoggingInterceptor();
        logInterceptor.level = provideLogInterceptorLevel();
        return OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(logInterceptor)
                .addInterceptor(ApiKeyInterceptor())
                .build()
    }

    fun provideLogInterceptorLevel(): HttpLoggingInterceptor.Level {
        return if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE
    }

    @Singleton
    @Provides
    fun provideOkhttpCache(context: Context): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(context.cacheDir, cacheSize.toLong())
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }
}