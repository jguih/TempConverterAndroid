package com.example.temperatureconverterv2

import android.content.Context
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.SimpleAdapter
import com.example.temperatureconverterv2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


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