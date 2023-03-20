package ro.mike.tuiasi

class Booking (
    private var customer: Customer,
    private var ticket: Ticket,
    private var paymentMethod: PaymentMethod
){
    fun getCustomer(): Customer {
        return customer
    }

    fun setCustomer(newCustomer: Customer) {
        customer = newCustomer
    }

    fun getTicket(): Ticket {
        return ticket
    }

    fun setTicket(newTicket: Ticket) {
        ticket = newTicket
    }

    fun getPaymentMethod(): PaymentMethod {
        return paymentMethod
    }

    fun setPaymentMethod(newPaymentMethod: PaymentMethod) {
        paymentMethod = newPaymentMethod
    }

    fun tranzation():Boolean{
            return paymentMethod.pay(ticket.getPrice())
    }


}