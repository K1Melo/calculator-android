package com.k1melo.calculator

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;

        operations()
    }

    private fun operations() {
            val calculatorResult:TextView = findViewById(R.id.calculatorNumber)
            val resultText:TextView = findViewById(R.id.result)

            val button1: Button = findViewById(R.id.number1)
            button1.setOnClickListener {
                addExpression("1", calculatorResult)
            }

            val button2: Button = findViewById(R.id.number2)
            button2.setOnClickListener {
                addExpression("2", calculatorResult)
            }

            val button3: Button = findViewById(R.id.number3)
            button3.setOnClickListener {
                addExpression("3", calculatorResult)
            }

            val button4: Button = findViewById(R.id.number4)
            button4.setOnClickListener {
                addExpression("4", calculatorResult)
            }

            val button5: Button = findViewById(R.id.number5)
            button5.setOnClickListener {
                addExpression("5", calculatorResult)
            }

            val button6: Button = findViewById(R.id.number6)
            button6.setOnClickListener {
                addExpression("6", calculatorResult)
            }

            val button7: Button = findViewById(R.id.number7)
            button7.setOnClickListener {
                addExpression("7", calculatorResult)
            }

            val button8: Button = findViewById(R.id.number8)
            button8.setOnClickListener {
                addExpression("8", calculatorResult)
            }

            val button9: Button = findViewById(R.id.number9)
            button9.setOnClickListener {
                addExpression("9", calculatorResult)
            }

            val button0: Button = findViewById(R.id.number0)
            button0.setOnClickListener {
                addExpression("0", calculatorResult)
            }

            val buttonSum: Button = findViewById(R.id.sum)
            buttonSum.setOnClickListener {
                addExpression("+", calculatorResult)
            }

            val buttonSub: Button = findViewById(R.id.subtraction)
            buttonSub.setOnClickListener {
                addExpression("-", calculatorResult)
            }

            val buttonDiv: Button = findViewById(R.id.divide)
            buttonDiv.setOnClickListener {
                addExpression("/", calculatorResult)
            }

            val buttonMut: Button = findViewById(R.id.multiplication)
            buttonMut.setOnClickListener {
                addExpression("*", calculatorResult)
            }

            val dot: Button = findViewById(R.id.dot)
            dot.setOnClickListener {
                addExpression(".", calculatorResult)
            }

            clearAll(calculatorResult)
            clearLast(calculatorResult)

            val buttonEquals: Button = findViewById(R.id.equals)
            buttonEquals.setOnClickListener {
                try {
                    val expression = ExpressionBuilder(calculatorResult.text.toString()).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()

                    if (result == longResult.toDouble()) {
                        resultText.hint = """=""" + longResult.toString()
                    } else {
                        resultText.hint = """=""" + result.toString()
                    }
                }catch (e: Exception) {
                }
            }
        }


    private fun addExpression(string: String, text: TextView) {
            text.append(string)
        }

    private fun clearAll(text: TextView) {
            val buttonClearAll: Button = findViewById(R.id.clearAll)

            buttonClearAll.setOnClickListener {
                text.text = ""
                text.hint = "0"
                text.textSize = 50F
            }
        }

    @SuppressLint("SetTextI18n")
    private fun clearLast(text: TextView) {
            val buttonClearOne: Button = findViewById(R.id.clearOne)

            buttonClearOne.setOnClickListener {
                text.text = text.text.removeSuffix(text.text.last().toString())
                if (text.length() < 18) {
                    text.textSize = 50F
                }
            }
        }

}