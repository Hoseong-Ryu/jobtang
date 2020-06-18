package com.example.sharedpreferencesingleton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = PreferenceManager(this)

        textView.text = pref.getData("TEXT")

        if(editText.text != null) {

            button.setOnClickListener {
                textView.text = editText.text.toString()
                pref.setData("TEXT", editText.text.toString())
            }

        }

    }
}