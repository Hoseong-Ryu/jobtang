package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kotlin_bmi.*
import kotlin.math.pow

class KotlinBmi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_bmi)

        result_button.setOnClickListener {

            val height = height.text.toString().toDouble()

            val weight = weight.text.toString().toDouble()

            // bmi = 몸무게 / (키/100 ^ 2)
            // pow 연산자 | pow(2, 3) = 8
            val result = weight / (height / 100).pow(2.0)

            Toast.makeText(this, "몸무게 : $weight | 키 : $height | bmi : $result", Toast.LENGTH_SHORT).show()


            val intent = Intent(this, ResultActivity::class.java)

            // 값 넣어서 전달
            intent.putExtra("Bmi", result)
            startActivity(intent)
        }
    }
}