package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myloginapp.authentification.LoginActicity;

import org.w3c.dom.Text;

import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {
    Button see_app;
    int counter=0;
    TextView CounterText;
    OkHttpClient client = new OkHttpClient();
    public String url= "https://reqres.in/api/users/2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        see_app = findViewById(R.id.button2);
        CounterText=findViewById(R.id.textcountr);
        see_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SeeApp= new Intent(MainActivity.this, LoginActicity.class);
                startActivity(SeeApp);
                //counter=counter +1;
                //CounterText.setText(Integer.toString(counter));

            }
        });



    }
    public class OkHttpHandler
}