import kotlinx.coroutines.*
import java.lang.IndexOutOfBoundsException

fun main() {
    runBlocking {
        val handler = CoroutineExceptionHandler{coroutineContext , throwable ->
            println("Exception Handled ${throwable.localizedMessage}")
        }

     val job = GlobalScope.launch (handler){
            println("throwing exception from Job")
             throw IndexOutOfBoundsException(" Exception from Job")
     }
        println(" Exception in coroutine started with launch is thrown when job.join() (joins the coroutine with current thread) is invoked.")
        println("to handle exception of coroutine started with launch we need to provide CouroutineException handler to launch")
        job.join()

        val deffered = GlobalScope.async {
            println("throwing exception from async")
            throw ArithmeticException("Exception from Async")
        }
        println(" Exception in coroutine started with async is thrown when deffer.wait() (to access value returned from async) is invoked.")
        println("to handle exception of coroutine started with async we need to provide await call in try/catch block")
        try {
            deffered.await()
        }catch (e:java.lang.ArithmeticException){
            println("Exception Handled ${e.localizedMessage}")
        }


    }

}