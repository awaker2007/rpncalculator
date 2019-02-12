package com.xl.rpn.operators

import java.math.BigDecimal

class MultArithmetic (position: Int): TwoNumberArithmetic(position) {

    override fun doArithmetic(d1: BigDecimal, d2: BigDecimal): BigDecimal {

        return d1.multiply(d2)
    }

}