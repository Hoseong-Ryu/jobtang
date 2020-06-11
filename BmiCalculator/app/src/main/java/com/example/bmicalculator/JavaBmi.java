package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class JavaBmi extends AppCompatActivity {

    EditText height_xml;
    EditText weight_xml;
    Button resultButton_xml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_bmi);

        height_xml = findViewById(R.id.height);
        weight_xml = findViewById(R.id.weight);
        resultButton_xml = findViewById(R.id.result_button);

        resultButton_xml.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Double weight = Double.parseDouble(weight_xml.getText().toString());

                Double height = Double.parseDouble(height_xml.getText().toString());

                Double result = weight / Math.pow(height / 100, 2);

                Toast.makeText(JavaBmi.this, "Bmi : " + result.toString(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(JavaBmi.this, ResultActivity.class);
                intent.putExtra("Bmi", result);
                startActivity(intent);

            }
        });

    }
}