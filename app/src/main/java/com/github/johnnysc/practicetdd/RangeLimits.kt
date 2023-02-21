package com.github.johnnysc.practicetdd

interface RangeLimits {

    fun pair(number: Int): RangePair

    class Base(private val list: List<Int>) : RangeLimits {

        override fun pair(number: Int): RangePair {
            var left = Int.MIN_VALUE
            var right = Int.MAX_VALUE

            if (list.isEmpty()) return RangePair(left, right)
            if (list.size == 1 && list.contains(number)) return RangePair(left, right)

            for (searchNumber in list) {
                if (searchNumber < number) {
                    left = searchNumber
                } else if (searchNumber > number) {
                    right = searchNumber
                    break
                }
            }

            return RangePair(left, right)
        }
    }
}

data class RangePair(private val left: Int, private val right: Int)