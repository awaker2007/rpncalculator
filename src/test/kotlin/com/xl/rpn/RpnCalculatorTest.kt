package com.xl.rpn

import org.junit.Test
import java.math.BigDecimal
import java.util.*

class RpnCalculatorTest {

    fun eq(s1: Stack<BigDecimal>, s2: Stack<BigDecimal>):Boolean {
        if(s1.size != s2.size)
            return false

        for(i in 0..s1.size - 1) {
            if(s1[i].compareTo(s2[i]) != 0) {
                return false
            }
        }

        return true
    }

    fun stack(vararg numbers:Number):Stack<BigDecimal> {
        val result = Stack<BigDecimal>()
        numbers.forEach {
            result.push(BigDecimal(it.toDouble()))
        }
        return result
    }

    @Test
    fun addTest() {
        val calculator = RpnCalculator()
        calculator.input("1 2 +")
        assert(eq(calculator.stack(), stack(3)))
    }

    @Test
    fun subTest() {
        val calculator = RpnCalculator()
        calculator.input("1 2 -")
        assert(eq(calculator.stack(), stack(-1)))
    }

    @Test
    fun multTest() {
        val calculator = RpnCalculator()
        calculator.input("2 2 *")
        assert(eq(calculator.stack(), stack(4)))
    }

    @Test
    fun divideTest() {
        val calculator = RpnCalculator()
        calculator.input("12 2 /")
        assert(eq(calculator.stack(), stack(6)))
        println("aaa")
        calculator.input("0 /")
        assert(eq(calculator.stack(), stack(6, 0)))
    }

    @Test
    fun sqrtTest() {
        val calculator = RpnCalculator()
        calculator.input("6 9 sqrt")
        assert(eq(calculator.stack(), stack(6, 3)))
    }

    @Test
    fun clearTest() {
        val calculator = RpnCalculator()
        calculator.input("12 2 clear")
        assert(eq(calculator.stack(), Stack()))
    }

    @Test
    fun undoTest() {
        val calculator = RpnCalculator()
        calculator.input("12 2 3 undo")
        assert(eq(calculator.stack(), stack(12, 2)))
    }

    @Test
    fun complexTest() {
        val calculator = RpnCalculator()
        calculator.input("12 2 3 +")
        calculator.input("4 *")
        calculator.input("+")
        calculator.input("undo")
        assert(eq(calculator.stack(), stack(12, 20)))
    }

}