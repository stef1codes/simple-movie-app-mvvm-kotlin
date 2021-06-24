package com.example.stefan_movie_app.api

import com.example.stefan_movie_app.model.PopularMovies
import retrofit2.Response

class SafeMovieService(private val movieService: MovieService) {

    suspend fun  getMovies(): NetworkResponse<PopularMovies> {
      return handlingApiResponse { movieService.getPopularMovies()}
    }
}