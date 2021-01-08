package com.reasearch.myapplication.fundamentals

fun main() {
    println("main starts")
    routine(1, 500)
    routine(2, 300)
    print("main ends")
}

fun routine(number :Int, delay :Long)
{
    println("routine $number starts")
    Thread.sleep(delay)
    println("routine $number ends")
}