package com.xl.rpn.operators

import com.xl.rpn.Operator
import java.math.BigDecimal
import java.util.*
import java.math.RoundingMode
import java.math.MathContext



class SqrtArithmetic (var position: Int): Operator {

    override fun position(): Int {
        return position
    }


    override fun doOpt(stack: Stack<BigDecimal>, history: Stack<() -> Unit>) {
        if(stack.size < 1) {
            throw Exception("operator sqrt (position: $position): insucient parameters ")
        }

        val d = stack.pop()
        val result = sqrt(d, 15)
        stack.push(result)
        history.push {
            stack.pop()
            stack.push(d)
        }
    }

    fun sqrt(number: BigDecimal, scale: Int): BigDecimal {
        val base = BigDecimal.valueOf(2.0)
        val precision = 100
        val mc = MathContext(precision, RoundingMode.HALF_UP)
        var deviation = number
        var cnt = 0
        while (cnt < 100) {
            deviation = deviation.add(number.divide(deviation, mc)).divide(base, mc)
            cnt++
        }
        deviation = deviation.setScale(scale, BigDecimal.ROUND_HALF_UP)
        return deviation
    }



}