package com.example.movieguide.di.component

import com.example.movieguide.di.module.ApiModule
import com.example.movieguide.di.module.AppModule
import com.example.movieguide.di.module.ListingModule
import com.example.movieguide.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, ApiModule::class, NetworkModule::class))
interface AppComponent {
    fun plus(listingModule: ListingModule): ListingComponent
}