package com.reasearch.myapplication.fundamentals

import kotlinx.coroutines.*

fun main() = runBlocking{
    println("Main starts")
    joinAll(
        async {
            threadSwitchingCoroutine(1, 5000)
        },  //this will end after second finishes because of 500
        async {
            threadSwitchingCoroutine(2, 3000)
        }  //this will end first because of 300
    )
    println("Main ends")
}

suspend fun threadSwitchingCoroutine(number : Int, delay : Long){
    println("coroutine $number starts in ${Thread.currentThread().name}")
    delay(delay)
    withContext(Dispatchers.Default){
        println("coroutine $number ends ${Thread.currentThread().name}")
    }

}