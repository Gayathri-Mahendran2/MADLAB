package com.example.ex4_database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Retrieve_dept extends AppCompatActivity {
    Button retreive_id;
    TextView result;
    Spinner dept_id;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve_dept);
        retreive_id=findViewById(R.id.retrieve_id);
        result=findViewById(R.id.result);
        dept_id=findViewById(R.id.dept_id);
        db=openOrCreateDatabase("db",MODE_PRIVATE,null);

        retreive_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dept=dept_id.getSelectedItem().toString();
                Cursor rs=db.rawQuery("SELECT * FROM EMPLOYEES WHERE DEPT=?;",new String[]{dept});
                String msg="";
                try{
                    while(rs.moveToNext()) {
                        msg += rs.getString(0) + " " + rs.getString(1) + " " + rs.getString(2) + " "
                                + rs.getString(3) + " " + rs.getString(4)+"     ";
                    }
                    result.setText(msg);
                    if(msg.equals("")){
                        result.setText("No such employee!");
                    }
                }
                catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });
    }
}