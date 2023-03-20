package ro.mike.tuiasi

class BankAccount(
    private var expirationDate: Date,
    private var availableAmount: Double,

    private val cardNumber: String,
    private val cvvCode: Int,
    private val userName: String,
    ) {
    fun updateAmount(value: Double):Boolean{
        return true
    }
}