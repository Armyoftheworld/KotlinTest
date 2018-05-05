package com.example.movieguide.di.module

import com.example.movieguide.api.TMDBApi
import com.example.movieguide.di.scope.ListingScope
import com.example.movieguide.ui.interceptor.ListingInterceptor
import com.example.movieguide.ui.interceptor.ListingInterceptorImpl
import com.example.movieguide.ui.presenter.ListingPresenter
import com.example.movieguide.ui.presenter.ListingPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
@Module
class ListingModule {

    @Provides
    @ListingScope
    fun provideListingPresenter(listingInterceptor: ListingInterceptor): ListingPresenter {
        return ListingPresenterImpl(listingInterceptor, null)
    }

    @Provides
    @ListingScope
    fun provideListingInterceptor(tmdbApi: TMDBApi): ListingInterceptor {
        return ListingInterceptorImpl(tmdbApi)
    }
}