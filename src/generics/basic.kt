package generics

class basic
// A generic Box that can hold any type T

class Box<T>(var value: T) {
    fun inspect() = "Box holds: $value"
}

// Only allow T to be Number or its subclasses
class NumericBox<T : Number>(var number: T) {
    fun doubleValue(): Double = number.toDouble() * 2
}


fun main() {
    val intBox = Box(42)
    val flBox = Box(42.9)
    val strBox = Box("Kotlin")  //// Generic parameter type can be inferred
    println(intBox.inspect())  // Box holds: 42
    println(flBox.inspect())   // Box holds: 42.9
    println(strBox.inspect())  // Box holds: Kotlin

    val nb = NumericBox(4525);
    println(nb.doubleValue()) //
}