package com.example.temperatureconverterv2

import android.util.Log
import java.math.RoundingMode

class TempConverter {
    // This class implements all methods that converts temperatures
    //   The returned Float values gets formatted based on input's number of decimal values

    private fun tempFormatter(convertedTemp: Float, input: Float): Float {
        // Format the converted Float value based on decimal values on user's input
        return convertedTemp
            .toBigDecimal().setScale(input.toBigDecimal().scale(), RoundingMode.HALF_EVEN).toFloat()
    }

    fun convertKtoF(input: Float): Float {
        Log.d("convert","converting K to F")
        // Converts Kelvin to Fahrenheit
        return tempFormatter((input - 273.15f) * 9f/5 + 32, input)
    }

    fun convertKtoC(input: Float): Float {
        Log.d("convert","converting K to C")
        // Converts Kelvin to Celsius
        return tempFormatter(input - 273.15f, input)
    }

    fun convertCtoF(input: Float): Float {
        Log.d("convert","converting C to F")
        // Converts Celsius to Fahrenheit
        return tempFormatter((input * 9f/5) + 32, input)
    }

    fun convertCtoK(input: Float): Float {
        Log.d("convert","converting C to K")
        // Converts Celsius to Kelvin
        return tempFormatter(input + 273.15f, input)
    }

    fun convertFtoK(input: Float): Float {
        Log.d("convert","converting F to K")
        // Converts Fahrenheit to Kelvin
        return tempFormatter((input - 32) * (5f/9) + 273.15f, input)
    }

    fun convertFtoC(input: Float): Float {
        Log.d("convert","converting F to C")
        // Converts Fahrenheit and Celsius
        return tempFormatter((input - 32) * (5f/9), input)
    }
}