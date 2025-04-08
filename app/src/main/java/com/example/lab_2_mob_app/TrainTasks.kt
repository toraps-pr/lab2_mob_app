package com.example.lab_2_mob_app

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TrainTasks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_train_tasks)

        val backButton: Button = findViewById(R.id.back_button)

        val input1: EditText = findViewById(R.id.input_value1)
        val input2: EditText = findViewById(R.id.input_value2)
        val input3: EditText = findViewById(R.id.input_value3)
        val input4: EditText = findViewById(R.id.input_value4)
        val input5: EditText = findViewById(R.id.input_value5)

        val okButton1: Button = findViewById(R.id.ok_button1)
        val okButton2: Button = findViewById(R.id.ok_button2)
        val okButton3: Button = findViewById(R.id.ok_button3)
        val okButton4: Button = findViewById(R.id.ok_button4)
        val okButton5: Button = findViewById(R.id.ok_button5)

        val result1: TextView = findViewById(R.id.result_label1)
        val result2: TextView = findViewById(R.id.result_label2)
        val result3: TextView = findViewById(R.id.result_label3)
        val result4: TextView = findViewById(R.id.result_label4)

        backButton.setOnClickListener {
            finish()
        }

        okButton1.setOnClickListener {
            val ageText = input1.text.toString()
            val age = ageText.toIntOrNull()

            if (age != null && age > 18) {
                result1.text = "Статус доступу: дозволено"
                result1.setTextColor(Color.GREEN)
            } else {
                result1.text = "Статус доступу: заборонено"
                result1.setTextColor(Color.RED)
            }
        }

        okButton2.setOnClickListener {
            val nText = input2.text.toString()
            val n = nText.toIntOrNull()

            if (n != null && n > 0) {
                val sum = (n * (n + 1)) / 2
                result2.text = "Ваша сума: $sum"
            } else {
                result2.text = "Введіть коректне ціле додатне число"
                result2.setTextColor(Color.RED)
            }
        }

        okButton3.setOnClickListener {
            val inputText = input3.text.toString()
            val number = inputText.toIntOrNull()

            val array = arrayOf(2, 45, 12, 17, 24, 8, 43, 90)

            if (number != null) {
                if (number in array) {
                    result3.text = "Статус пошуку: знайдено"
                    result3.setTextColor(Color.GREEN)
                } else {
                    result3.text = "Статус пошуку: не знайдено"
                    result3.setTextColor(Color.RED)
                }
            } else {
                result3.text = "Введіть коректне число"
            }
        }

        okButton4.setOnClickListener {
            val userName: String? = input4.text.toString()

            if (!userName.isNullOrEmpty()) {
                result4.text = "Привіт, $userName"
            } else {
                result4.text = "Привіт, Anonymous"
            }
        }

        okButton5.setOnClickListener {

            try {
                val userInput = input5.text.toString().toInt()
                validateNumber(userInput)

                Toast.makeText(this, "Число: $userInput є в діапазоні", Toast.LENGTH_SHORT).show()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Будь ласка, введіть ціле число", Toast.LENGTH_SHORT).show()
            } catch (e: IllegalArgumentException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }

        }

    }

    // для 5-го завдання
    private fun validateNumber(number: Int) {
        if (number !in 1..100) {
            throw IllegalArgumentException("Число повинно бути в діапазоні від 1 до 100.")
        }
    }
}