package com.xl.rpn.operators

import com.xl.rpn.Operator
import java.math.BigDecimal
import java.util.*

abstract class TwoNumberArithmetic(var position: Int): Operator {

    override fun position(): Int {
        return position
    }

    abstract fun doArithmetic(d1:BigDecimal, d2:BigDecimal):BigDecimal

    override fun doOpt(stack: Stack<BigDecimal>, history: Stack<() -> Unit>) {
        if(stack.size < 2) {
            throw Exception("operator + (position: $position): insucient parameters ")
        }

        val d1 = stack.pop()
        val d2 = stack.pop()

        var result:BigDecimal? = null
        try {
            result = doArithmetic(d1, d2)
        } catch (e:Exception) {
            stack.push(d2)
            stack.push(d1)
            throw e
        }
        history.push {
            stack.pop()
            stack.push(d2)
            stack.push(d1)
        }
        stack.push(result)


    }

}