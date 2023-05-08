interface Handler{
    // <Priority> : <Message>

    // priority 1 -> CEO
    // priority 2 -> Executive
    // priority 3 -> Manager
    // priority 4 -> HappyWorker

   suspend fun handleRequest(messageToBeProcessed :String):Handler?
}