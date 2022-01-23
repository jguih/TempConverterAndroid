package com.example.temperatureconverterv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.example.temperatureconverterv2.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    // Var for storing the currentInput
    private var currentInput: Float? = null
    // This DecimalFormat determines how all the float numbers will be formatted
    private val floatFormat = DecimalFormat("#.##")
    private val t = TempConverter(floatFormat)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create listeners for each text input
        //   Celsius listener
        binding.celsiusTextInput.doAfterTextChanged { _ ->
            if(binding.celsiusTextInput.hasFocus()) {
                Log.d("focus","celsiusTextInput has focus")
                // Gets the current input
                currentInput = binding.celsiusTextInput.text.toString().toFloatOrNull()
                // Clear the current input on Kelvin and Fahrenheit's editText
                binding.kelvinTextInput.text?.clear()
                binding.fahrenheitTextInput.text?.clear()
                if(currentInput != null) {
                    // Convert the current Celsius input to Fahrenheit and Kelvin and insert them
                    binding.fahrenheitTextInput.text?.insert(0, t.convertCtoF(currentInput!!))
                    binding.kelvinTextInput.text?.insert(0, t.convertCtoK(currentInput!!))
                }
            }
        }
        //   Fahrenheit listener
        binding.fahrenheitTextInput.doAfterTextChanged { _ ->
            if(binding.fahrenheitTextInput.hasFocus()) {
                Log.d("focus","fahrenheitTextInput has focus")
                // Gets the current input
                currentInput = binding.fahrenheitTextInput.text.toString().toFloatOrNull()
                // Clear the current input on Celsius and Kelvin's editText
                binding.celsiusTextInput.text?.clear()
                binding.kelvinTextInput.text?.clear()
                if(currentInput != null) {
                    // Convert the current Fahrenheit input to Celsius and Kelvin and insert them
                    binding.celsiusTextInput.text?.insert(0, t.convertFtoC(currentInput!!))
                    binding.kelvinTextInput.text?.insert(0, t.convertFtoK(currentInput!!))
                }
            }
        }
        //   Kelvin listener
        binding.kelvinTextInput.doAfterTextChanged { _ ->
            if(binding.kelvinTextInput.hasFocus()) {
                Log.d("focus","kelvinTextInput has focus")
                // Gets the current input
                currentInput = binding.kelvinTextInput.text.toString().toFloatOrNull()
                // Clear the current input on Celsius and Fahrenheit's editText
                binding.celsiusTextInput.text?.clear()
                binding.fahrenheitTextInput.text?.clear()
                if(currentInput != null) {
                    // Convert the current Fahrenheit input to Celsius and Kelvin and insert them
                    binding.celsiusTextInput.text?.insert(0, t.convertKtoC(currentInput!!))
                    binding.fahrenheitTextInput.text?.insert(0, t.convertKtoF(currentInput!!))
                }
            }
        }
    }
}