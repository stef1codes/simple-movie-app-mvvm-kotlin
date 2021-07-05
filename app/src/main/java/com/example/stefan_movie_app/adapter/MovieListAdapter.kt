package com.example.stefan_movie_app.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.stefan_movie_app.R
import com.example.stefan_movie_app.`interface`.OnMovieClick
import com.example.stefan_movie_app.network.BASE_URL_IMAGE
import com.example.stefan_movie_app.model.PopularMovie

class MovieListAdapter : ListAdapter<PopularMovie, MovieListAdapter.MovieViewHolder>(MovieComparator()) {
    private var list = mutableListOf<PopularMovie>()
    private lateinit var mListener: OnMovieClick

    fun setData(list: List<PopularMovie>) {
        this.list = list as MutableList<PopularMovie>
        submitList(list)
    }

    fun setOnItemClickListener(listener: OnMovieClick) {
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.movielist_row,parent,false))

    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        return holder.bind(getItem(position))
    }



    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var textMovieTitle = itemView.findViewById<TextView>(R.id.textMovieTitle)

        private  var imagMovie:ImageView = itemView.findViewById(R.id.imageMovie)

        private lateinit var movie: PopularMovie

        fun bind(movie: PopularMovie) {
            this.movie = movie
            textMovieTitle.text = movie.title
             Glide.with(itemView)
                .load( BASE_URL_IMAGE + movie.posterPath)
                .transform(CenterInside(), RoundedCorners(25))
               // .placeholder(R.drawable.ic_launcher_background)
                .into(imagMovie)

        }
        init
        {
            itemView.setOnClickListener {
                mListener.onItemClick(movie)
            }
        }
    }

    class MovieComparator : DiffUtil.ItemCallback<PopularMovie>() {

        override fun areItemsTheSame(oldItem: PopularMovie, newItem: PopularMovie): Boolean
        {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: PopularMovie, newItem: PopularMovie): Boolean
        {
            return oldItem.title == newItem.title
        }
    }


}