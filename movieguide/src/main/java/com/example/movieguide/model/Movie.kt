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
            val id: String,
            val overview: String,
            val backdropPath: String,
            val title: String,
            val voteAverage: Double) : Parcelable {
    constructor(source: Parcel) : this(
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