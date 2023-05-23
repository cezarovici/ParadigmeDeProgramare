package ro.mike.tuiasi

class CardPayment (
   private var bankAccount: BankAccount
):PaymentMethod{
    override fun pay(fee:Double):Boolean{
        return this.bankAccount.updateAmount(fee)
    }
}