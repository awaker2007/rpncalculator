package com.xl.rpn.operators

import com.xl.rpn.Operator
import java.math.BigDecimal
import java.util.*

class UndoOperator (var position:Int): Operator {

    override fun doOpt(stack: Stack<BigDecimal>, history: Stack<() -> Unit>) {
        if(!history.isEmpty()) {
            history.pop().invoke()
        }
        else {
            println("can not undo, it is the first operator!")
        }
    }

    override fun position(): Int {
        return position
    }

}