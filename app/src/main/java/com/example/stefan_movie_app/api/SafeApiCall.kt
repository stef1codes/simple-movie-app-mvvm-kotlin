package com.example.stefan_movie_app.api

import retrofit2.Response
import kotlin.Exception


data class NetworkResponse<T>(
    private val status: Status,
    private val data: Response<T>?,
    private val exception: String?
    ) {

    sealed class Status {
        object SUCCESSFUL : Status()
        object FAILURE : Status()
    }
    companion object {
        fun<T>success(data: Response<T>):NetworkResponse<T> =
            NetworkResponse(
                status = Status.SUCCESSFUL,
                data = data,
                exception = "")

        fun <T>failed(exception: String?):NetworkResponse<T> =
            NetworkResponse(
                status = Status.FAILURE,
                data = null,
                exception = exception
            )


    }

     val failed:Boolean get() {
        return this.status == Status.FAILURE
    }
    val success:Boolean get() {
        return  this.status == Status.SUCCESSFUL && this.data?.isSuccessful == true
    }

    val body: T get() {
        return this.data!!.body()!!
    }
    val message: String?
        get() {
        return this.exception
    }
}


inline fun <T> handlingApiResponse(apiCall: () -> Response<T>): NetworkResponse<T> {
    return try {

        NetworkResponse.success(apiCall.invoke())
    } catch (e: Exception) {
        NetworkResponse.failed("")
    }
}





