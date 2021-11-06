package com.example.ex4_database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button create,insert,update,delete,retrieve_id,retrieve_dept;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        create=findViewById(R.id.create);
        insert=findViewById(R.id.insert);
        update=findViewById(R.id.update);
        delete=findViewById(R.id.delete);
        retrieve_id=findViewById(R.id.retrieve_id);
        retrieve_dept=findViewById(R.id.retrieve_dept);
        db=openOrCreateDatabase("db",MODE_PRIVATE,null);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.execSQL("DROP TABLE IF EXISTS EMPLOYEES;");
                db.execSQL("CREATE TABLE EMPLOYEES(NAME VARCHAR(20)," +
                        "GENDER VARCHAR(20)," +
                        "ID VARCHAR(20)," +
                        "DEPT VARCHAR(20)," +
                        "SALARY VARCHAR(20));");
                Toast.makeText(getApplicationContext(), "Table Created!", Toast.LENGTH_SHORT).show();
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Insert.class);
                MainActivity.this.startActivity(i);
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Update.class);
                MainActivity.this.startActivity(i);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Delete.class);
                MainActivity.this.startActivity(i);
            }
        });
        retrieve_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Retrieve_id.class);
                MainActivity.this.startActivity(i);
            }
        });
        retrieve_dept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Retrieve_dept.class);
                MainActivity.this.startActivity(i);
            }
        });
    }
}