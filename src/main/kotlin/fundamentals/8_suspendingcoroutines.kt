package com.reasearch.myapplication.fundamentals

import kotlinx.coroutines.*

fun main() = runBlocking{
    println("Main starts")
    joinAll(
        async {
            suspendingCoroutine(1, 500)
        },  //this will end after second finishes because of 500
        async {
            suspendingCoroutine(2, 300)
        },  //this will end first because of 300
        async {
            repeat(5){
                println("other task in ${Thread.currentThread().name}")
                delay(100)
            }
        }
    )
    println("Main ends")
    println("Third coroutine started and run 3 times and after 300ms second coroutine ends again 3rd resumes and run 2 times after 200 ms first ends")
    println("This proved coroutines are created suspended and resumed but main thread continues to work on other task")
    println("All coroutines runs on main thread and main thread was not blocked")
    println("This proved coroutines are created suspended and resumed but main thread continues to work on other task")
    println("if those were threads it blocked the main thread when calling Thread.sleep holding cpu and resources and doing nothing. This is diff between blocking and suspending")
}

suspend fun suspendingCoroutine(number : Int, delay : Long){
    println("coroutine $number starts in ${Thread.currentThread().name}")
    delay(delay)
    println("coroutine $number ends ${Thread.currentThread().name}")
}