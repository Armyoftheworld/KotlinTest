package com.example.movieguide.di.module

import com.example.movieguide.api.TMDBApi
import com.example.movieguide.di.scope.DetailScope
import com.example.movieguide.ui.interceptor.MovieDetailsInterceptor
import com.example.movieguide.ui.interceptor.MovieDetailsInterceptorImpl
import com.example.movieguide.ui.presenter.MovieDetailsPresenter
import com.example.movieguide.ui.presenter.MovieDetailsPresenterImpl
import dagger.Module
import dagger.Provides

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/6
 * @description
 */
@Module
class MovieDetailModule {

    @DetailScope
    @Provides
    fun provideMovieDetailInterceptor(tmdbApi: TMDBApi): MovieDetailsInterceptor {
        return MovieDetailsInterceptorImpl(tmdbApi)
    }

    @DetailScope
    @Provides
    fun provideMOvieDetailPresenter(movieDetailsInterceptor: MovieDetailsInterceptor): MovieDetailsPresenter {
        return MovieDetailsPresenterImpl(movieDetailsInterceptor)
    }
}