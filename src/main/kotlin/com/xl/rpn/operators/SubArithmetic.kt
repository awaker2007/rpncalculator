package com.xl.rpn.operators

import java.math.BigDecimal

class SubArithmetic (position: Int): TwoNumberArithmetic(position) {

    override fun doArithmetic(d1: BigDecimal, d2: BigDecimal): BigDecimal {
        return d2.subtract(d1)
    }

}