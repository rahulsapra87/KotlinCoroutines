import kotlinx.coroutines.*

fun main() {
    println("main program execution starts here and will be blocked")

    runBlocking{
        println("blocking started here")

        launch {
            delay(1000)
            println("coroutine with  runBlocking scope ends here")
        }
        GlobalScope.launch {
            delay(500)
            println("coroutine with GlobalScope ends here")
        }
        coroutineScope {
            delay(5500)
            println("coroutine with coroutineScope ends here")
        }

        println("blocking ends here")
    }

    println("main program execution continue as runBlocking blocks the main thread and wait untill all coroutine completed")
}