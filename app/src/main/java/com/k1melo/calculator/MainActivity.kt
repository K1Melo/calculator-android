package com.k1melo.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button1: Button = findViewById(R.id.button1)
        val button0: Button = findViewById(R.id.button0)

        addNumber(button1)
        addNumber(button0)
    }

    @SuppressLint("SetTextI18n")
    fun addNumber(button: Button) {
        val textAbove: TextView = findViewById(R.id.numbers)
        val buttonNumber: Int = Integer.parseInt(button.text.toString())

        button.setOnClickListener {

            textAbove.text = (textAbove.text).toString() + (buttonNumber).toString()
        }
    }

}