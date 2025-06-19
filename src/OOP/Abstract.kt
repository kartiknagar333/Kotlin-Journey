package OOP

abstract class Abstract

// 1) Public abstract class – visible everywhere; subclassable anywhere
public abstract class PublicAbstractShape(val name: String) {
    // abstract member—must be implemented by subclasses
    abstract fun area(): Double

    // concrete helper—available (and override-able) to subclasses
    open fun describe(): String = "$name has area ${area()}"
}

// Subclass in the same file
class PublicCircle(radius: Double) : PublicAbstractShape("PublicCircle") {
    private val r = radius
    override fun area() = Math.PI * r * r
    override fun describe() = super.describe() + " (radius=$r)"
}


// 2) Sealed abstract class – visible everywhere; subclassable only in this file
sealed abstract class SealedAbstractShape {
    abstract fun area(): Double
}
class SealedSquare(val side: Double) : SealedAbstractShape() {
    override fun area() = side * side
}
object SealedUnitCircle : SealedAbstractShape() {
    override fun area() = Math.PI * 1.0 * 1.0
}


// 3) Private abstract class – visible & subclassable only in this file
private abstract class PrivateAbstractShape(protected val tag: String) {
    abstract fun area(): Double
    fun info() = "[$tag] area=${area()}"
}
private class PrivateTriangle(val base: Double, val height: Double)
    : PrivateAbstractShape("PrivateTriangle") {
    override fun area() = base * height / 2
}


// 4) Nested private abstract class inside another class – only visible inside Container
class Container {
    private abstract class InnerAbstract(val id: Int) {
        abstract fun render(): String
    }
    private class InnerDot(id: Int) : InnerAbstract(id) {
        override fun render() = "Dot#$id"
    }
    fun makeDotString(): String {
        val dot: InnerAbstract = InnerDot(42)
        return dot.render()
    }
}
