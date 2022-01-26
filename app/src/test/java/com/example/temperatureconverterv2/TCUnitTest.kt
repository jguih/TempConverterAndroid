package com.example.temperatureconverterv2

import org.junit.Test
import org.junit.Assert.*
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class TCUnitTest {

    private val floatFormat = DecimalFormat("#.##", DecimalFormatSymbols(Locale.US))
    private val tempConverter = TempConverter(floatFormat)

    @Test fun convertCtoK_test() {
        assertEquals("Converted temp (C to K) is incorrect",
            "3.15", tempConverter.convertCtoK(-270f))
    }
    @Test fun convertCtoF_test() {
        assertEquals("Converted temp (C to F) is incorrect",
            "32", tempConverter.convertCtoF(0f))
    }
    @Test fun convertKtoC_test() {
        assertEquals("Converted temp (K to C) is incorrect",
            "-273.15", tempConverter.convertKtoC(0f))
    }
    @Test fun convertKtoF_test() {
        assertEquals("Converted temp (K to F) is incorrect",
            "-459.67", tempConverter.convertKtoF(0f))
    }
    @Test fun convertFtoC_test() {
        assertEquals("Converted temp (F to C) is incorrect",
            "0", tempConverter.convertFtoC(32f))
    }
    @Test fun convertFtoK_test() {
        assertEquals("Converted temp (F to K) is incorrect",
            "273.15", tempConverter.convertFtoK(32f))
    }
    @Test fun decimalFormat() {
        val floatFormat2 = DecimalFormat("0.000", DecimalFormatSymbols(Locale.US))
        val tempConverter2 = TempConverter(floatFormat2)
        assertEquals("DecimalFormat is wrong",
            "273.150", tempConverter2.convertCtoK(0f))
    }
}