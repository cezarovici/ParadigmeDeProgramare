class Message(private val message: String) {
    fun parse():List<String>{
        return message.split(":")
    }
}