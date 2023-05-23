package ro.mike.tuiasi

class CashPayment(
   private var availableAmount: Double
) :PaymentMethod{
    override fun pay(fee: Double):Boolean{
        if(this.availableAmount - fee >= 0){
            this.availableAmount -= fee

            return true
        }

        print("\nNo enough amount for this operation")
        return false
    }
}