package com.sevin.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.sevin.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var number1: Double? = null
    var number2: Double? = null
    var result: Double? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    fun mySum(view: View) {
        number1 = binding.editN1.text.toString().toDoubleOrNull()
        number2 = binding.editN2.text.toString().toDoubleOrNull()

        if (number1 != null && number2 != null) {
            result = number1!! + number2!!
            binding.result.text = "Result: ${result}"
        } else {
            binding.result.text = "Enter Number!"
        }
    }

    fun mySub(view: View) {
        number1 = binding.editN1.text.toString().toDoubleOrNull()
        number2 = binding.editN2.text.toString().toDoubleOrNull()

        if (number1 != null && number2 != null) {
            result = number1!! - number2!!
            binding.result.text = "Result: ${result}"
        } else {
            binding.result.text = "Enter Number!"
        }
    }

    fun myMult(view: View) {

        number1 = binding.editN1.text.toString().toDoubleOrNull()
        number2 = binding.editN2.text.toString().toDoubleOrNull()

        if (number1 != null && number2 != null) {
            result = number1!! * number2!!
            binding.result.text = "Result: ${result}"
        } else {
            binding.result.text = "Enter Number!"
        }
    }

    fun myDiv(view: View) {
        number1 = binding.editN1.text.toString().toDoubleOrNull()
        number2 = binding.editN2.text.toString().toDoubleOrNull()

        if (number1 != null && number2 != null) {
            result = number1!! / number2!!
            binding.result.text = "Result: ${result}"
        } else {
            binding.result.text = "Enter Number!"
        }
    }


}
