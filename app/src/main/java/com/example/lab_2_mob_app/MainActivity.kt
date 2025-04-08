package com.example.lab_2_mob_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttonToTrainTasks: Button = findViewById(R.id.button_first_option)
        val buttonToBonusCalculator: Button = findViewById(R.id.button_second_option)

        /**обробник події - натискання на кнопку для переходу на першу сторінку*/
        buttonToTrainTasks.setOnClickListener{
            val intent = Intent(this,TrainTasks::class.java)
            startActivity(intent)
        }

        /**обробник події - натискання на кнопку для переходу на другу сторінку*/
        buttonToBonusCalculator.setOnClickListener{
            val intent = Intent(this,BonusCalculator::class.java)
            startActivity(intent)
        }


    }
}