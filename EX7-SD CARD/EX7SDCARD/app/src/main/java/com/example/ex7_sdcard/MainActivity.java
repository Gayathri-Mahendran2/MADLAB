package com.example.ex7_sdcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
public class MainActivity extends AppCompatActivity {
    EditText filetext,filename,filename2;
    Button read,write;
    TextView file_con;
    String fn,text_con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filetext=findViewById(R.id.filetext);
        filename=findViewById(R.id.filename);
        filename2=findViewById(R.id.filename2);
        read=findViewById(R.id.read);
        write=findViewById(R.id.write);
        file_con=findViewById(R.id.file_con);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fn=filename.getText().toString();
                text_con=filetext.getText().toString();
                File f=new File(Environment.getExternalStorageDirectory().toString()+"/"+fn);
                //Nexus 6 API 30
                //File f=new File("/mnt/extSdCard"+"/"+fn);
                //Toast.makeText(MainActivity.this, fn, Toast.LENGTH_SHORT).show();
                try {
                    //Toast.makeText(MainActivity.this, "testt", Toast.LENGTH_SHORT).show();
                    f.createNewFile();
                    //Toast.makeText(MainActivity.this, "testt", Toast.LENGTH_SHORT).show();
                    FileOutputStream fos=new FileOutputStream(f);
                    OutputStreamWriter mout=new OutputStreamWriter(fos);
                    mout.append(text_con);
                    mout.close();
                    fos.close();
                    Toast.makeText(MainActivity.this, "Data written to SD card", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File f=new File("/sdcard/"+filename2.getText().toString());
                try {
                    FileInputStream fin=new FileInputStream(f);
                    BufferedReader bf=new BufferedReader(new InputStreamReader(fin));
                    String drow="",dbuf="";
                    while((drow=bf.readLine())!=null){
                        dbuf+=drow+"\n";

                    }
                    file_con.setText(dbuf);
                    bf.close();
                    fin.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}