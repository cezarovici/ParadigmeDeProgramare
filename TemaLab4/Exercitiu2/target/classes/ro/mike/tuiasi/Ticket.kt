package ro.mike.tuiasi

class Ticket(
    private var movieName: String,
    private var price :Double
) {
    fun getMovieName(): String {
        return movieName
    }

    fun setMovieName(newMovieName: String) {
        movieName = newMovieName
    }

    fun getPrice(): Double {
        return price
    }

    fun setPrice(newPrice: Double) {
        price = newPrice
    }
}