import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {

        launch {
            println("coroutine1 without providing dispatcher ${Thread.currentThread().name}")
        }

//        launch (Dispatchers.Main){
//            println("coroutine on ${Thread.currentThread().name}")
//        }

        launch (Dispatchers.IO){
            println("coroutine2 with IO  ${Thread.currentThread().name}")
        }

        launch (Dispatchers.Default){
            println("coroutine3 with Default  ${Thread.currentThread().name}")
        }

        launch (Dispatchers.Unconfined){
            println("coroutine4 with Unconfined ${Thread.currentThread().name}")
        }

        GlobalScope.launch {
            println("coroutine5 with GlobalScope without dispatcher ${Thread.currentThread().name}")
        }

    }

}