package com.example.calculator

sealed class CalculatorOperation(val symbol: String) {
    object Addition: CalculatorOperation("+")
    object Subtraction: CalculatorOperation("-")
    object Multiplication: CalculatorOperation("x")
    object Division: CalculatorOperation("/")

}
