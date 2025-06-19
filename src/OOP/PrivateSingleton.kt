package OOP

interface Serializer { fun serialize(x: Any): String }
interface Validator  { fun isValid(x: Any): Boolean }

class PrivateSingleton private constructor(
    val name: String,
    var surname: String,
    private var age: Int = 0
) {
    init { // Have multiple init block
        println("Name: $name $surname \nAge: $age")
    }

    // Secondary constructors
    constructor(name: String) : this(name, "Unknown",0) {
        println("Secondary constructors")
    }

    constructor(name: String, surname: String) : this(name, surname,0)
    constructor(name: String, age: Int)       : this(name, "Unknown", age)

    // Companion object for factory methods and constants
    companion object  { // You can assign name
        const val DEFAULT_AGE = 0

        fun create(name: String): PrivateSingleton = PrivateSingleton(name)
        fun printInfo() {
            println("Person class: Creates Person instances with name, surname, and age")
        }
    }

    //Extend interfaces on your companion
    //If you just want to group behaviors, have your one companion object implement multiple interfaces:
    /*companion object : Serializer, Validator {
        override fun serialize(x: Any) = /*…*/
            override fun isValid(x: Any)   = /*…*/
    } */

    /*
    If you need more groupings of static-like members, you have a couple of alternatives:
    object Metrics {
        fun report() { /*…*/ }
    }

    object Helpers {
        fun formatX() { /*…*/ }

     Usage:
     PrivateSingleton.Metrics.report()
     PrivateSingleton.Helpers.formatX()
    }*/

}

fun main() {
    val p1 = PrivateSingleton.create(name = "Kartik")

    PrivateSingleton.Companion.printInfo() //If you assign name, call PrivateSingleton.name.printInfo

    println("Default age: ${PrivateSingleton.DEFAULT_AGE}")
}
