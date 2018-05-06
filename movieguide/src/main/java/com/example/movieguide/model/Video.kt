package com.example.movieguide.model

import com.google.gson.annotations.SerializedName





/**
 * @author Army
 * @version V_1.0.0
 * @date 2018/5/6
 * @description
 */
class Video(val id: String, val name: String, val site: String, @SerializedName("key") val videoId: String,
            val size: Int, val type: String) {

    val SITE_YOUTUBE = "YouTube"

    fun getThumbnailUrl(): String {
        return if (SITE_YOUTUBE.equals(site, true)) {
            "http://img.youtube.com/vi/$videoId/0.jpg"
        } else {
            ""
        }
    }

    fun getUrl(): String {
        return if (SITE_YOUTUBE.equals(site, true)) {
            "http://www.youtube.com/watch?v=$videoId"
        } else {
            ""
        }
    }
}