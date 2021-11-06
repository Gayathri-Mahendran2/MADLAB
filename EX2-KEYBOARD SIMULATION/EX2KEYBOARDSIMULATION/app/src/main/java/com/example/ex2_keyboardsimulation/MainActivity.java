package com.example.ex2_keyboardsimulation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button toggle;
    TextView tv;
    LinearLayout caps,small;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggle=findViewById(R.id.toggle);
        tv=findViewById(R.id.tv);
        caps=findViewById(R.id.caps);
        small=findViewById(R.id.small);
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(caps.getVisibility()==View.VISIBLE){
                    caps.setVisibility(View.INVISIBLE);
                    small.setVisibility(View.VISIBLE);
                }
                else{
                    caps.setVisibility(View.VISIBLE);
                    small.setVisibility(View.INVISIBLE);
                }
            }
        });


    }
    public void click(View v){

        tv.setText(tv.getText().toString()+v.getTag().toString());

    }
}