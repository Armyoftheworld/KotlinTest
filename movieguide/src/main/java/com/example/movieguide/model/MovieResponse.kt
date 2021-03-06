package com.example.movieguide.model

import com.google.gson.annotations.SerializedName

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
class MovieResponse {
    @SerializedName("results")
    lateinit var movies: List<Movie>
}