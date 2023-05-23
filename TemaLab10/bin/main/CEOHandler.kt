import com.sun.org.glassfish.gmbal.ManagedAttribute

class CEOHandler : Handler {
    private val next1: Handler = ExecutiveHandler()
    private val next2: Handler = ManagerHandler()

    override suspend fun handleRequest(messageToBeProcessed: String): Handler? {
        val message = Message(messageToBeProcessed)
        val splitString = message.parse()
        val actualMessage = splitString[1]

        if (splitString[0] == "1"){
            print("I am CEO and I am handling: $actualMessage")
            return CEOHandler()
        }
        else if(splitString[0] == "2")
        {
            return next1
        }
        else if(splitString[0] == "3")
        {
            return next2
        }

        print("Wrong provider, please check the message")
        return null
    }
}