package com.example.exercise2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    lateinit var image : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener(){
            calculateBMI(it)
        }

        findViewById<Button>(R.id.buttonReset).setOnClickListener(){
            resetAll(it)
        }
    }

    private fun calculateBMI(view:View){
        val editWeight = findViewById<EditText>(R.id.editTextWeight)
        val editHeight = findViewById<EditText>(R.id.editTextHeight)
        val bmi = findViewById<TextView>(R.id.textViewBMI)

        image = findViewById(R.id.imageViewProfile)

        val result = editWeight.text.toString().toDouble() / ((editHeight.text.toString().toDouble() / 100) * (editHeight.text.toString().toDouble() / 100))
        val number = java.lang.Double.valueOf(result)
        val dec = DecimalFormat("#.##")
        val r = dec.format(number)

        if(result <= 18.5){
            image.setImageResource(R.drawable.under)
        } else if (result >= 18.5 && result <= 24.9) {
            image.setImageResource(R.drawable.normal)
        } else if (result >= 25){
            image.setImageResource(R.drawable.over)
        }

        bmi.text = r

        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun resetAll(view:View){
        val editWeight = findViewById<EditText>(R.id.editTextWeight)
        val editHeight = findViewById<EditText>(R.id.editTextHeight)
        val bmi = findViewById<TextView>(R.id.textViewBMI)

        image = findViewById(R.id.imageViewProfile)

        editWeight.getText().clear()
        editHeight.getText().clear()
        image.setImageResource(R.drawable.empty)
        bmi.setText(R.string.bmi)

        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
