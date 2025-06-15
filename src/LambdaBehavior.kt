// File: LambdaBehavior.kt

fun LambdaBehavior() {
    println("===== INLINE FUNCTION DEMO =====")
    testInline()

    println("\n===== CROSSINLINE FUNCTION DEMO =====")
    testCrossinline()

    println("\n===== NOINLINE FUNCTION DEMO =====")
    testNoinline()

    println("\n===== NULL SAFETY DEMO =====")
    testNullSafety()
}

/////////////////////
// INLINE
/////////////////////

/**
 * Demonstrates how `inline` copies the block into the call site.
 * Allows `return` to exit the calling function (non-local return).
 */
inline fun inlineFunction(block: () -> Unit) {
    println("inlineFunction: Before block")
    block() // this is copied into testInline()
    println("inlineFunction: After block") // skipped if `return` is called in block
}

fun testInline() {
    inlineFunction {
        println("inlineFunction block: Hello")
        return  // ✅ exits testInline() directly (non-local return allowed)
    }
    println("testInline: This won't be printed") // unreachable
}

/////////////////////
// CROSSINLINE
/////////////////////

/**
 * `crossinline` prevents non-local returns in lambdas,
 * useful when passing the lambda to another execution context (like a thread or Runnable).
 */
inline fun runWithCrossinline(crossinline block: () -> Unit) {
    println("runWithCrossinline: Before Runnable")

    val runnable = Runnable {
        println("Runnable is executing:")
        block()  // ✅ executes but cannot use `return`
        // return ❌ not allowed
    }

    runnable.run()
    println("runWithCrossinline: After Runnable")
}

fun testCrossinline() {
    runWithCrossinline {
        println("crossinline block: Hello from Runnable")
        // return ❌ would be a compile error
    }

    println("testCrossinline: Done")
}

/////////////////////
// NOINLINE
/////////////////////

/**
 * `noinline` prevents inlining, keeping the lambda as an object.
 * Required if you want to store or pass the lambda around.
 */
inline fun mixedInlineNoinline(
    inlineBlock: () -> Unit,
    noinline nonInlinedBlock: () -> Unit
) {
    println("mixedInlineNoinline: Start")
    inlineBlock()       // this gets inlined at call site
    nonInlinedBlock()   // this stays as a lambda object
    println("mixedInlineNoinline: End")
}

fun testNoinline() {
    val lambda = {
        println("noinline block: Running")
    }

    mixedInlineNoinline(
        inlineBlock = {
            println("inline block: Running")
        },
        nonInlinedBlock = lambda
    )

    println("testNoinline: Done")
}

/////////////////////
// NULL SAFETY
/////////////////////

/**
 * Demonstrates Kotlin null safety using:
 * - Safe calls (`?.`)
 * - Elvis operator (`?:`)
 * - Non-null assertion (`!!`)
 * - Nullable casting (`as?`)
 * - Filtering nulls from collections
 */
fun testNullSafety() {
    var b: String? = "Kotlin"
    if (b != null && b.length > 0) {
        println("String of length ${b.length}")
    } else {
        println("Empty string")
    }

    b = null
    println(b?.length)         // Safe call: returns null
    println(b?.length ?: 0)    // Elvis operator: fallback to 0
    b = "kkk"
    println(b!!.length)        // Non-null assertion: throws if null

    val person: Person? = null
    println(person.toString()) // Prints "null"

    // Nullable list with let check
    val listWithNulls: List<String?> = listOf("Kotlin", null, "Kartik")
    for (item in listWithNulls) {
        item?.let { println(it) } // Print only non-null items
    }

    // Safe casting
    val a: Any = "Hello, Kotlin!"
    val aInt: Int? = a as? Int     // Cast fails, returns null
    val aString: String? = a as? String // Succeeds

    println(aInt)     // null
    println(aString)  // Hello, Kotlin!

    // Filtering nulls
    val stringList: List<String> = listWithNulls.filterNotNull()
    println(stringList)  // [Kotlin, Kartik]
}

data class Person(val name: String)
