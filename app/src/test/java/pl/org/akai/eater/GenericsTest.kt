package pl.org.akai.eater

import org.junit.Test

class GenericsTest {

    class MutableStack<E>(vararg items: E) {              // 1

        private val elements = items.toMutableList()

        fun push(element: E) = elements.add(element)        // 2

        fun peek(): E = elements.last()                     // 3

        fun pop(): E = elements.removeAt(elements.size - 1)

        fun isEmpty() = elements.isEmpty()

        fun size() = elements.size

        override fun toString() = "MutableStack(${elements.joinToString()})"
    }

    fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

    @Test
    fun main() {
        val stack = mutableStackOf(0.62, 3.14, 2.7)
        println(stack)

        val stackImion = mutableStackOf("Kasia", "Asia", "Małgosia")
        println(stackImion)
    }
}