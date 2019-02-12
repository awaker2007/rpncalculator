package com.xl.rpn.operators

import com.xl.rpn.Operator
import java.math.BigDecimal
import java.util.*


class Digit(var number:BigDecimal, var position: Int): Operator {

    override fun position(): Int {
        return position
    }

    override fun doOpt(stack: Stack<BigDecimal>, history: Stack<() -> Unit>) {
        number.setScale(15, BigDecimal.ROUND_HALF_UP)
        stack.push(number)
        history.push({
            stack.pop()
        })
    }

}