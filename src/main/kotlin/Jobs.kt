import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job1  = launch {

            println("job1 launched ")
            val job2 = launch {
                println("job2 launched ")
                cancel()
                delay(3000)

            }
            job2.invokeOnCompletion {
                println("job2 completed")
            }

            val job3 = launch {
                println("job3 launched ")
                delay(3000)
            }
            job3.invokeOnCompletion {
                println("job3 completed")
            }
        }


        job1.invokeOnCompletion {
            println("job1 completed")
            if(it is Throwable){
                println("job1 is throwable")
            }
        }
        delay(500)
        //println("job1 will be cancelled")
        //job1.cancel()
    }
    println("Hence if parent job is cancelled all of its childs also gets cancelled.")
    println("But if child gets cancelled it affects cancelled child")
}