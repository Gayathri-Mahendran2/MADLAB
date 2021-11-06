package com.example.ex5_multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button start;
    TextView tv;
    ProgressBar p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        tv=findViewById(R.id.tv);
        p=findViewById(R.id.p);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Thread t=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        check();
                    }
                });
                t.start();
            }
        });

    }

    public void check(){
        p.setProgressTintList(ColorStateList.valueOf(Color.YELLOW));
        for(int i=0;i<=100;i++){
            p.setProgress(i);
            if(i==25){
                p.setProgressTintList(ColorStateList.valueOf(Color.BLACK));
            }
            if(i==50){
                p.setProgressTintList(ColorStateList.valueOf(Color.BLUE));
            }
            if(i==75){
                p.setProgressTintList(ColorStateList.valueOf(Color.GREEN));
            }
            int finalI = i;
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tv.setText(String.valueOf(finalI)+"%");
                }
            });
            try{
                Thread.sleep(250);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}