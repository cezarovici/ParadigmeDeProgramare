import java.io.File
import java.io.IOException


import SyslogRecord
import java.util.*

fun  readFile(path: String):MutableList<SyslogRecord?>{
    val content = mutableListOf<SyslogRecord?>()
    var lineNumber = 0;

    try {
        val scanner = Scanner(File(path))
        while (scanner.hasNextLine() || lineNumber < 50) {
            lineNumber++;
            content.add(SyslogRecord(scanner.nextLine()))
        }
    }catch (e: IOException){
        e.printStackTrace();
    }

    return content;
}

fun main(args: Array<String>) {
    val path = "/var/log/syslog";
    val sysLogs = readFile(path)

    for (syslog in sysLogs){
        if (syslog != null) {
            println(syslog.toString())
        }
    }

    val sysMap = mutableMapOf<String,SyslogRecord?> ()


    val syslogMapped = sysLogs.asSequence()
        .filter { it?.pid != "" }
        .sortedBy { it?.logEntry
        }
        .forEach {
            if (it != null) {
                sysMap[it.applicationName] = it
            }
        }


    for((key,value) in sysMap){
        print("$key -> $value")
    }


}