package com.example.ex1_gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Table_test extends AppCompatActivity {
    Button back;
    TextView name,address,age,phone,dob,gender,marital,time,addiction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table_test);
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        age=findViewById(R.id.age);
        phone=findViewById(R.id.phone);
        dob=findViewById(R.id.dob);
        marital=findViewById(R.id.marital);
        time=findViewById(R.id.time);
        addiction=findViewById(R.id.addiction);
        back=findViewById(R.id.back);

        Intent i=getIntent();
        name.setText(i.getStringExtra("name"));
        address.setText(i.getStringExtra("address"));
        age.setText(String.valueOf(i.getIntExtra("age",0)));
        phone.setText(i.getStringExtra("phone"));
        dob.setText(i.getStringExtra("dob"));
        marital.setText(i.getStringExtra("marital"));
        time.setText(i.getStringExtra("time"));
        addiction.setText(i.getStringExtra("addiction"));

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}