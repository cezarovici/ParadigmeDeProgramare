import java.io.File
import kotlin.math.abs
import kotlin.math.sqrt

data class Point(val x: Double, val y: Double)

fun calculateDistance(point1: Point, point2: Point): Double {
    val dx = point2.x - point1.x
    val dy = point2.y - point1.y

    return abs(sqrt(dx * dx + dy * dy))
}

fun calculatePolygonPerimeter(points: List<Point>): Double {
    val startPoint = points.last()
    val distances = points.zipWithNext { point1, point2 -> calculateDistance(point1, point2) }
    val lastDistance = calculateDistance(points.last(), startPoint)

    return distances.sum() + lastDistance
}

fun main() {
    //  1: Eliminarea oricărui număr < 5
    val numbers = listOf(1, 21, 75, 39, 7, 2, 35, 3, 31, 7, 8)
    val filteredNumbers = numbers.filter { it >= 5 }
    println(filteredNumbers) // [21, 75, 39, 7, 35, 31, 7, 8]

    //  2 & 3: Gruparea numerelor în perechi și multiplicarea numerelor din perechi
    val pairs = filteredNumbers.zipWithNext()
    val multipliedNumbers = pairs
        .map { it.first * it.second }
    println(multipliedNumbers) // [1575, 273, 1085, 56]

    //  4: Sumarea rezultatelor
    val sum = multipliedNumbers.sum()
    println(sum) // 2989

    //  Exercitiu 3: Calcularea perimetrului unui poligon
    val points = listOf(
        Point(0.0, 0.0),
        Point(0.0, 1.0),
        Point(1.0, 1.0),
        Point(1.0, 0.0)
    )
    val perimeter = calculatePolygonPerimeter(points)
    println(perimeter) // 4.0

    // Exercitiu 2: Criptarea cuvintelor dintr-un fișier text
    val filename = "input.txt"
    val offset = 3
    val processedText = processTextFile(filename, offset)
    println(processedText)
}



fun processTextFile(filename: String, offset: Int): String {
    val file = File(filename)
    val words = file.readText().split("\\s+".toRegex()) // Separă cuvintele în funcție de spații
    val processedWords = words.map { if (it.length in 4..7) encryptWord(it, offset) else it }
    return processedWords.joinToString(" ")
}

fun encryptWord(word: String, offset: Int): String {
    val encryptedChars = word.map { (it.code + offset).toChar() }
    return String(encryptedChars.toCharArray())
}