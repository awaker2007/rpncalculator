package com.xl.rpn

import java.io.InputStreamReader
import java.io.BufferedReader



fun main(args: Array<String>) {
    println("Welcome, please enter rpn mode numbers or operators:")
    val calculator = RpnCalculator()
    val input = BufferedReader(InputStreamReader(System.`in`));
    var line = input.readLine()
    while (!line.contentEquals("exit")) {
        calculator.input(line)
        line = input.readLine()
    }
}

