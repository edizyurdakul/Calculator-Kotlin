package com.example.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Calculator(
    state: CalculatorState,
    modifier: Modifier,
    buttonSpacing: Dp = 16.dp,
    onAction: (CalculatorAction) -> Unit
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center), verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.firstNumber + (state.operation?.symbol ?: "") + state.secondNumber,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp).weight(1f),
                fontWeight = FontWeight.Light,
                fontSize = 64.sp,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 2,

            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Button(
                    symbol = "AC",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.inversePrimary)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Clear)
                    })
                Button(
                    symbol = "DEL",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.inversePrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Delete)
                    })
                Button(
                    symbol = "/",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.inversePrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Division))
                    })
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Button(
                    symbol = "7",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(7))
                    })
                Button(
                    symbol = "8",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(8))
                    })
                Button(
                    symbol = "9",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(9))
                    })
                Button(
                    symbol = "X",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.inversePrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiplication))
                    })
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Button(
                    symbol = "4",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(4))
                    })
                Button(
                    symbol = "5",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(5))
                    })
                Button(
                    symbol = "6",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(6))
                    })
                Button(
                    symbol = "-",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.inversePrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtraction))
                    })
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Button(
                    symbol = "1",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(1))
                    })
                Button(
                    symbol = "2",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(2))
                    })
                Button(
                    symbol = "3",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Number(3))
                    })
                Button(
                    symbol = "+",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.inversePrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Addition))
                    })
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Button(
                    symbol = "0",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(2f)
                        .weight(2f),
                    onClick = {
                        onAction(CalculatorAction.Number(0))
                    })
                Button(
                    symbol = ".",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primaryContainer)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Decimal)
                    })
                Button(
                    symbol = "=",
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.inversePrimary)
                        .aspectRatio(1f)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorAction.Calculate)
                    })
            }
        }
    }
}