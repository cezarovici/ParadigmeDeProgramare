package org.example

import kotlinx.coroutines.*

fun sum(number: Int):Int{
    var sum = 0

    for (i in 1..number){
        sum += i
    }

    return sum
}

suspend fun calculate(list: List<Int>):List<Int> = coroutineScope{
    val sumList = mutableListOf<Deferred<Int>>()

    launch {
        for (element in list) {
            val deferredSum = async {
                println("Calculating sum for $element - Start")
                val result = sum(element)
                println("Calculating sum for $element - End")

                result
            }
            println("Sum is $deferredSum")
            sumList.add(deferredSum)
        }
    }

    return@coroutineScope sumList.awaitAll()
}



suspend fun main()  {
    val result = calculate(listOf(1, 2, 4, 5, 6))
    println(result)
}