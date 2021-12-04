package com.example.myloginapp.authentification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myloginapp.R;

public class RegisterActivity extends AppCompatActivity {
    TextView username,mpd1,mpd2;
    Button RegisterButon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ActionBar actionBar= getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        username=findViewById(R.id.UsernameInput);
        mpd1=findViewById(R.id.PasswordInput1);
        mpd2=findViewById(R.id.PasswordInput2);
        RegisterButon=findViewById(R.id.button_register);
        RegisterButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginBack=new Intent(RegisterActivity.this,LoginActicity.class);
                startActivity(LoginBack);
            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}