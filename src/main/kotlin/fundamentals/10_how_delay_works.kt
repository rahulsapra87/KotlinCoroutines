package com.reasearch.myapplication.fundamentals

//import android.os.Handler
//import android.os.Looper
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll


fun main() = runBlocking{
    println("Main starts")
    joinAll(
        async {
            delayDemonstration(1, 500)
        },  //this will end after second finishes because of 500
        async {
            delayDemonstration(2, 300)
        }  //this will end first because of 300
    )
    println("Main ends")
}

 fun delayDemonstration(number : Int, delay : Long){
    println("coroutine $number starts")
    //delay(delay)
     //println("coroutine $number ends")
//    Handler(Looper.getMainLooper()).postDelayed({
//        println("coroutine $number ends")
//    },delay)

}