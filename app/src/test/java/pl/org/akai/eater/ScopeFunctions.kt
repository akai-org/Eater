package pl.org.akai.eater

import org.junit.Test

class ScopeFunctions {

    //let, run. with, apply, also

    val empty = "test".let {               // 1
        println(it)                    // 2
        it.isEmpty()                       // 3
    }


    fun printNonNull(str: String?) {
        println("Printing \"$str\":")

        str?.let {                         // 4
            print("\t")
            println(it)
            println()
        }
    }

    fun printIfBothNonNull(strOne: String?, strTwo: String?) {
        strOne?.let { firstString ->       // 5
            strTwo?.let { secondString ->
                println("$firstString : $secondString")
                println()
            }
        }
    }

    @Test
    fun testLet() {
        printNonNull(null)
        printNonNull("my string")
        printIfBothNonNull("First", "Second")
    }


    fun getNullableLength(ns: String?) {
        println("for \"$ns\":")
        ns?.run {                                                  // 1
            println("\tis empty? " + isEmpty())                    // 2
            println("\tlength = $length")
            length                                                 // 3
        }
    }
    @Test
    fun testRun() {
        getNullableLength(null)
        getNullableLength("")
        getNullableLength("some string with Kotlin")
    }

    @Test
    fun testWithAndApplyAndAlso() {
        data class Configuration(
            var host: String = "127.68.0.0.1",
            var port: String = "8080"
        )
        with(Configuration()) {
            println("$host:$port")
        }

        val conf = Configuration()
        val stringDescription = conf.apply {
            host = "HOST"
            port = "1221"
        }.toString()

        val conf2 = Configuration()
            .also {
            println("Utworzono $conf")
        }
    }
}