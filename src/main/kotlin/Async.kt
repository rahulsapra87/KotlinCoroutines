import kotlinx.coroutines.*
import kotlin.concurrent.thread

fun main() {
    println("main starts here")
    runBlocking {
        println("runBlocking coroutine started in ${Thread.currentThread().name}")

        joinAll(launch {
            println("coroutine 1 started async in ${Thread.currentThread().name}")
            delay(1000)
            suspendedFunc(1)
        }, launch {
            println("coroutine 2 started async in ${Thread.currentThread().name}")
            delay(500)
            suspendedFunc(2)
        })

//        joinAll(
//            async {
//                println("coroutine 1 started async in ${Thread.currentThread().name}")
//                delay(1000)
//                suspendedFunc(1)
//            },
//            async {
//                println("coroutine 2 started async in ${Thread.currentThread().name}")
//                delay(500)
//                suspendedFunc(2)
//            }
//        )

        println("runBlocking coroutine ended in ${Thread.currentThread().name}")
    }
    println("main ends here")
    println("runBlocking blocks the function in which it is invoked. In out case it is main function so on completion main ")
    println(" it prints main ends.")

    println("inside runBlocking using joinAll it waits for job 1 and 2 to complete after that rouBlocking ended statment is executed.")
    println("same result will be achieved with both async and launch .")
}

suspend fun suspendedFunc( number : Int){
    println("suspended func $number in ${Thread.currentThread().name}")
}