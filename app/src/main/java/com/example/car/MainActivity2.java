package com.example.car;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    EditText et1,et2,et3,et4;
    Button bt1,bt2,bt3;
    database g;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        et3=findViewById(R.id.et3);
        et4=findViewById(R.id.et4);
        bt1=findViewById(R.id.bt1);
        bt2=findViewById(R.id.bt2);
        bt3=findViewById(R.id.bt3);
        database g=new database(this);
        // SQLiteDatabase db = g.getReadableDatabase();
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=et1.getText().toString();
                String car_model=et2.getText().toString();
                String date=et3.getText().toString();
                String number=et4.getText().toString();


            Boolean i = g.insert_data(name, car_model, date, number);
                if (i == true) {
                    Toast.makeText(MainActivity2.this, "Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity2.this, "UnSuccessful", Toast.LENGTH_SHORT).show();
                }

            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor t=g.getinfo();
                StringBuffer buffer=new StringBuffer();
                while (t.moveToNext()) {
                    buffer.append("Name:" + t.getString(1) + "\n");
                    buffer.append("Car_model:" + t.getString(2) + "\n");
                    buffer.append("Date:" + t.getString(3) + "\n");
                    buffer.append("Number:" + t.getString(4) + "\n\n\n");
                }
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity2.this);
                builder.setCancelable(true);
                builder.setTitle("Car Rental");
                builder.setMessage(buffer.toString());
                builder.show();

            }


        });

    }
}

