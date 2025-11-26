package com.azxdev.moviesapp.data.remote.model

import com.google.gson.annotations.SerializedName

data class MoviesDbSearchResponse(
    val ok: Boolean,
    @SerializedName("description")
    val movieResult: List<MovieResult>,
    @SerializedName("error_code")
    val errorCode: Long,
)
