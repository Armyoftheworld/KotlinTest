package com.example.movieguide.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.movieguide.App
import com.example.movieguide.Constact
import com.example.movieguide.R
import com.example.movieguide.model.Movie
import com.example.movieguide.model.Review
import com.example.movieguide.model.Video
import com.example.movieguide.ui.presenter.MovieDetailsPresenter
import com.example.movieguide.ui.view.MovieDetailsView
import kotlinx.android.synthetic.main.fragment_movie_detail.*
import javax.inject.Inject
import kotlinx.android.synthetic.main.include_trailers_reviews.*
import kotlinx.android.synthetic.main.layout_video.*
import android.content.Intent
import android.net.Uri
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.layout_review.*


/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/6
 * @description
 */
class MovieDetailFragment : Fragment(), MovieDetailsView {
    @Inject
    lateinit var presenter: MovieDetailsPresenter

    lateinit var movie: Movie

    companion object {

        fun getInstance(movie: Movie): Fragment {
            val bundle = Bundle()
            bundle.putParcelable(Constact.EXTRA_MOVIE, movie)
            val fragment = MovieDetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        (context.applicationContext as App).createMovieDetailComponent().inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setToolbar()
        val movie = arguments.getParcelable<Movie>(Constact.EXTRA_MOVIE) ?: return
        this.movie = movie
        presenter.setView(this)
        presenter.showDetails(movie)
        presenter.showFavoriteButton(movie)
    }

    private fun setToolbar() {
        collapsing_toolbar.setContentScrimColor(ContextCompat.getColor(context, R.color.colorPrimary))
        collapsing_toolbar.title = "MovieDetail"
        collapsing_toolbar.setCollapsedTitleTextAppearance(R.style.CollapsedToolbar)
        collapsing_toolbar.setExpandedTitleTextAppearance(R.style.ExpandedToolbar)
        collapsing_toolbar.isTitleEnabled = true
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(true)
        favorite.setOnClickListener({
            presenter.onFavoriteClick(movie)
        })
    }

    override fun showDetails(movie: Movie) {
        Glide.with(context).load(movie.getBackDropPath()).into(movie_poster)
        movie_name.text = movie.title
        movie_year.text = String.format("Release Date: %s", movie.releaseDate)
        movie_rating.text = "${movie.voteAverage}/10"
        movie_description.text = movie.overview
        presenter.showTrailers(movie)
        presenter.showReviews(movie)
    }

    override fun showTrailers(videos: List<Video>) {
        if (videos.isEmpty()) {
            trailers_label.visibility = View.GONE
            trailers.visibility = View.GONE
            trailers_container.visibility = View.GONE

        } else {
            trailers_label.visibility = View.VISIBLE
            trailers.visibility = View.VISIBLE
            trailers_container.visibility = View.VISIBLE

            trailers.removeAllViews()
            val inflater = activity.layoutInflater
            try {
                for (trailer in videos) {
                    val thumbContainer = inflater.inflate(R.layout.layout_video, this.trailers, false)
                    val videoThumb = thumbContainer.findViewById<ImageView>(R.id.video_thumb)
                    videoThumb.setTag(R.id.glide_tag, trailer.getUrl())
                    videoThumb.requestLayout()
                    videoThumb.setOnClickListener({
                        val videoUrl = it.getTag(R.id.glide_tag) as String
                        val playVideoIntent = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
                        startActivity(playVideoIntent)
                    })
                    Glide.with(context)
                            .load(trailer.getThumbnailUrl())
                            .placeholder(R.color.colorPrimary)
                            .centerCrop()
                            .override(150, 150)
                            .into(videoThumb)
                    trailers.addView(thumbContainer)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun showReviews(reviewList: List<Review>) {
        if (reviewList.isEmpty()) {
            reviews_label.visibility = View.GONE
            reviews.visibility = View.GONE
        } else {
            reviews_label.visibility = View.VISIBLE
            reviews.visibility = View.VISIBLE

            reviews.removeAllViews()
            val inflater = activity.layoutInflater
            try {
                for (review in reviewList) {
                    val reviewContainer = inflater.inflate(R.layout.layout_review, reviews, false)
                    val reviewAuthor = reviewContainer.findViewById<TextView>(R.id.review_author)
                    val reviewContent = reviewContainer.findViewById<TextView>(R.id.review_content)
                    reviewAuthor.text = review.author
                    reviewContent.text = review.content
                    reviewContent.setOnClickListener({
                        if (reviewContent.maxLines == 5) {
                            reviewContent.maxLines = 500
                        } else {
                            reviewContent.maxLines = 5
                        }
                    })
                    reviews.addView(reviewContainer)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun showFavorited() {
        favorite.setImageResource(R.drawable.ic_favorite_white_24dp)
    }

    override fun showUnFavorited() {
        favorite.setImageResource(R.drawable.ic_favorite_border_white_24dp)
    }
}