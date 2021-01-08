package com.reasearch.myapplication.structuredconcurrency

import kotlinx.coroutines.*

val scope = CoroutineScope(Dispatchers.Default)

fun main() = runBlocking{
// runBlocking special coroutine builder that does not need scope to launch coroutine
   val job = scope.launch {
        delay(100)
        println("coroutine completed")
    }
    job.invokeOnCompletion {
        if(it is CancellationException){
            println("as scope of coroutine ends so cancellation exception was thrown and coroutine was cancelled!")
        }
    }
    delay(50)
    onDestroy()
}

fun onDestroy(){
    println("life time of scope ends now so all incomplete coroutines within scope will get cancelled.")
    scope.cancel()
}