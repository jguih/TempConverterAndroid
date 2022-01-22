package com.example.temperatureconverterv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.doOnTextChanged
import com.example.temperatureconverterv2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var currentInput: Float? = null
    private val t = TempConverter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create listeners for each text input
        //   Celsius listener
        binding.celsiusTextInput.doOnTextChanged { text, start, before, count ->
            if(binding.celsiusTextInput.hasFocus()) {
                Log.d("focus","celsiusTextInput has focus")
                // Gets the current input
                currentInput = binding.celsiusTextInput.text.toString().toFloatOrNull()
                // Clear the current input on Kelvin and Fahrenheit's editText
                binding.kelvinTextInput.text?.clear()
                binding.fahrenheitTextInput.text?.clear()
                if(currentInput != null) {
                    // Convert the current Celsius input to Fahrenheit and Kelvin and insert them
                    binding.fahrenheitTextInput.text?.insert(0, t.convertCtoF(currentInput!!).toString())
                    binding.kelvinTextInput.text?.insert(0, t.convertCtoK(currentInput!!).toString())
                }
            }
        }
        //   Fahrenheit listener
        binding.fahrenheitTextInput.doOnTextChanged { text, start, before, count ->
            if(binding.fahrenheitTextInput.hasFocus()) {
                Log.d("focus","fahrenheitTextInput has focus")
                // Gets the current input
                currentInput = binding.fahrenheitTextInput.text.toString().toFloatOrNull()
                // Clear the current input on Celsius and Kelvin's editText
                binding.celsiusTextInput.text?.clear()
                binding.kelvinTextInput.text?.clear()
                if(currentInput != null) {
                    // Convert the current Fahrenheit input to Celsius and Kelvin and insert them
                    binding.celsiusTextInput.text?.insert(0, t.convertFtoC(currentInput!!).toString())
                    binding.kelvinTextInput.text?.insert(0, t.convertFtoK(currentInput!!).toString())
                }
            }
        }
        //   Kelvin listener
        binding.kelvinTextInput.doOnTextChanged { text, start, before, count ->
            if(binding.kelvinTextInput.hasFocus()) {
                Log.d("focus","kelvinTextInput has focus")
                // Gets the current input
                currentInput = binding.kelvinTextInput.text.toString().toFloatOrNull()
                // Clear the current input on Celsius and Fahrenheit's editText
                binding.celsiusTextInput.text?.clear()
                binding.fahrenheitTextInput.text?.clear()
                if(currentInput != null) {
                    // Convert the current Fahrenheit input to Celsius and Kelvin and insert them
                    binding.celsiusTextInput.text?.insert(0, t.convertKtoC(currentInput!!).toString())
                    binding.fahrenheitTextInput.text?.insert(0, t.convertKtoF(currentInput!!).toString())
                }
            }
        }
    }
}