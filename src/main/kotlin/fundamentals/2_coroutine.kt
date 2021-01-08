package com.reasearch.myapplication.fundamentals

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll

fun main() = runBlocking{
    println("Main starts")
    joinAll(
        async {
            coroutine(1, 500)
        },  //this will end after second finishes because of 500
        async {
            coroutine(2, 300)
        }  //this will end first because of 300
    )
    println("Main ends")
}

suspend fun coroutine(number : Int, delay : Long){
    println("coroutine $number starts")
    delay(delay)
    println("coroutine $number ends")
}