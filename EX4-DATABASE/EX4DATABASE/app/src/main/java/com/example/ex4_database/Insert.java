package com.example.ex4_database;
import androidx.appcompat.app.AppCompatActivity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class Insert extends AppCompatActivity {
    Button ins;
    EditText id,name,salary;
    RadioGroup gender;
    RadioButton male,female,sel;
    Spinner dept_list;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        db=openOrCreateDatabase("db",MODE_PRIVATE,null);
        ins=findViewById(R.id.ins);
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        salary=findViewById(R.id.salary);
        gender=findViewById(R.id.gender);
        male=findViewById(R.id.male);
        female=findViewById(R.id.female);
        dept_list=findViewById(R.id.dept_list);

        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg="";
                if(!id.getText().toString().matches("[A-Za-z0-9]+")) msg+="ID error!";
                if(!name.getText().toString().matches("[A-Za-z]+")) msg+="Name error!";
                if(!salary.getText().toString().matches("[0-9]+")) msg+="Salary error!";
                if(gender.getCheckedRadioButtonId()==-1) msg+="Select gender!";
                else sel=findViewById(gender.getCheckedRadioButtonId());
                if(msg.equals("")){
                    msg="Inserted!";
                    db.execSQL("INSERT INTO EMPLOYEES VALUES(?,?,?,?,?);",
                            new String[]{name.getText().toString(),sel.getText().toString(),
                            id.getText().toString(), dept_list.getSelectedItem().toString(),
                            salary.getText().toString()});
                }
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}