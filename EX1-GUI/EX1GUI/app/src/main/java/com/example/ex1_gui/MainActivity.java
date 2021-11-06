package com.example.ex1_gui;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    EditText name,address,age,phone;
    DatePicker dob;
    RadioButton male,female;
    Spinner marital;
    TimePicker time;
    CheckBox alcohol,smoking;
    Button submit,reset;
    String gender="";
    String addiction="";
    String maritall="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        age=findViewById(R.id.age);
        phone=findViewById(R.id.phone);
        dob=findViewById(R.id.dob);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        marital=findViewById(R.id.marital);
        time=findViewById(R.id.time);
        alcohol=findViewById(R.id.alcohol);
        smoking=findViewById(R.id.smoking);
        submit=findViewById(R.id.submit);
        reset=findViewById(R.id.reset);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.marital_status,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        marital.setAdapter(adapter);
        marital.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                maritall = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }

        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(male.isChecked())
                {gender="male";}
                if(female.isChecked())
                {gender="female";}
                if(smoking.isChecked()){
                    addiction=addiction+" smoking";
                }
                if(alcohol.isChecked()){
                    addiction=addiction+" alcohol";
                }
                Intent i=new Intent(MainActivity.this,Table_test.class);
                i.putExtra("name",name.getText().toString());
                i.putExtra("address",address.getText().toString());
                i.putExtra("age", Integer.parseInt(age.getText().toString()));
                i.putExtra("phone",phone.getText().toString());
                i.putExtra("dob",dob.getDayOfMonth()+"-"+dob.getMonth()+"-"+dob.getYear());
                i.putExtra("gender",gender);
                i.putExtra("marital",maritall);
                i.putExtra("time",time.getCurrentHour()+":"+time.getCurrentMinute());
                i.putExtra("addiction",addiction);
                startActivity(i);
                //Log.i("Messssssssssssss","hello test");

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name.setText("");
                address.setText("");
                age.setText("");
                phone.setText("");
                male.setChecked(false);
                female.setChecked(false);
                alcohol.setChecked(false);
                smoking.setChecked(false);

            }
        });
    }
}