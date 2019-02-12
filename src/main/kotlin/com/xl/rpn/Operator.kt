package com.xl.rpn

import java.math.BigDecimal
import java.util.*

interface Operator {

    fun doOpt(stack: Stack<BigDecimal>, history:Stack<() -> Unit>)

    fun position():Int

}

