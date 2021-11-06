package com.example.ex4_database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {
    EditText idd;
    Button delete;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        idd=findViewById(R.id.id);
        delete=findViewById(R.id.delete);
        db=openOrCreateDatabase("db",MODE_PRIVATE,null);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id= idd.getText().toString();
                Cursor c=db.rawQuery("SELECT * FROM EMPLOYEES WHERE ID=?;",
                        new String[]{id});
                if(!c.moveToNext()){
                    Toast.makeText(getApplicationContext(), "Doesn't exist", Toast.LENGTH_SHORT).show();
                }else{
                    db.execSQL("DELETE FROM EMPLOYEES WHERE ID=?;",new String[]{id});
                    Toast.makeText(getApplicationContext(), "Deleted!", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}