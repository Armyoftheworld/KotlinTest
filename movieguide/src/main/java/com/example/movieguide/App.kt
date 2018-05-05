package com.example.movieguide

import android.app.Application
import com.example.movieguide.di.component.AppComponent
import com.example.movieguide.di.component.DaggerAppComponent
import com.example.movieguide.di.module.AppModule
import com.example.movieguide.di.module.NetworkModule

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
class App: Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .networkModule(NetworkModule())
                .build()
    }
}