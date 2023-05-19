package com.example.vehiclefinancing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sell extends AppCompatActivity {
    ImageView img1, img2, img3, img4;
    EditText vehicletype,model,variant,state,kmd;
    Button submit;
    FirebaseDatabase database;
    DatabaseReference reference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sell);
        img1=(ImageView) findViewById(R.id.img9);
        img3=(ImageView) findViewById(R.id.cars);
        vehicletype = findViewById(R.id.vehicle1);
        model = findViewById(R.id.model1);
        variant = findViewById(R.id.variant1);
        state = findViewById(R.id.state1);
        kmd = findViewById(R.id.kmd1);
        submit = findViewById(R.id.submit);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference("details");


       submit.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               insertStudentData();
           }

           private void insertStudentData() {
               String vt = vehicletype.getText().toString();
               String m = model.getText().toString();
               String v = variant.getText().toString();
               String s = state.getText().toString();
               String k = kmd.getText().toString();

               insertCarD insertCarD = new insertCarD(vt,m,v,s,k);

               reference.push().setValue(insertCarD);
               Toast.makeText(sell.this, "Data Inserted", Toast.LENGTH_SHORT).show();
           }
       });
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sell.this, service.class);
                startActivity(intent);
            }
        });

    }
}
