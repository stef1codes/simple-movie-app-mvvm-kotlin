package com.example.stefan_movie_app.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val budget: Int,

    val id: Int,

    @SerializedName("imdb_id")
    val imdbId: String,

    @SerializedName("original_title")
    val originalTitle: String,

    val popularity: Double,

    @SerializedName("release_date")
    val releaseDate: String,
    val revenue: Int,

    val title: String,

    @SerializedName("vote_average")
    val voteAverage: Double,

    @SerializedName("vote_count")
    val voteCount: Int
)