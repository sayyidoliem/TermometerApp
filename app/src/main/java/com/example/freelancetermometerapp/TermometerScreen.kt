package com.example.freelancetermometerapp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Termometer(){
    var inputCelsius by remember { mutableStateOf("") }
    val temperatureConvertCelcius = inputCelsius.toFloatOrNull()

    var inputReamur by remember { mutableStateOf("") }
    val temperatureConvertReamur = inputReamur.toDoubleOrNull()

    var inputFahrenheit by remember { mutableStateOf("") }
    val temperatureConvertFahrenheit = inputFahrenheit.toFloatOrNull()

    var inputKelvin by remember { mutableStateOf("") }
    val temperatureConvertKelvin = inputKelvin.toFloatOrNull()

    LazyColumn(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        item{
            OutlinedTextField(
                value = inputCelsius,
                onValueChange = { inputCelsius = it },
                label = { Text("Masukkan suhu dalam Celcius") }
            )
            Spacer(Modifier.height(16.dp))
            if (temperatureConvertCelcius != null) {
                Text(text = "Reamur: ${temperatureConvertCelcius * 4 / 5}")
                Text(text = "Fahrenheit: ${temperatureConvertCelcius * 9 / 5 + 32}")
                Text(text = "Kelvin: ${temperatureConvertCelcius + 273.15}")
            }
        }
        item {
            OutlinedTextField(
                value = inputReamur,
                onValueChange = { inputReamur = it },
                label = { Text("Masukkan suhu dalam Reamur") }
            )
            Spacer(Modifier.height(16.dp))
            if (temperatureConvertReamur != null) {
                Text(text = "Celsius: ${temperatureConvertReamur * 5.0 / 4.0}")
                Text(text = "Fahrenheit: ${temperatureConvertReamur * 9.0 / 4.0 + 32}")
                Text(text = "Kelvin: ${temperatureConvertReamur * 5.0 / 4.0 + 273.15}")
            }
        }

        item {
            OutlinedTextField(
                value = inputFahrenheit,
                onValueChange = { inputFahrenheit = it },
                label = { Text("Masukkan suhu dalam Fahrenheit") }
            )
            Spacer(Modifier.height(16.dp))
            if (temperatureConvertFahrenheit != null) {
                Text(text = "Celsius: ${(temperatureConvertFahrenheit -32) * 5 / 9}")
                Text(text = "Reamur: ${(temperatureConvertFahrenheit -32) * 4 / 9}")
            }
        }

        item {
            OutlinedTextField(
                value = inputKelvin,
                onValueChange = { inputKelvin = it },
                label = { Text("Masukkan suhu dalam Kelvin") }
            )
            Spacer(Modifier.height(16.dp))
            if (temperatureConvertKelvin != null) {
                Text(text = "Celsius: ${temperatureConvertKelvin - 273}")
                Text(text = "Reamur: ${(temperatureConvertKelvin - 273) * 4 / 5}")
            }
        }

    }
}