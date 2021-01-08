package com.reasearch.myapplication.fundamentals

import kotlinx.coroutines.*

fun main() = runBlocking{
    println("Main starts")
    repeat(1_000_000){
        launch {
            delay(5000)
            print(".")
        }
    }

}
