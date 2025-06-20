package generics


// 1. Define an interface with the functionality you need
interface Movable {
    fun move()
}

// 2. Provide concrete implementations
class Car(val make: String, val model: String) : Movable {
    override fun move() {
        println("Driving the $make $model on the road.")
    }
}

class Plane(val manufacturer: String, val type: String) : Movable {
    override fun move() {
        println("Flying the $manufacturer $type through the sky.")
    }
}

// 3. A generic Pilot that only accepts Ts that implement Movable
class Pilot<T : Movable>(private val vehicle: T) {
    fun go() {
        vehicle.move()
    }
}

// 4. Use it in a main function
fun main() {
    val ryanGosling = Pilot(Car("Chevy", "Malibu"))
    val sullySullenberger = Pilot(Plane("Airbus", "A320"))

    ryanGosling.go()           // Driving the Chevy Malibu on the road.
    sullySullenberger.go()     // Flying the Airbus A320 through the sky.
}
