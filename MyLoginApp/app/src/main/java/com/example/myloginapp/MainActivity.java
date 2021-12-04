package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myloginapp.authentification.LoginActicity;

import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    Button see_app;
    int counter = 0;
    TextView CounterText;
    //public String url = "https://reqres.in/api/users/2";
    TextView TextApi ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //OkHttpClient client = new OkHttpClient();

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
        OkHttpClient client = new OkHttpClient();
        TextApi = findViewById(R.id.textApi);
        // GET
        Request get = new Request.Builder()
                .url("https://reqres.in/api/users?page=2")
                .build();

        client.newCall(get).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                try {
                    ResponseBody responseBody = response.body();
                    if (!response.isSuccessful()) {
                        throw new IOException("Unexpected code " + response);
                    }

                    Log.i("data", responseBody.string());
                    TextApi.setText(responseBody.string());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });





    }




}