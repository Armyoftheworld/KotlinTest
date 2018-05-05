package com.example.movieguide.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.movieguide.R
import com.example.movieguide.model.Movie
import kotlinx.android.synthetic.main.recycler_listing_item.view.*

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
class ListingAdapter : RecyclerView.Adapter<ListingAdapter.ListHolder>() {

    private val movies: MutableList<Movie> = ArrayList()

    override fun onBindViewHolder(holder: ListHolder?, position: Int) {
        holder?.bind(movies[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ListHolder {
        return ListHolder(LayoutInflater.from(parent?.context).inflate(R.layout.recycler_listing_item, parent, false))
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    fun addMovies(movies: List<Movie>?) {
        if (movies != null) {
            this.movies.addAll(movies)
            notifyDataSetChanged()
        }
    }

    inner class ListHolder(root: View) : RecyclerView.ViewHolder(root) {
        fun bind(movie: Movie) = with(itemView) {
            title.text = movie.title
            Glide.with(context).load(movie.getPosterUrl()).into(poster)
        }
    }
}