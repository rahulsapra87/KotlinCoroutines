package com.reasearch.myapplication.fundamentals

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll

fun main() = runBlocking{
    println("Main starts")
    joinAll(
        async {
            coroutineWithThreadInfo(1, 500)
        },  //this will end after second finishes because of 500
        async {
            coroutineWithThreadInfo(2, 300)
        }  //this will end first because of 300
    )
    println("Main ends")
}

suspend fun coroutineWithThreadInfo(number : Int, delay : Long){
    println("coroutine $number starts in ${Thread.currentThread().name}")
    delay(delay)
    println("coroutine $number ends ${Thread.currentThread().name}")
}