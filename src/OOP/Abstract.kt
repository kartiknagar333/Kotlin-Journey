package OOP

abstract class Abstract

// 1) Public abstract class – visible everywhere; subclassable anywhere
public abstract class PublicAbstractShape(val name: String) {
    // abstract member—must be implemented by subclasses
    abstract fun area(): Double

    // concrete helper—available (and override-able) to subclasses
    open fun describe(): String = "$name has area ${area()}"

    // 1) public var (default): public getter + public setter; both final
    var publicVar: Int = 0

    // 2) open var: public getter + public setter; both open for override
    open var openVar: Int = 1

    // 3) private var: getter & setter only visible inside this class
    private var privateVar: Int = 2

    // 4) protected var: getter & setter visible to this class & its subclasses
    protected var protectedVar: Int = 3

    // 5) var with restricted setter: public getter, protected setter
    var protectedSetterVar: Int = 4
        protected set

    // 6) abstract var: no backing field here—must be overridden
    abstract var abstractVar: String

    // 7) var with custom accessors
    var customAccessorVar: Int = 5
        get() = field * 2           // getter doubles the stored value
        set(value) { field = value / 2 }  // setter halves the incoming value
}

// Subclass in the same file
abstract class PublicCircle(radius: Double) : PublicAbstractShape("PublicCircle") {
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
/*
To allow a class to be inherited by other classes,
the class should be marked with the open keyword. (Abstract classes are always open.)
 */