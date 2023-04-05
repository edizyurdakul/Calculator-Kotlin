package com.example.calculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {
    var state by mutableStateOf(CalculatorState())
        private set

    fun onAction(action: CalculatorAction) {
        when (action) {
            is CalculatorAction.Number -> enterNumber(action.number)
            is CalculatorAction.Decimal -> enterDecimal()
            is CalculatorAction.Clear -> state = CalculatorState()
            is CalculatorAction.Operation -> enterOperation(action.operation)
            is CalculatorAction.Calculate -> performCalculation()
            is CalculatorAction.Delete -> performDelete()
        }
    }

    private fun performDelete() {
        when {
            state.secondNumber.isNotBlank() -> state =
                state.copy(secondNumber = state.secondNumber.dropLast(1))
            state.operation != null -> state = state.copy(
                operation = null
            )
            state.firstNumber.isNotBlank() -> state = state.copy(
                firstNumber = state.firstNumber.dropLast(1)
            )
        }
    }

    private fun performCalculation() {
        val firstNumber = state.firstNumber.toDoubleOrNull()
        val secondNumber = state.secondNumber.toDoubleOrNull()

        if(firstNumber != null && secondNumber != null){
            val result = when(state.operation){
                is CalculatorOperation.Addition -> firstNumber + secondNumber
                is CalculatorOperation.Subtraction -> firstNumber - secondNumber
                is CalculatorOperation.Multiplication -> firstNumber * secondNumber
                is CalculatorOperation.Division -> firstNumber / secondNumber
                null -> return
            }
            state = state.copy(
                firstNumber =  result.toString().take(15),
                secondNumber = "",
                operation = null
            )
        }
    }

    private fun enterOperation(operation: CalculatorOperation) {
        if (state.firstNumber.isNotBlank()) {
            state = state.copy(operation = operation)
        }
    }

    private fun enterDecimal() {
        if (state.operation == null && !state.firstNumber.contains(".") && state.firstNumber.isNotBlank()) {
            state = state.copy(
                firstNumber = state.firstNumber + "."
            )
            return
        }
        if (!state.secondNumber.contains(".") && state.secondNumber.isNotBlank()) {
            state = state.copy(
                secondNumber = state.secondNumber + "."
            )
        }
    }

    private fun enterNumber(number: Int) {
        if(state.operation == null){
            if(state.firstNumber.length >= MAX_NUM_LENGTH){
                return
            }
            state = state.copy(
                firstNumber = state.firstNumber + number
            )
            return
        }
        if(state.secondNumber.length >= MAX_NUM_LENGTH ){
            return
        }
        state = state.copy(
            secondNumber = state.secondNumber + number
        )
    }

    companion object{
        private const val MAX_NUM_LENGTH = 8
    }
}