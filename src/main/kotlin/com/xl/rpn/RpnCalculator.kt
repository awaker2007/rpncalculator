package com.xl.rpn

import com.xl.rpn.operators.*
import java.math.BigDecimal
import java.text.DecimalFormat
import java.util.*
import java.util.stream.Collectors


class RpnCalculator:Calculator {
    val stack = Stack<BigDecimal>()
    val history = Stack<() -> Unit>()

    override fun stack(): Stack<BigDecimal> {
        return stack
    }

    override fun input(line: String) {
        val arr = line.trim().split("\\s+".toRegex())
        val inputs = mutableListOf<Operator>()
        for(i in 0..arr.size - 1) {
            val s = arr[i].trim()
            if(s.length == 0)
                continue

            try {
                val number = s.toBigDecimal()
                inputs.add(Digit(number, i + 1))
            } catch (e:Throwable) {
                when {
                    s.contentEquals("+") -> inputs.add(AddArithmetic(i + 1))
                    s.contentEquals("-") -> inputs.add(SubArithmetic(i + 1))
                    s.contentEquals("*") -> inputs.add(MultArithmetic(i + 1))
                    s.contentEquals("/") -> inputs.add(DivideArithmetic(i + 1))
                    s.contentEquals("sqrt") -> inputs.add(SqrtArithmetic(i + 1))
                    s.contentEquals("clear") -> inputs.add(ClearOperator(i + 1))
                    s.contentEquals("undo") -> inputs.add(UndoOperator(i + 1))
                    else -> println("not support operator:$s")
                }
            }
        }

        input(inputs)
    }

    override fun input(opts: MutableList<Operator>) {
        if(opts.isEmpty())
            return

        try {
            opts.forEach {
                it.doOpt(stack, history)
            }
        } catch (e:Exception) {
            println(e.message)
        } finally {
            printStack()
        }
    }

    override fun printStack() {
        val format = DecimalFormat.getInstance();
        format.setMaximumFractionDigits(10);
        format.setMinimumFractionDigits(0);
        val log = stack.stream().map { format.format(it) }.collect(Collectors.joining(" "))
        println("stack:$log")

    }
}