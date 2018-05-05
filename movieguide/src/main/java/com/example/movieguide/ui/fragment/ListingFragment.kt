package com.example.movieguide.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import com.example.movieguide.App
import com.example.movieguide.R
import com.example.movieguide.model.Movie
import com.example.movieguide.ui.adapter.ListingAdapter
import com.example.movieguide.ui.presenter.ListingPresenter
import com.example.movieguide.ui.view.ListingView
import kotlinx.android.synthetic.main.fragment_listing.*
import javax.inject.Inject

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
class ListingFragment : Fragment(), ListingView {

    @Inject
    lateinit var presenter: ListingPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (context.applicationContext as App).createListingComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_listing, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movie_list.setHasFixedSize(true)
        movie_list.layoutManager = GridLayoutManager(context, 2)
        movie_list.adapter = ListingAdapter()
        presenter.setView(this)
    }

    override fun showMovies(movies: List<Movie>?) {
        (movie_list.adapter as ListingAdapter).addMovies(movies)
    }
}