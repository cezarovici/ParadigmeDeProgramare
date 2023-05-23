package ro.mike.tuiasi;


public open class Customer(
    private var person: Person,
    private var bankAccount: BankAccount,
    private var cashAmount: Double,
){
    fun getPerson(): Person {
        return person
    }
    fun setPerson(newPerson: Person) {
        person = newPerson
    }

    fun getBankAccount(): BankAccount {
        return bankAccount
    }
    fun setBankAccount(newBankAccount: BankAccount) {
        bankAccount = newBankAccount
    }

    fun getCashAmount(): Double {
        return cashAmount
    }
    fun setCashAmount(newCashAmount: Double) {
        cashAmount = newCashAmount
    }
}