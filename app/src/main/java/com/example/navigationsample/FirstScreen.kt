package com.example.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FirstScreen(
    navigationToSecondScreen: (name: String, age: Int) -> Unit,
    navigationToThirdScreen: (name: String, age: Int) -> Unit
) {
    var name by remember {
        mutableStateOf("")
    }

    var ageText by remember {
        mutableStateOf("")
    }

    val age = ageText.toIntOrNull() ?: 0


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is the first screen", fontSize = 24.sp)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value = name, onValueChange = {
            name = it
        })

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = ageText,
            onValueChange = { newValue ->
                if (newValue.isEmpty() || newValue.all { it.isDigit() }) {
                    ageText = newValue
                }
            },
            label = { Text("Age") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navigationToSecondScreen(name, age)
        }) {
            Text("Go to the second screen")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            navigationToThirdScreen(name, age)
        }) {
            Text("Go to the third screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FirstPreview() {
    FirstScreen(
        { _, _ -> },
        { _, _ -> }
    )
}