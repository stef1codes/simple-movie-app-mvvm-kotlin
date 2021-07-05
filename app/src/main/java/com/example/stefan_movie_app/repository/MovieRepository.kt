package com.example.stefan_movie_app.repository

import com.example.stefan_movie_app.model.PopularMovies
import com.example.stefan_movie_app.network.MovieServiceBuilder.apiClient
import com.example.stefan_movie_app.network.NetworkResponse

class MovieRepository {
    suspend fun getPopularMovies(): NetworkResponse<PopularMovies> {

        val response = apiClient.getPopularMovies()

        return when {
            response.isSuccessful -> NetworkResponse.success(response)
            response.code() == 500 -> NetworkResponse.failed("ERROR : Internal Server")
            response.code() == 404 -> NetworkResponse.failed("ERROR : The resource you requested could not be found.")
            else -> NetworkResponse.failed("ERROR : big error contact us!")
        }

    }

}