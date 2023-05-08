class FactoryProducer {
    public fun getFactory(choice: String):AbstractFactory? {
        when (choice){
            "Elite"->return EliteFactory();
            "HappyWorker"-> return HappyWorkerFactory();
        }

        print("None of Elite or HappyWorker factory were passed by argument")
        return null
    }
}