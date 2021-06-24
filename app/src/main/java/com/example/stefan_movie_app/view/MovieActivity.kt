package com.example.stefan_movie_app.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.stefan_movie_app.R
import com.example.stefan_movie_app.`interface`.onMovieClick
import com.example.stefan_movie_app.adapter.MovieListAdapter
import com.example.stefan_movie_app.api.BASE_URL_IMAGE
import com.example.stefan_movie_app.model.PopularMovie
import com.example.stefan_movie_app.repository.MovieRepository
import com.example.stefan_movie_app.showMessage
import com.example.stefan_movie_app.viewmodel.MovieViewModel
import com.example.stefan_movie_app.viewmodel.MovieViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MovieActivity : AppCompatActivity() {
    private lateinit var movieListAdaper: MovieListAdapter
    private lateinit var viewModel: MovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViewModel()

        setMovieListAdapter()

        observeMovies()

        onclickMovie()

    }

    private fun onclickMovie() {
        movieListAdaper.setOnItemClickListener(object : onMovieClick {
            override fun onItemClick(movie: PopularMovie) {
                setImage(movie)
            }
        })
    }

    // set details of movie in the id views of this activity class
    fun setImage(movie: PopularMovie) {
        // set title movie
        idTitleMovie.text = movie.title

        // set release movie
        release_date.text = movie.releaseDate

        // set spoken language of  movie
        language.text = movie.originalLanguage

        // set popularity of  movie
        popularity.text = movie.popularity.toString()

        // set overview of movie
        idDescription.text = movie.overview

        // set average vote of movie
        vote_average.text = movie.voteAverage.toString()

        //set image
        Glide.with(this)
            .load(BASE_URL_IMAGE + movie.posterPath)
            .transform(CenterInside(), RoundedCorners(25))
            .into(idimage)
    }

    // Observe data from viewModel
    private fun observeMovies() {
        viewModel.liveMovies.observe(this, { response ->
            when {

                //if the api service successfully retrieved data, insert the data into the listadapter
                response.success -> {
                    showMessage(this, "Successful!")
                    movieListAdaper.setData(response.body.popularMovies)
                    setImage(response.body.popularMovies.first())
                }

                //if the data could'nt be retrieved, show this message
                response.failed ->
                    showMessage(this, "${response.message}")
            }
        })
    }

    // initialization of the ListAdapter
    private fun setMovieListAdapter() {
        movieListAdaper = MovieListAdapter()
        idRecyclerview.adapter = movieListAdaper
        idRecyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
    }

    // initialization of the ViewModel
    private fun setViewModel() {
        viewModel = ViewModelProvider(
            this,
            MovieViewModelFactory(MovieRepository())
        ).get(MovieViewModel::class.java)
    }
}


