package com.example.ex3_primitives;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Bitmap bg;
    ImageView iv;
    Button zoom,rotate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv=findViewById(R.id.iv);
        zoom=findViewById(R.id.zoom);
        rotate=findViewById(R.id.rotate);

        bg=Bitmap.createBitmap(720,1280,Bitmap.Config.RGB_565);
        iv.setImageBitmap(bg);
        Canvas canvas=new Canvas(bg);
        canvas.drawColor(Color.WHITE);
        Paint paint=new Paint();
        Path path=new Path();
        paint.setColor(Color.BLUE);
        paint.setTextSize(50);
        canvas.drawRect(50,700,650,900,paint);
        paint.setColor(Color.YELLOW);
        canvas.drawRect(200,550,550,700,paint);
        canvas.drawCircle(200,900,75,paint);
        canvas.drawCircle(500,900,75,paint);

        //iv.animate().translationX(2000).setDuration(3000);
        rotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.animate().rotation(360).setDuration(3000);
            }
        });

        zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.startAnimation(AnimationUtils.loadAnimation(
                        getApplicationContext(),R.anim.zoom
                ));
            }
        });




    }
}