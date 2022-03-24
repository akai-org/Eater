package pl.org.akai.eater

import org.junit.Test
class FunctionTest {

    fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
        return operation(x, y)
    }

    fun sum(x: Int, y: Int) = x + y

    @Test
    fun main() {
        val sumResult = calculate(4, 5, ::sum)
        val mulResult = calculate(4, 5) { a, b -> a * b }
        println("sumResult $sumResult, mulResult $mulResult")
    }

    val upperCase1: (String) -> String = { str: String -> str.uppercase() } // 1

    val upperCase2: (String) -> String = { str -> str.uppercase() }         // 2

    val upperCase3 = { str: String -> str.uppercase() }                     // 3

// val upperCase4 = { str -> str.uppercase() }                          // 4

    val upperCase5: (String) -> String = { it.uppercase() }                 // 5

    val upperCase6: (String) -> String = String::uppercase                  // 6

    @Test
    fun lambdas() {
        println(upperCase1("hello"))
        println(upperCase2("hello"))
        println(upperCase3("hello"))
        println(upperCase5("hello"))
        println(upperCase6("hello"))
    }

}

