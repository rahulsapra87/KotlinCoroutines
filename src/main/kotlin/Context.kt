import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch(CoroutineName("myCoroutine")) {
            println("this is run from ${this.coroutineContext.get(CoroutineName.Key)}")
        }
    }

}