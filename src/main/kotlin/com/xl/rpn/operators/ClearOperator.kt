package com.xl.rpn.operators

import com.xl.rpn.Operator
import java.math.BigDecimal
import java.util.*
import java.util.stream.Collectors

class ClearOperator(var position:Int): Operator {

    override fun doOpt(stack: Stack<BigDecimal>, history: Stack<() -> Unit>) {
        val eles = stack.stream().collect(Collectors.toList())
        history.push {
            stack.addAll(eles)
        }
        stack.removeAllElements()
    }

    override fun position(): Int {
        return position
    }

}