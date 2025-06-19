package OOP

class Enum
enum class Currency(val symbol: String) : Printable {
    USD("$") {
        override fun conversionRateToINR(): Double = 83.25 // Example rate
        override fun print(): String = "US Dollar: $symbol"
    },
    INR("₹") {
        override fun conversionRateToINR(): Double = 1.0
        override fun print(): String = "Indian Rupee: $symbol"
    };

    abstract fun conversionRateToINR(): Double
}

interface Printable {
    fun print(): String
}

fun main(){
    val usd = Currency.USD
    println(usd.print()) // US Dollar: $
    println(usd.conversionRateToINR()) // 83.25
}