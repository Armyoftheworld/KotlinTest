package com.example.movieguide.ui.adapter

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.support.v7.graphics.Palette
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.animation.GlideAnimation
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.example.movieguide.Constact
import com.example.movieguide.R
import com.example.movieguide.model.Movie
import com.example.movieguide.ui.activity.MovieDetailActivity
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
            setOnClickListener {
                val intent = Intent(context, MovieDetailActivity::class.java)
                intent.putExtra(Constact.EXTRA_MOVIE, movie)
                context.startActivity(intent)
            }

            title.text = movie.title

            Glide.with(context)
                    .load(movie.getPosterUrl())
                    .asBitmap()
                    .priority(Priority.HIGH)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(object : BitmapImageViewTarget(poster) {
                        override fun onResourceReady(resource: Bitmap?, glideAnimation: GlideAnimation<in Bitmap>?) {
                            super.onResourceReady(resource, glideAnimation)
                            Palette.from(resource).generate { palette ->
                                title_background.setBackgroundColor(
                                        palette.getVibrantColor(Color.parseColor("#99000000")))
                            }

                        }
                    })
        }
    }
}