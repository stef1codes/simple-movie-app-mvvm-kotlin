package com.example.stefan_movie_app

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.stefan_movie_app.api.BASE_URL_IMAGE


    fun glideImage(posterPath:String, view: View, imageView: ImageView){
        Glide.with(view)
            .load( BASE_URL_IMAGE +posterPath)
            .transform(CenterInside(), RoundedCorners(25))
            .placeholder(R.drawable.ic_launcher_background)
            .into(imageView)
    }
 fun showMessage(context:Context,message:String){
     Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
 }
