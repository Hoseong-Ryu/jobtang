package com.example.bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 버튼을 누르면 액티비티 변경해주는거 구현

        kotlinButton.setOnClickListener {
            val intent = Intent(this, KotlinBmi::class.java)
            startActivity(intent)
        }

        javaButton.setOnClickListener {
            val intent = Intent(this, JavaBmi::class.java)
            startActivity(intent)
        }
    }
}