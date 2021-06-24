package com.example.stefan_movie_app.model
import com.google.gson.annotations.SerializedName

data class PopularMovies(
    val page: Int,
    @SerializedName("results")
    val popularMovies: List<PopularMovie>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)