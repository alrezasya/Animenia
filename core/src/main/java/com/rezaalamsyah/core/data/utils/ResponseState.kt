package com.rezaalamsyah.core.data.utils
@Suppress("unused")
sealed class ResponseState<out R> {
    data class Success<out T>(val data: T) : ResponseState<T>()
    data class Failure(val errorMessage: String) : ResponseState<Nothing>()
    object Empty : ResponseState<Nothing>()
}