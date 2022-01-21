package com.example.temperatureconverterv2

import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.Log.i
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.SimpleAdapter
import android.widget.TextView
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.widget.doOnTextChanged
import com.example.temperatureconverterv2.databinding.ActivityMainBinding
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.round
import kotlin.math.roundToInt
import kotlin.math.roundToLong

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

    // Intercept all touches on screen
    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_DOWN) {
            // Get the current focused View and clear the focus if it is an EditText
            val v = currentFocus
            if (v is EditText) {
                val outRect = Rect()
                // Get the rectangle around the EditText view
                v.getGlobalVisibleRect(outRect)
                if (!outRect.contains(event.rawX.toInt(), event.rawY.toInt())) {
                    // Clear focus if the touch was outside the current focused EditText view
                    Log.d("focus", "Current focused EditText lost focus, keyboard hidden")
                    v.clearFocus()
                    hideKeyboard(v)
                }
            }
        }
        return super.dispatchTouchEvent(event)
    }

    private fun hideKeyboard(view: View) {
        // Get the input service
        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        // Hide the keyboard
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

}