package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myloginapp.authentification.LoginActicity;

public class MainActivity extends AppCompatActivity {
    Button see_app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        see_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent SeeApp= new Intent(MainActivity.this, LoginActicity.class);
                //startActivity(SeeApp);
                see_app.setText("button test");

            }
        });

    }
}