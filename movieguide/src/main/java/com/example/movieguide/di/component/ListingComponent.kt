package com.example.movieguide.di.component

import com.example.movieguide.di.module.ListingModule
import com.example.movieguide.di.scope.ListingScope
import com.example.movieguide.ui.fragment.ListingFragment
import dagger.Subcomponent

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
@ListingScope
@Subcomponent(modules = arrayOf(ListingModule::class))
interface ListingComponent {
    fun inject(listingFragment: ListingFragment)
}