package com.example.stefan_movie_app.api

import com.example.stefan_movie_app.model.PopularMovie
import com.example.stefan_movie_app.model.PopularMovies
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    //https://image.tmdb.org/t/p/w500/xCEg6KowNISWvMh8GvPSxtdf9TO.jpg <-- poster

    @GET("movie/popular")
    suspend fun getPopularMovies():Response<PopularMovies>


}