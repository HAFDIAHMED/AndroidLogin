package com.example.myloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListItemsActivity extends AppCompatActivity {
    ListView listCountries ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_items);
        listCountries=findViewById(R.id.listViewCountries);
        String countryList[] = {"India", "China", "australia", "Portugle", "America", "NewZealand"};
        Integer Idies[]={1,2,3,4,5,6,7,8,9};
        TextView CountryText;
        CountryText=findViewById(R.id.textview);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_list_items, R.id.textview, countryList);
        listCountries.setAdapter(arrayAdapter);
        CountryText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view ) {

                Toast.makeText(ListItemsActivity.this, "item clicked", Toast.LENGTH_SHORT).show();
            }
        });


    }


}