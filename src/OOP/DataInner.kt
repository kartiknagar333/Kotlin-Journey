package OOP

/*
In Kotlin, a data class is a special class designed to hold data.
It automatically generates equals(), hashCode(), toString(), copy(), and componentN() functions based on its properties.
It cannot be open, sealed, abstract, or inner.
Must have at least one parameter in the primary constructor.
Can’t inherit (open not allowed), but can implement interfaces.
*/

class DataInner

data class Person(val name: String, val age: Int)


class Nested

/*
In Kotlin, a nested class is by default static—it does not hold a reference to its basic.outer class.
If you want your nested class to carry a pointer to its containing instance (i.e. be non-static),
you mark it with the inner modifier. This becomes an inner class.
Compiles to a static nested class (like Java’s static class).
Cannot access any members of Outer (unless through an explicit basic.outer instance passed in).
inner class Inner
Compiles to a non-static inner class.
Holds a hidden field this$0 (a reference to its Outer), letting you access basic.outer members directly
 */


class Window(val title: String) {
    private var isOpen = false

    fun open() { isOpen = true; println("$title opened") }
    fun close(){ isOpen = false; println("$title closed") }

    inner class CloseButton {
        fun click() {
            // Directly call the basic.outer’s close():
            this@Window.close()
        }
    }
}


fun main(){
    val person = Person("Alice", 25)
    val person2 = person.copy(age = 26) // Creates new instance with modified age
    println(person) // basic.Person(name=Alice, age=25)
    println(person == person2) // false

    val win = Window("MyApp")
    win.open()                      // “MyApp opened”
    win.CloseButton().click()
}