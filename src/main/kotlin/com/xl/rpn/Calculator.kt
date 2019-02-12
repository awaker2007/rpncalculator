package com.xl.rpn

import java.math.BigDecimal
import java.util.*


interface Calculator {

    fun input(line:String)

    fun input(opts:MutableList<Operator>)

    fun printStack()

    fun stack(): Stack<BigDecimal>

}