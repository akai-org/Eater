package pl.org.akai.eater

import org.junit.Test

class ClassesTest {

    class Person(name: String, age: Int) {
        private val pesel = 123
        val signature = "Best Regards\n$name $age $pesel"
        fun sign() {
            println(signature)
        }
    }

    @Test
    fun classTest() {
        var person: Person? = null
        person = Person("Jan", 5)
        person.sign()
    }

    data class Payment (
        val date: Long = System.currentTimeMillis(),
        var person: Person
    )

    @Test
    fun dataClassTest() {
        val payment = Payment(person = Person("Janek", 7))
        val payment2 = Payment(System.currentTimeMillis(), Person("Janek", 7))
    }

    interface Api {
        fun callApi()
    }

    abstract class DataSource() {
        abstract val file: String
    }

    class DataGetter(override val file: String): DataSource(), Api {
        override fun callApi() {
            println("Calling")
        }
    }

    object SharedPrefs {
        val money = 15
    }

    enum class Tired {
        TROCHE, BARDZO
    }

    enum class Response {
        OK, NOTFOUND, PREMISSIONDENIED
    }

    sealed class Mammal(val name: String) {                                              // 1

        class Cat(val catName: String) : Mammal(catName)                                        // 2
        class Human(val humanName: String, val job: String) : Mammal(humanName)
    }

    fun greetMammal(mammal: Mammal): String {
        when (mammal) {                                                                     // 3
            is Mammal.Human -> return "Hello ${mammal.name}; You're working as a ${mammal.job}"    // 4
            is Mammal.Cat -> return "Hello ${mammal.name}"                                         // 5
        }                                                                                   // 6
    }

    @Test
    fun TestClasses() {
        SharedPrefs.money
        Tired.BARDZO
        Tired.TROCHE

        val message = greetMammal(Mammal.Human("Imie", "Programista"))
        println(message)


        val response: Response = Response.OK
        when(response) {
            Response.OK -> TODO()
            Response.NOTFOUND -> TODO()
            Response.PREMISSIONDENIED -> TODO()
        }
    }
}