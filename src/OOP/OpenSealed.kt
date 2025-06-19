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

sealed class Base {
    open var value: Int = 23
    open fun foo() = value * 2
}
open class Child1 : Base() {
    override fun foo() = value * 3
    final override var value: Int = 10
        set(value) = run { field = super.foo() }
}
class Child2 : Base()



fun main() {
    OpenSealed().greet()  // Hello from OpenBase
    CLass().greet()     // Hello from Child

    println(checkType(Child()))
    println(checkType(AnotherChild()))

    val b: Base = Child1()
    when(b) {
        is Child1 -> println(1)
        is Child2 -> println(2)
    }
}

