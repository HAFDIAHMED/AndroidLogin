package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myloginapp.authentification.LoginActicity;

import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    Button see_app;
    int counter = 0;
    TextView CounterText;
    OkHttpClient client = new OkHttpClient();
    public String url = "https://reqres.in/api/users/2";
    TextView TextApi = (TextView) findViewById(R.id.textApi);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        see_app = findViewById(R.id.button2);
        CounterText = findViewById(R.id.textcountr);
        see_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SeeApp = new Intent(MainActivity.this, LoginActicity.class);
                startActivity(SeeApp);
                //counter=counter +1;
                //CounterText.setText(Integer.toString(counter));

            }
        });
        //GET with okhttp
        Request get = new Request.Builder().url("https://reqres.in/api/users?page=2").build();
        client.newCall(get).enqueue(new Callback(){

        });



    }




}