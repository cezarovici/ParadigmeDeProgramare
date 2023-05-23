package ro.mike.tuiasi

interface PaymentMethod {
    fun pay(fee:Double):Boolean
}