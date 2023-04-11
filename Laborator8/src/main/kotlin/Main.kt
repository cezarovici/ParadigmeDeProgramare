import chain.CEOHandler
import chain.ExecutiveHandler
import chain.HappyWorkerHandler
import chain.ManagerHandler
import factory.EliteFactory
import factory.FactoryProducer
import factory.HappyWorkerFactory

fun main(args: Array<String>) {
    //TODO()
// se creeaza 1xFactoryProducer, 1xEliteFactory, 1xHappyWorkerFactory
//.
    var factoryProducer: FactoryProducer
    var eliteFactory: EliteFactory
    var happyWorkerFactory: HappyWorkerFactory

// crearea instantelor (prin intermediul celor 2 fabrici):
// 2xCEOHandler, 2xExecutiveHandler, 2xManagerHandler, 2xHappyWorkerHandler
//...

    var ceoHandler1: CEOHandler
    var ceoHandler2: CEOHandler

    var executiveHandler1: ExecutiveHandler
    var executiveHandler2: ExecutiveHandler

    var happyWorker1: HappyWorkerHandler
    var happyWorker2: HappyWorkerHandler

    var managerHandler1: ManagerHandler
    var managerHandler2: ManagerHandler


// se construieste lantul (se verifica intai diagrama de obiecte si se realizeaza legaturile)
//...
// se executa lantul utilizand atat mesaje de prioritate diferita, cat si directii diferite in lant
//...
}