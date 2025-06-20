package basic
// Define a top-level constant
const val KOTLIN = "basic.KOTLIN"

// basic.Function that performs the logic
fun Variable() {
    // Print the constant
    println(KOTLIN)  // Output: basic.KOTLIN

    // `var` is mutable
    var a = 5
    a = 4  // Reassigned
    println(a)  // Output: 4

    // `val` can be assigned only once
    val b: Int
    b = 6
    // b = a  // ❌ This would cause an error
    println(b)  // Output: 6

    // Create a lowercase version of the constant
    val kotlin = KOTLIN.lowercase()
    println(kotlin)  // Output: kotlin
}
