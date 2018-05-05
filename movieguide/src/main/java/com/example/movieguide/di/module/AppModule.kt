package com.example.movieguide.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
@Module
class AppModule(private val application: Application) {

    @Singleton
    @Provides
    fun provideContext(): Context {
        return application
    }
}