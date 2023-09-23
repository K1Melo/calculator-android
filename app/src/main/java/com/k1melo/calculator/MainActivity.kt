package com.k1melo.calculator

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

        val calculatorResult:TextView = findViewById(R.id.calculatorNumber)
        print(calculatorResult.textSize)

        val button1: Button = findViewById(R.id.number1)
        val button2: Button = findViewById(R.id.number2)
        val button3: Button = findViewById(R.id.number3)
        val button4: Button = findViewById(R.id.number4)
        val button5: Button = findViewById(R.id.number5)
        val button6: Button = findViewById(R.id.number6)
        val button7: Button = findViewById(R.id.number7)
        val button8: Button = findViewById(R.id.number8)
        val button9: Button = findViewById(R.id.number9)
        val button0: Button = findViewById(R.id.number0)

        addNumber(button1, calculatorResult)
        addNumber(button2, calculatorResult)
        addNumber(button3, calculatorResult)
        addNumber(button4, calculatorResult)
        addNumber(button5, calculatorResult)
        addNumber(button6, calculatorResult)
        addNumber(button7, calculatorResult)
        addNumber(button8, calculatorResult)
        addNumber(button9, calculatorResult)
        addNumber(button0, calculatorResult)
    }

    @SuppressLint("SetTextI18n")
    fun addNumber(button: Button, text: TextView) {
        button.setOnClickListener {
            if (text.length() < 18) {
                if ((text.length() + 1) % 4 == 0) {
                    text.text = """${(text.text)},"""
                }
                text.text = """${(text.text)}${(button.text)}"""
            } else if(text.length() < 27) {
                if ((text.length() + 1) % 4 == 0) {
                    text.text = """${(text.text)},"""
                }
                text.textSize = 35F
                text.text = """${(text.text)}${(button.text)}"""
            }
        }
    }
}