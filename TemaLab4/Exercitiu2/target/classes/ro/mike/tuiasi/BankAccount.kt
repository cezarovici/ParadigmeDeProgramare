package ro.mike.tuiasi

import java.time.LocalDate

class BankAccount(
    private var expirationDate: LocalDate,
    private var availableAmount: Double,

    private var cardNumber: String,
    private var cvvCode: Int,
    private var userName: String,
    ) {

    fun setExpirationDate(date: LocalDate){
        this.expirationDate = date
    }

    fun setAvailableAmount(availableAmount: Double){
        this.availableAmount = availableAmount
    }

    fun setCardNumber(cardNumber: String){
        //TODO - validate newCardNumber

        this.cardNumber = cardNumber
    }

    fun setCvvCode(cvvCode: Int){
        // TODO - validate ccvCode

        this.cvvCode = cvvCode
    }

    fun setUserName(userName: String){
        // TODO - validate userName

        this.userName = userName
    }

    fun updateAmount(value: Double):Boolean{
      if (!this.updateAmount(value)){
          println("No enough amount for this operation ")
          return false
      }

      if (!this.expirationDate.isAfter(LocalDate.now())){
          println("The card is expired")
          return false
      }


        println("The operation succed")
        return true
    }

    fun getUserName():String{
        return this.userName
    }

    fun getExpirationDate():LocalDate{
        return this.expirationDate
    }

    fun getCvvNumber():Int{
        return this.cvvCode
    }

    fun getAvailableAmount():Double{
        return this.availableAmount
    }

    fun getCardNumber():String{
        return this.cardNumber
    }

}