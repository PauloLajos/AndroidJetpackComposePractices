package hu.paulolajos.composeretrofitdemo.util

import hu.paulolajos.composeretrofitdemo.retrofit.Post

sealed class ApiState {
    class Success(val data: List<Post>) : ApiState()
    class Failure(val msg: Throwable) : ApiState()
    object Loading:ApiState()
    object Empty: ApiState()
}