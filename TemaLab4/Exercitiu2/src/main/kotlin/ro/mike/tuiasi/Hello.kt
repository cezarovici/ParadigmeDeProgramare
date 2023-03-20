package ro.mike.tuiasi

import java.time.LocalDate

fun main(args: Array<String>) {
    val customer = Customer(
        Person("Apetroaei Cezar",20),
        BankAccount(
            LocalDate.of(2023,6,20),
             2000.0,
             "222333",
             666,
             "Apetroaei Cezar",
        ),
        1000.0)

    val ticket = Ticket(
        "StarWars",
        200.0
    )

    val cashPayment = CashPayment(customer.getCashAmount())

   val booking = Booking(customer,ticket,cashPayment)
    booking.tranzation()
    print(customer.getCashAmount())
}

