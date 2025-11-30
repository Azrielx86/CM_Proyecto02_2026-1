package com.azxdev.moviesapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class MovieDetailsShort(
    @SerializedName("#TITLE")
    val title: String,
    @SerializedName("#YEAR")
    val year: Long,
    @SerializedName("#IMDB_ID")
    val imdbId: String,
    @SerializedName("#RANK")
    val rank: Long,
    @SerializedName("#ACTORS")
    val actors: String,
    @SerializedName("#AKA")
    val aka: String,
    @SerializedName("#IMDB_URL")
    val imdbUrl: String,
    @SerializedName("#IMDB_IV")
    val imdbIv: String,
    @SerializedName("#IMG_POSTER")
    val imgPoster: String?,
    @SerializedName("photo_width")
    val photoWidth: Long?,
    @SerializedName("photo_height")
    val photoHeight: Long?,
)