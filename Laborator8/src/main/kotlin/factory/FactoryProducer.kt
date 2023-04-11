package factory

class FactoryProducer {
    fun getFactory(choice: String): AbstractFactory? {
        when(choice){
            "EliteFactory" -> return EliteFactory()
            "HappyWorkerFactory" -> return HappyWorkerFactory()
        }

        return null
    }
}