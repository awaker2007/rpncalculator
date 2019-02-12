package com.xl.rpn.operators

import java.math.BigDecimal
import java.math.RoundingMode

class DivideArithmetic  (position: Int): TwoNumberArithmetic(position) {

    override fun doArithmetic(d1: BigDecimal, d2: BigDecimal): BigDecimal {
        return d2.divide(d1, 15, RoundingMode.HALF_UP)
    }

}