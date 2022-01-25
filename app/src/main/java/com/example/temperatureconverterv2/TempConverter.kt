package com.example.temperatureconverterv2

import android.util.Log
import java.text.DecimalFormat
import java.text.NumberFormat

class TempConverter(private val floatFormat: DecimalFormat) {
    // This class implements all methods that converts temperatures
    //   The returned Float values gets formatted based on input's number of decimal values

    private fun tempFormatter(convertedTemp: Float): String {
        return floatFormat.format(convertedTemp)
    }

    fun convertKtoF(input: Float): String {
        Log.d("convert","converting K to F")
        // Converts Kelvin to Fahrenheit
        return tempFormatter((input - 273.15f) * 9f/5 + 32)
    }

    fun convertKtoC(input: Float): String {
        Log.d("convert","converting K to C")
        // Converts Kelvin to Celsius
        return tempFormatter(input - 273.15f)
    }

    fun convertCtoF(input: Float): String {
        Log.d("convert","converting C to F")
        // Converts Celsius to Fahrenheit
        return tempFormatter((input * 9f/5) + 32)
    }

    fun convertCtoK(input: Float): String {
        Log.d("convert","converting C to K")
        // Converts Celsius to Kelvin
        return tempFormatter(input + 273.15f)
    }

    fun convertFtoK(input: Float): String {
        Log.d("convert","converting F to K")
        // Converts Fahrenheit to Kelvin
        return tempFormatter((input - 32) * (5f/9) + 273.15f)
    }

    fun convertFtoC(input: Float): String {
        Log.d("convert","converting F to C")
        // Converts Fahrenheit and Celsius
        return tempFormatter((input - 32) * (5f/9))
    }
}