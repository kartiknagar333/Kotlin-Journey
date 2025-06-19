package OOP

//In Kotlin, classes are final by default, meaning they cannot be inherited unless marked with the open keyword

open class OpenSealed {
    open fun greet() = println("Hello from OpenBase")
}

class CLass : OpenSealed() {
    override fun greet() = println("Hello from Child")
}

/*
In Kotlin, a sealed class restricts inheritance to a set of subclasses defined in the same file.
It’s inherently open (no need for open keyword) and used for controlled hierarchies, often with when expressions.
*/
sealed class Parent
class Child : Parent()
class AnotherChild : Parent()

fun checkType(obj: Parent) = when (obj) {
    is Child -> "Child"
    is AnotherChild -> "AnotherChild"
}

fun main() {
    OpenSealed().greet()  // Hello from OpenBase
    CLass().greet()     // Hello from Child

    println(checkType(Child()))
    println(checkType(AnotherChild()))

}

