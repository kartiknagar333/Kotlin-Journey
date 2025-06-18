package OOP
/*
  1.Primary Constructor
    Defined in the class header.
    Uses constructor keyword (optional if no annotations or visibility modifiers).
    Can include properties directly.
  2.init Block
    Runs immediately after the primary constructor.
    Used for additional initialization logic.
    Multiple init blocks are allowed and executed in order of declaration
  3.Secondary Constructors
    Defined with constructor keyword inside the class.
    Must delegate to the primary constructor using this.
    Useful for multiple initialization paths.
    - Order of execution: Primary constructor → init blocks (in order) → secondary constructor body.
    = Visibility: Constructors can be private, internal, etc., to control instantiation4
   4.Best Practices
    Use primary constructor for essential properties.
    Use init for validation or simple setup.
    Use secondary constructors for alternative initialization logic.
    Keep init blocks lightweight to avoid complexity.
*/

class MyClass(val name: String, var surname: String, private var age: Int = 0) {

    init {
        println("Name: $name \nSurname: $surname \nAge: $age")
    }

    // give outside read access, but keep setter private
    val currentAge: Int get() = age

    constructor(name: String) : this(name, "Unknown",0) // error : this(name,"Unknown")
    constructor(name: String, surname: String) : this(name, surname,0)
    constructor(name: String, age: Int) : this(name, "Unknown", age)
    constructor(name: String, familyPerson: MyClass) : this(name, familyPerson.surname, 0)

}

fun main() {
    val p1 = MyClass(name = "Kartik")
    val p2 = MyClass("Human","AI")
    val p3 = MyClass("Human2",100)
    val p4 = MyClass(name = "Nagar",p1)
}