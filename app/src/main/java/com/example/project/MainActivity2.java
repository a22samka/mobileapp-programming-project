package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    Button tillbaks;

    Intent intentTillbaka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tillbaks = findViewById(R.id.knappTillbaka);
        tillbaks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity2.this, MainActivity.class));
                intentTillbaka = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intentTillbaka);
            }
        });
    }
}