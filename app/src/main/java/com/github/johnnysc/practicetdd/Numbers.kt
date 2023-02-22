package com.github.johnnysc.practicetdd

interface Numbers {

    fun minimum(): Int
    fun maximum(): Int

    class Base(private val first: Int, private val second: Int) : Numbers {

        override fun minimum(): Int {
            return if (first < second) first else second
        }

        override fun maximum(): Int {
            return if (first > second) first else second
        }
    }

    class List(private val list: kotlin.collections.List<Int>) : Numbers {

        override fun minimum(): Int {
            var minimum = if (list.isEmpty()) Int.MIN_VALUE else Int.MAX_VALUE
            list.forEach {
                if (it < minimum) {
                    minimum = it
                }
            }

            return minimum
        }

        override fun maximum(): Int {
            var maximum = if (list.isEmpty()) Int.MAX_VALUE else Int.MIN_VALUE
            list.forEach {
                if (it > maximum) {
                    maximum = it
                }
            }

            return maximum
        }
    }
}