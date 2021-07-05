package com.example.stefan_movie_app.network

import com.example.stefan_movie_app.model.PopularMovies
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {

    @GET("movie/popular")
    suspend fun getPopularMovies():Response<PopularMovies>


}