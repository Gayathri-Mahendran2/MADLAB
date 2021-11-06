package com.example.ex4_database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Retrieve_id extends AppCompatActivity {
    Button retreive_id;
    TextView result;
    EditText idd;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_id);
        retreive_id=findViewById(R.id.retrieve_id);
        result=findViewById(R.id.result);
        idd=findViewById(R.id.id);
        db=openOrCreateDatabase("db",MODE_PRIVATE,null);

        retreive_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=idd.getText().toString();
                Cursor rs=db.rawQuery("SELECT * FROM EMPLOYEES WHERE ID=?;",new String[]{id});
                rs.moveToFirst();
                try{
                    result.setText(rs.getString(0)+" "+rs.getString(1)+" "+rs.getString(2)+" "
                    +rs.getString(3)+" "+rs.getString(4));
                }
                catch (Exception ex){

                    result.setText("No such Employee!!");
                    ex.printStackTrace();
                }

            }
        });
    }
}