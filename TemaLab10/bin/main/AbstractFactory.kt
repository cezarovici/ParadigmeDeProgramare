abstract class AbstractFactory {
    open fun getHandler(handler: String):Handler?{
        when(handler){
            "CEO" -> return CEOHandler()
            "Executive" -> return ExecutiveHandler()
            "Manager" -> return ManagerHandler()
            "HappyWorker"-> return HappyWorkerHandler()
        }

        print("No CEO / Executive / Manager / HappyWorker handler were passed")
        return null
    }
}