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

        val result = editWeight.text.toString().toDouble() / (editHeight.text.toString().toFloat() * editHeight.text.toString().toFloat())

        if(result <= 18.5){
            bmi.text = result.toString()
            image.setImageResource(R.drawable.under)
        } else if (result >= 18.5 && result <= 24.9) {
            bmi.text = result.toString()
            image.setImageResource(R.drawable.normal)
        } else if (result >= 25){
            bmi.text = result.toString()
            image.setImageResource(R.drawable.over)
        }

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
    }
}
