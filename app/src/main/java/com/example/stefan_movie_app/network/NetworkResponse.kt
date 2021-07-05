package com.example.stefan_movie_app.network

import retrofit2.Response


data class NetworkResponse<T>(
    private val status: Status,
    private val data: Response<T>?,
    private val exception: String?,
) {

    sealed class Status {
        object SUCCESSFUL : Status()
        object FAILURE : Status()
    }

    companion object {
        fun <T> success(data: Response<T>): NetworkResponse<T> =
            NetworkResponse(
                status = Status.SUCCESSFUL,
                data = data,
                exception = "")

        fun <T> failed(exception: String?): NetworkResponse<T> =
            NetworkResponse(
                status = Status.FAILURE,
                data = null,
                exception = exception
            )


    }

    val failed: Boolean get() = this.status == Status.FAILURE

    val success: Boolean get() = this.status == Status.SUCCESSFUL && this.data?.isSuccessful == true

    val body: T get() = this.data!!.body()!!

    val message: String? get() = this.exception
}






