package com.example.stefan_movie_app.api

import androidx.constraintlayout.solver.state.State
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException


object MovieServiceBuilder {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor {  chain->
            val url:HttpUrl = chain.request()
            .url()
            .newBuilder()
            .addQueryParameter("api_key",API_KEY)
            .build()
            val request:Request =chain.request()
                .newBuilder()
                .url(url)
                .build()
            chain.proceed(request) }
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build().create(MovieService::class.java)
     val apiClient = retrofit

}