package pl.org.akai.eater

import io.mockk.InternalPlatformDsl.toArray
import org.junit.Test

class IntroTest {

    @Test
    fun hello_world() {
        println("Hello world!")
        print("Hello world")
        println("Hello world!")
    }

    @Test
    fun val_var() {
        var a: String = "initial"
        println(a)
        val b: Int = 1
        val c = 3
        var zmienna = 0
//        b += c
//        zmienna += a
        zmienna += b
        print(a)
        print(zmienna)
    }

    @Test
    fun dataTypes() {
//        var zmienna
        var zmienna: Int
//        println(zmienna)
        zmienna = 5
        var zmienna_nullable: Int?
        zmienna_nullable = null
        zmienna += zmienna_nullable ?: 0
        println(zmienna)
    }

    @Test
    fun printData() {
        val slowo: String = "Kotlin"
        println("Hello $slowo!")
        println("Hello ${slowo.uppercase()}!")
        val zdanie = "Hello, ${slowo.toCharArray()}! Length ${slowo.length}"
        println(zdanie)
    }

    @Test
    fun control_flow() {
        var slowo: String? = null
        if (slowo.isNullOrBlank()) {
            slowo = "null"
        } else {
            slowo = "nie null"
        }
        println(slowo)

        when(slowo) {
            "null" -> { println("BYŁO NULLEM") }
            "nie null" -> { println("Nie było nullem" )
            }
        }

        when {
            slowo == "null" -> {
                println("BYŁO NULLEM")
            }
            else -> {
                println("Nie było nullem")
            }
        }
    }

    @Test
    fun loops() {
        val slowo = "test"

        for (i in slowo) {
            println(i)
        }

        for (i in 1 .. 9) {
            println(i)
        }

        for (i in 1 until 9) {
            println(i)
        }

        for (i in 9 downTo 1) {
            println(i)
        }

        var i = 3
        while (i > -2) {
            println(i)
            i--
        }
    }

    @Test
    fun arrays() {
//        val list = listOf<Objects>()
        val list = listOf<Int>(1, 2, 3,45)
        val map = hashMapOf<Int, Int>()
        var arrayList = ArrayList<String>()
        println(arrayList)
        arrayList = arrayListOf()
        println(arrayList)
        val array = arrayListOf<Int>()
        array.add(2)
        array.add(5)
        array.remove(2)
        array.add(18)
        println(array)
        array.forEach { println(it) }
        array.forEach { liczba ->
            printSomething(liczba)
        }
    }

    fun printSomething(something: Int): Unit {
        return println(something)
    }

    fun addition(x: Int, y: Int) :Int {
        return x + y
    }

    @Test
    fun pringArg() {
        printArgument()
        printArgument("ARGUMENT")
    }

    fun printArgument(arg: String = "No arg") {
        println(arg)
    }
}