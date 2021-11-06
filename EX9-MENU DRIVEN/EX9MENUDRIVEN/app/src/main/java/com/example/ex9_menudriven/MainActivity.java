package com.example.ex9_menudriven;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner food_spinner;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        food_spinner=findViewById(R.id.food_spinner);
        tv=findViewById(R.id.tv);

        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.food_item,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        food_spinner.setAdapter(adapter);
        food_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(MainActivity.this, item, Toast.LENGTH_SHORT).show();
                if (item.equals("Rasagulla")) {
                    Intent f = new Intent(MainActivity.this, Rasagulla.class);
                    startActivity(f);
                }
                if (item.equals("GulabJamun")) {
                    Intent j = new Intent(MainActivity.this, Gulab_jamun.class);
                    startActivity(j);
                }
                if (item.equals("Panipuri")) {
                    Intent k = new Intent(MainActivity.this, Pani_puri.class);
                    startActivity(k);
                }
                if (item.equals("Momos")) {
                    Intent m = new Intent(MainActivity.this, Momos.class);
                    startActivity(m);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }

        });

    }
}






