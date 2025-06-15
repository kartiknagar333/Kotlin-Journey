// File: LambdaDemo.kt

// Entry point to demonstrate all lambda usages
fun Lambda() {
    println("=== Lambda Function Demo ===\n")

    // Basic lambda passed to a function: returns x + y
    val result = operate0(2, 3) { x, y -> x + y }
    println("operate0(2, 3) with lambda { x + y }: $result")

    // Same as above using expression body style
    println("operate1(2, 3) with lambda { x - y }: " +
        operate1(2, 3) { x, y -> x - y })

    // Using lambda that returns Unit (no result), prints directly
    print("operate2(2, 3) with lambda { println(x * y) }: ")
    operate2(2, 3) { x, y -> println(x * y) }

    // Passing a named function using :: (function reference)
    println("operate1(2, 3, ::add): " + operate1(2, 3, ::add0))

    println("\n=== Lambda Function Table Summary ===")
    printFunctionTable()
    printSyntaxRules()
    printStyleNotes()
}

// -------- Lambda Function Definitions --------

// 1. Function using full block body and lambda with return type
fun operate0(x: Int, y: Int, op: (Int, Int) -> Int): Int {
    return op(x, y)
}

// 2. Expression body version of above function (shorter)
fun operate1(x: Int, y: Int, op: (Int, Int) -> Int) = op(x, y)

// 3. Function using lambda that returns Unit (used for printing/logging)
fun operate2(x: Int, y: Int, op: (Int, Int) -> Unit) = op(x, y)

// 4. Named function to pass as reference
fun add0(a: Int, b: Int): Int {
    return a + b
}

// -------- Explanation Tables --------

fun printFunctionTable() {
    println(
        """
| Function     | Type                    | Explanation                                        |
| ------------ | ----------------------- | -------------------------------------------------- |
| operate()    | with lambda             | Accepts (Int, Int) -> Int and returns result       |
| operate1()   | expression body version | Same as above, just shorthand                      |
| operate2()   | with Unit lambda        | Accepts (Int, Int) -> Unit, executes action only   |
| ::add        | function reference      | Passing existing function by name                  |
        """.trimIndent()
    )
}

fun printSyntaxRules() {
    println(
        """
| Syntax                | Works? | When to Use                              |
| --------------------- | ------ | ---------------------------------------- |
| func(a, b, { ... })   | ✅     | Always works                             |
| func(a, b) { ... }    | ✅     | Only when lambda is last parameter       |
| func { ... }          | ✅     | Only if lambda is the **only** parameter |
        """.trimIndent()
    )
}

fun printStyleNotes() {
    println(
        """
| Style                    | Valid? | Notes                               |
| ------------------------ | ------ | ----------------------------------- |
| All lambdas inside       | ✅     | Always works                        |
| Only last lambda outside | ✅     | Trailing lambda works for last only |
| Two trailing lambdas     | ❌     | Not allowed in Kotlin               |
        """.trimIndent()
    )
}
