package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val bmi = intent.getDoubleExtra("Bmi", 0.0)

        // 코틀린에서 사용하는 when 조건문 | 자바에서 switchCase 와 동일
        when {

            bmi >= 35 -> resultTextView.text = "고도 비만"
            bmi >= 30 -> resultTextView.text = "2단계 비만"
            bmi >= 25 -> resultTextView.text = "1단계 비만"
            bmi >= 23 -> resultTextView.text = "과체중"
            bmi >= 18.5 -> resultTextView.text = "정상"
            else -> resultTextView.text = "저체중"
        }

        when {

            bmi >= 23 -> image.setImageResource(R.drawable.sad_face)
            bmi >= 18.5 -> image.setImageResource(R.drawable.happy_face)
            else -> image.setImageResource(R.drawable.sad_face)
        }
    }
}