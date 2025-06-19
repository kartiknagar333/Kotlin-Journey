package OOP

class SealedInterface

sealed interface Shape { // Public by default
    // val color: String // By default Public, abstract
    val color1: String get() = "Black" // Public, concrete
    private val color2: String get() = "Black" // Private, concrete
    fun area(): Double // Public, abstract
    fun describe(): String = "Shape with area ${area()}" // Public, concrete
    private fun helper(): String = "Helper" // Private, concrete
}

data class Circle(val radius: Double) : Shape {
    override fun area(): Double = Math.PI * radius * radius
}

open class Rectangle(val width: Double, val height: Double) : Shape {
    override fun area(): Double = width * height
}


//class Triangle(size: Double) : Shape Error: Sealed types can only be extended in the same file
class Triangle(size: Double) : Shape {
    override fun area(): Double = 0.0
}

//if Rectangle not open, it cannot be extended here or other file
class Triangle1(size: Double) : Rectangle(size, size) {
    override fun area(): Double = 0.0
}

/*
if Shape is Class?
Where Shape Can Be Extended:
Only in the same file
Subclasses like Circle and Rectangle must be defined in Shape.kt.
Data Class Rectangle
A data class Rectangle that extends Shape is final by default in Kotlin.
Kotlin’s data classes are not open for inheritance unless explicitly marked with the open modifier.
Therefore, a data class Rectangle cannot be extended by any class, whether
in the same file or a different file, unless it’s made open.
Open Class Rectangle
If Rectangle is an open class (not a data class) that extends Shape,
it can be extended by other classes, such as Square, in any file, as long as Rectangle is accessible
(e.g., public or internal within the same module).
 */