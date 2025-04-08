package com.example.lab_2_mob_app

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class BonusCalculator : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bonus_calculator)

        val backButton: Button = findViewById(R.id.back_button)
        val addButton: Button = findViewById(R.id.add_button)
        val doneButton: Button = findViewById(R.id.done_button)

        val inputName: EditText = findViewById(R.id.input_name)
        val inputSalary: EditText = findViewById(R.id.input_salary)
        val inputBonus: EditText = findViewById(R.id.input_bonus)

        val bonusResult: TextView = findViewById(R.id.biggest_bonus_label)
        val sumResult: TextView = findViewById(R.id.total_sum_label)
        val differentResult: TextView = findViewById(R.id.number_different_label)

        val employees = mutableListOf<Pair<String?, Double>>()

        backButton.setOnClickListener {
            finish()
        }

        addButton.setOnClickListener {
            try {
                val name = inputName.text.toString().takeIf { it.isNotBlank() }
                val salary = inputSalary.text.toString().toDouble()
                val bonusRate = inputBonus.text.toString().toDouble()

                if (salary < 0 || bonusRate !in 0.1..2.0) {
                    throw IllegalArgumentException("Некоректні дані: оклад або коефіцієнт")
                }

                val bonus = salary * bonusRate
                employees.add(Pair(name, bonus))

                // Очищаю поля після додавання
                inputName.text.clear()
                inputSalary.text.clear()
                inputBonus.text.clear()

            } catch (e: Exception) {
                Toast.makeText(this, "Помилка: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        doneButton.setOnClickListener {
            if (employees.isEmpty()) {
                Toast.makeText(this, "Список порожній", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val biggest = employees.maxByOrNull { it.second }
            val total = employees.sumOf { it.second }
            val excellentCount = employees.count { it.second >= 10_000 }

            bonusResult.text = "Отримувач найбільшого бонусу: ${biggest?.first ?: "невідомо"} (${biggest?.second ?: 0.0})"
            sumResult.text = "Загальна сума бонусів: $total"
            differentResult.text = "Кількість 'відмінних': $excellentCount"
        }
    }
}