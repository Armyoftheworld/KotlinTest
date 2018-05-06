package com.example.movieguide.di.component

import com.example.movieguide.di.module.MovieDetailModule
import com.example.movieguide.di.scope.DetailScope
import com.example.movieguide.ui.fragment.MovieDetailFragment
import dagger.Subcomponent

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/6
 * @description
 */
@DetailScope
@Subcomponent(modules = arrayOf(MovieDetailModule::class))
interface MovieDetailComponent {
    fun inject(movieDetailFragment: MovieDetailFragment)
}