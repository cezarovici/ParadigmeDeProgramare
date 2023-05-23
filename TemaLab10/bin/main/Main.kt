suspend fun main(args: Array<String>) {
    val factory = FactoryProducer()

    val elite = factory.getFactory("Elite")
    val happyWorker = factory.getFactory("HappyWorker")

  elite?.getHandler("CEO")?.handleRequest("1: Angajeaza ")

}