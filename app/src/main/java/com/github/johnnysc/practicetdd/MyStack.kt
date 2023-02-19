package com.github.johnnysc.practicetdd

interface MyStack<T> {

    fun push(item: T)
    fun pop(): T

    class LIFO<T>(private val maxCount: Int) : MyStack<T> {

        private val array: Array<Any?>
        private var position = 0

        init {
            if (maxCount <= 0) {
                throw IllegalStateException("maxCount should be positive!")
            }
            array = arrayOfNulls<Any?>(maxCount)
        }

        override fun push(item: T) {
            if (position == maxCount) {
                throw IllegalStateException("Stack overflow exception, maximum is $maxCount")
            }

            array[position] = item
            position++
        }

        override fun pop(): T {
            if (position == 0) {
                throw IllegalStateException("array is empty")
            }

            val item = array[--position] as T
            array[position] = null

            return item
        }
    }

    class FIFO<T>(private val maxCount: Int) : MyStack<T> {

        private val array: Array<Any?>
        private var position = 0

        init {
            if (maxCount <= 0) {
                throw IllegalStateException("maxCount should be positive!")
            }
            array = arrayOfNulls<Any?>(maxCount)
        }

        override fun push(item: T) {
            if (position == maxCount) {
                throw IllegalStateException("Stack overflow exception, maximum is $maxCount")
            }

            array[position++] = item
        }

        override fun pop(): T {
            if (position == 0) {
                throw IllegalStateException("array is empty")
            }

            val item = array[maxCount - position] as T
            position--
            return item
        }
    }
}