package com.example.disneyperson.core

import com.github.johnnysc.coremvvm.data.HandleError
import java.lang.Exception
import java.lang.IllegalArgumentException

sealed class HandleState<T> {

    class Success<T>(val data: T) : HandleState<T>()
    class Error<T>(val error: Throwable) : HandleState<T>()
    class Loading<T>(): HandleState<T>()


}


 inline fun<R> runHandling(block:() -> R): HandleState<R> {
    return try {
        HandleState.Success(block())
    } catch (e: Throwable) {
        HandleState.Error(e)
    }
}

inline fun <T> HandleState<T>.onError(action: (ex: Throwable) -> Unit) : HandleState<T> {
    if (this is HandleState.Error)
        action(this.error)
    return this
}

inline fun <T> HandleState<T>.onSuccess(action: (data: T) -> Unit) : HandleState<T> {
    if (this is HandleState.Success) action(data)
    return this
}

inline fun <T> HandleState<T>.onLoading(action: () -> Unit) : HandleState<T> {
    if (this is HandleState.Loading) action()
    return this
}

inline fun<T,R> HandleState<T>.transform( mapper: (T) -> R) : HandleState<R> {
   return when (this) {
    is HandleState.Success -> runHandling {  mapper(data) }

       else ->  throw IllegalArgumentException()

   }
}