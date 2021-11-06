package com.example.ex11_hybridapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btn;
    WebView wv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);
        wv=findViewById(R.id.wv);
        String content="<html><head>This is head</head>" +
                "<h1>header 1</h1>" +
                "<body>THis is body text</body>" +
                "</html>";

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wv.loadData(content,"text/html","UTF-8");
            }
        });
    }
}