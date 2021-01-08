package com.reasearch.myapplication.fundamentals

import kotlin.concurrent.thread

fun main() {
    println("main starts")
    threadRoutine(1, 500)
    threadRoutine(2, 300)
    Thread.sleep(1000)
    print("main ends")
}

fun threadRoutine(number :Int, delay :Long)
{
    thread {
        println("threadRoutine $number starts")
        Thread.sleep(delay)
        println("threadRoutine $number ends")
    }

}