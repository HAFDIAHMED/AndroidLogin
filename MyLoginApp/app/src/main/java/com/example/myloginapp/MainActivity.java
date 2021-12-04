package com.example.myloginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myloginapp.authentification.LoginActicity;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import com.google.gson.JsonObject;

public class MainActivity extends AppCompatActivity {
    Button see_app,api_result_button;
    int counter = 0;
    TextView CounterText;
    //public String url = "https://reqres.in/api/users/2";
    TextView TextApi ;
    String getdata="data get";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //OkHttpClient client = new OkHttpClient();

        see_app = findViewById(R.id.button2);
        api_result_button=findViewById(R.id.apibutton);
        CounterText = findViewById(R.id.textcountr);
        TextApi=findViewById(R.id.textApi);
        see_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent SeeApp = new Intent(MainActivity.this, LoginActicity.class);
                startActivity(SeeApp);
                //counter=counter +1;
                //CounterText.setText(Integer.toString(counter));

            }
        });
        api_result_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextApi.setText(getdata);

            }
        });

        //make a client
        OkHttpClient client = new OkHttpClient();
        //get request
        Request get = new Request.Builder()
                .url("https://reqres.in/api/users?page=2")
                .build();
        client.newCall(get).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try{
                     ResponseBody responseBody=response.body();
                     if(!response.isSuccessful()){
                         throw new IOException("unexpected code "+response);
                     }
                     Log.i("data with get",responseBody.string());
                     getdata=responseBody.string();
                     TextApi.setText(responseBody.string());
                     Log.i("data get to see",getdata);

                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });
        //Post Data
        JsonObject postData = new JsonObject();
        postData.addProperty("name", "morpheus");
        postData.addProperty("job","leader");
        final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody postBody = RequestBody.create(JSON,postData.toString());
        Request post= new Request.Builder()
                .url("https://reqres.in/api/users")
                .post(postBody)
                .build();
        client.newCall(post).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                    try{
                            ResponseBody responseBody=response.body() ;
                            if(!response.isSuccessful()){
                                throw new IOException("unexpected code "+ response);
                            }
                            Log.i("data posted",responseBody.string());
                    }catch(Exception e){
                        e.printStackTrace();
                    }
            }
        });








    }




}