import java.sql.Timestamp
import java.text.SimpleDateFormat

class HistoryLogRecord (line: String){
    private var startDate : Timestamp? = stringToTimestamp(line.substringAfter("Start-Date: ").substringBefore("\n" ));
    private var commandLine: String? = line.substringAfter("Commandline: ").substringBefore("\n");

    private fun stringToTimestamp(dateString: String?): Timestamp? {
        if (dateString == ""){
            return null
        }

        print(dateString)

        val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        val date = dateFormat.parse(dateString)

        return Timestamp(date.time)
    }

    override fun toString(): String {
        return "StartDate: $startDate\n"+
                "CommandLine: $commandLine"
    }
}