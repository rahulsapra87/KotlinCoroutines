import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {

    runBlocking {
        println("coroutine with runBlocking started")

        val def1 = async {
            println("async 1 started")
            getFirstValue()
        }

        val def2 = async {
            println("async 2 started")
            getSecondValue()
        }

        println("doing processing here")
        delay(5000)
        println("waiting for values")

        val firstValue = def1.await()
        val secondValue = def2.await()
        val total = firstValue + secondValue
        println("total: $total")
        println("coroutine with runBlocking ends")
    }
}

suspend fun getFirstValue() : Int{
    println("first value started")
    delay(1000)
    val randomNum = Random.nextInt(100)
    println("return $randomNum")
    return randomNum
}

suspend fun getSecondValue() : Int{
    println("second value started")
    delay(2000)
    val randomNum = Random.nextInt(1000)
    println("return $randomNum")
    return randomNum
}