package com.example.movieguide.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/5
 * @description
 */
class Movie(@SerializedName("poster_path") val posterPath: String,
            @SerializedName("release_date") val releaseDate: String,
            val id: String,
            val overview: String,
            @SerializedName("backdrop_path") val backdropPath: String,
            val title: String,
            @SerializedName("vote_average") val voteAverage: Double) : Parcelable {
    fun getPosterUrl(): String = "http://image.tmdb.org/t/p/w342$posterPath"

    fun getBackDropPath(): String = "http://image.tmdb.org/t/p/w780$backdropPath"

    constructor(source: Parcel) : this(
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readString(),
            source.readDouble()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(posterPath)
        writeString(releaseDate)
        writeString(id)
        writeString(overview)
        writeString(backdropPath)
        writeString(title)
        writeDouble(voteAverage)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(source: Parcel): Movie = Movie(source)
            override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)
        }
    }
}