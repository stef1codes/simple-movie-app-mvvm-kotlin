package com.example.stefan_movie_app.viewmodel

import com.example.stefan_movie_app.model.PopularMovies
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.stefan_movie_app.network.NetworkResponse
import com.example.stefan_movie_app.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    private val mutableMovies = MutableLiveData<NetworkResponse<PopularMovies>>()
    val liveMovies: LiveData<NetworkResponse<PopularMovies>> get() = mutableMovies


    init
    {
        viewModelScope.launch(Dispatchers.Main){ mutableMovies.postValue(movieRepository.getPopularMovies())}

    }


}


