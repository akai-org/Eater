package pl.org.akai.eater

import org.junit.Test
import kotlin.reflect.KProperty

class DelegatesTest {

    class Example {
        var p: String by Delegate()                                               // 1

        override fun toString() = "Example Class"
    }

    class Delegate() {
        operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {        // 2
            return "$thisRef, thank you for delegating '${prop.name}' to me!"
        }

        operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) { // 2
            println("$value has been assigned to ${prop.name} in $thisRef")
        }
    }

    @Test
    fun main() {
        val e = Example()
        println(e.p)
        e.p = "NEW"
    }

    class LazySample {
        init {
            println("created!")            // 1
        }

        val lazyStr: String by lazy {
            println("computed!")          // 2
            "my lazy"
        }
    }

    @Test
    fun main2() {
        val sample = LazySample()         // 1
        println("lazyStr = ${sample.lazyStr}")  // 2
        println(" = ${sample.lazyStr}")  // 3
    }
}