package basic
// Entry function to demonstrate all features
fun Function() {
    // 1. Basic basic.Function: adds two numbers
    println("Add(3, 4): " + add(3, 4))

    // 2. No parameter, no return function
    sayHello()

    // 3. Expression body function: multiplies two numbers
    println("Multiply(5, 6): " + multiply(5, 6))

    // 4. Default arguments: prints with default or custom name
    greet() // uses default "Guest"
    greet("Kartik") // uses given name

    // 5. Named and positional arguments
    createUser(name = "Alice", age = 22, city = "Chicago")
    createUser("Lodo", 21, "Chicago") // positional style

    // 6. Vararg: function accepts variable number of arguments
    printAll("One", "Two", "Three")

    // 7. Nothing function: crashes app – skipped
    // basic.fail()

    // 8. Local function: function declared inside another
    outer()

    // 10 & 11. Higher-order and function type: pass function as argument
    val result = operate(10, 20, ::add)
    println("Operate with basic.add: $result")

    // 12. Inline function: function body is inlined at call site
    runTwice { println("Hello from inline function!") }

    // 13. Extension function: extends String with a basic.reverse() method
    val name = "Kotlin"
    println("Reversed name: " + name.reverse())

    // 14. Tail recursion: basic.factorial using optimized recursion
    println("Factorial of 5: " + factorial(5))

    // 15. basic.Function Overloading: basic.greet with and without parameter
    greet()
    greet("Overload")

    // 16. Anonymous basic.Function: function assigned to variable
    val square = fun(x: Int): Int {
        return x * x
    }
    println("Square of 5: " + square(5))


    // 17. Operator Overloading: adds two custom objects using `+`
    val a = MyClass(5)
    val b = MyClass(7)
    val c = a + b // internally calls plus() operator function
    println("Operator Overloaded + Result: ${c.value}")
}

///////////////////////
// SUPPORT FUNCTIONS //
///////////////////////

// 1. Basic basic.Function
fun add(a: Int, b: Int): Int {
    return a + b
}

// 2. No parameter, no return
fun sayHello() {
    println("Hello!")
}

// 3. Expression body function
fun multiply(a: Int, b: Int): Int = a * b

// 4. basic.Function with default argument
fun greet(name: String = "Guest") {
    println("Hello, $name")
}

// 5. basic.Function using parameters
fun createUser(name: String, age: Int, city: String) {
    println("User(name=$name, age=$age, city=$city)")
}

// 6. Vararg function: accepts multiple strings
fun printAll(vararg words: String) {
    for (word in words) println("Word: $word")
}

// 7. basic.Function returning Nothing type – crashes when called
fun fail(): Nothing {
    println("Nothing")
    throw IllegalStateException("Something went wrong!")
}

// 8. basic.Function containing a local (inner) function
fun outer() {
    fun inner() {
        println("I'm a local function")
    }
    inner()
}

// 10. Higher-order function: accepts function as parameter
fun operate(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    return op(a, b)
}

// 12. Inline function: compiler inlines the function body
inline fun runTwice(action: () -> Unit) {
    action()
    action()
}

// 13. Extension function: adds basic.reverse() to String
fun String.reverse(): String {
    return this.reversed()
}

// 14. Tail-recursive basic.factorial
tailrec fun factorial(n: Int, acc: Int = 1): Int {
    return if (n <= 1) acc else factorial(n - 1, acc * n)
}



// 17. Operator overloading using `+` for custom class
data class MyClass(val value: Int) {
    operator fun plus(other: MyClass): MyClass {
        return MyClass(this.value + other.value)
    }
}
