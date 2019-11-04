package com.example.seul

sealed class ResponseData<out T> {
    class Success<out T>(val data: T) : ResponseData<T>()
    class Error<out T> : ResponseData<T>()
    class Loading<out T> : ResponseData<T>()
}
