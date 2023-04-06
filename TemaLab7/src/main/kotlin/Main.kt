import java.io.File
import java.io.IOException
import java.util.*

fun  readFile(path: String):MutableList<HistoryLogRecord?>{
    val content = mutableListOf<HistoryLogRecord?>()
    var lineNumber = 0;

    try {
        val scanner = Scanner(File(path))
        while (scanner.hasNextLine() || lineNumber < 50) {
            lineNumber++;

            content.add(HistoryLogRecord(scanner.nextLine()))
        }
    }catch (e: IOException){
        e.printStackTrace();
    }

    return content;
}

fun main(args: Array<String>) {
    val path = "/var/log/apt/history.log"

    val lines = readFile(path)
    for (line in lines){
        println(line)
    }


}