import java.io.File
import java.io.IOException


import SyslogRecord
import java.util.*

fun  readFile(path: String):MutableList<SyslogRecord?>{
    var content = mutableListOf<SyslogRecord?>()

    try {
        val scanner = Scanner(File(path))
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()

            content.add(SyslogRecord(line))
        }
    }catch (e: IOException){
        e.printStackTrace();
    }

    return content;
}

fun main(args: Array<String>) {
    val path = "/var/log/syslog";
    var sysLogs =readFile(path)
    val seq = sequenceOf(sysLogs)
//Apr  4 09:36:30 cezar-ThinkPad-P1-Gen-3 wpa_supplicant[774]: wlp0s20f3: CTRL-EVENT-SIGNAL-CHANGE above=0 signal=-61 noise=9999 txrate=520000
    for (syslog in sysLogs){
        if (syslog != null) {
            println(syslog.line)
        }
    }


}