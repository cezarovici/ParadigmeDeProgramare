package org.example

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import java.io.File
import kotlin.system.*

suspend fun CoroutineScope.massiveRun(action: suspend () -> Unit){val n = 100
    val k = 1000
    val time = measureTimeMillis {
        val jobs = List(n)
        {
            launch { repeat(k) { action() } }
        }
        jobs.forEach { it.join() }
    }
    println("S-au efectuat ${n * k} operatii in $time ms")
}

val mtContext = newFixedThreadPoolContext(2, "mtPool")
var counter = 0

fun main() = runBlocking<Unit> {
    val m = Mutex()
    val outputFile = "output"

    CoroutineScope(mtContext).massiveRun {
        m.lock()
        counter++ //variabila comuna unde vor aparea erori
        File(outputFile).writeText((counter).toString())
        m.unlock()
    }
    println("Numarator = $counter")
}