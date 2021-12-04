package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myloginapp.authentification.LoginActicity;

public class MainActivity extends AppCompatActivity {
    Button see_app;
    int counter=0;
    TextView CounterText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        see_app = findViewById(R.id.button2);
        CounterText=findViewById(R.id.textcountr);
        see_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent SeeApp= new Intent(MainActivity.this, LoginActicity.class);
                //startActivity(SeeApp);
                counter=counter +1;
                CounterText.setText(Integer.toString());

            }
        });

    }
}