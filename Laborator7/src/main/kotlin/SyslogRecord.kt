import java.sql.Timestamp

class SyslogRecord (
    private var line: String
){
    private val parts = line.splitToSequence(' ')
        .filter { it.isNotBlank() }
        .toList()

    private val timestamp = parts[0] + parts[1] + parts[2]
    private val hostName = parts[3]
     val applicationName = parts[4].substringBefore("[")
     val pid = parts[4].substringAfter("[").substringBefore("]")
     val logEntry = parts.drop(6).joinToString(separator = " ")

    override fun toString(): String {
        return "Start-Date: $timestamp\n" +
                "Requested-By: $hostName\n" +
                "Application Name: $applicationName\n" +
                "PID: $pid\n" +
                "Log Entry: $logEntry\n"
    }
}

