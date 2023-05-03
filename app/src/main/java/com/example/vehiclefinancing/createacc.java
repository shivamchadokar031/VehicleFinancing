package com.example.vehiclefinancing;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


import java.util.regex.Pattern;

public class createacc extends AppCompatActivity {

    EditText name,number,password,email;
    Button b;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createacc);

        name= findViewById(R.id.name);
        number= findViewById(R.id.number);
        email= findViewById(R.id.emaill);
        password= findViewById(R.id.password);
        b= findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(createacc.this, service.class);
//                startActivity(intent);

                String name1 = name.getText().toString();
                String number1 = number.getText().toString();
                String email1 = email.getText().toString();
                String password1 = password.getText().toString();

                if(TextUtils.isEmpty(name1)){
                    Toast.makeText(createacc.this,"Please enter full name",Toast.LENGTH_LONG).show();
                    name.setError("Full name is required");
                    name.requestFocus();
                } else if (TextUtils.isEmpty(number1)){
                    Toast.makeText(createacc.this,"Please enter phone number",Toast.LENGTH_LONG).show();
                    number.setError("Phone Number is required");
                    number.requestFocus();
                } else if (number1.length()!=10){
                    Toast.makeText(createacc.this,"Please re-enter phone number",Toast.LENGTH_LONG).show();
                    number.setError("Phone Number should be 10 digit");
                    number.requestFocus();
                } else if (TextUtils.isEmpty(email1)){
                    Toast.makeText(createacc.this,"Please enter email",Toast.LENGTH_LONG).show();
                    email.setError("Email is required");
                    email.requestFocus();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
                    Toast.makeText(createacc.this,"Please re-enter email",Toast.LENGTH_LONG).show();
                    number.setError("Valid email is required");
                    number.requestFocus();
                } else if (TextUtils.isEmpty(password1)){
                    Toast.makeText(createacc.this,"Please enter password",Toast.LENGTH_LONG).show();
                    password.setError("Password is required");
                    password.requestFocus();
                } else if (password1.length() < 8){
                    Toast.makeText(createacc.this,"Password should be at least 8 digits",Toast.LENGTH_LONG).show();
                    number.setError("Password too weak");
                    number.requestFocus();
                } else {
                    registerUser(name1,number1,email1,password1);
                }
            }
        });


    }

    private void registerUser(String name1, String number1, String email1, String password1) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email1,password1).addOnCompleteListener(createacc.this, new OnCompleteListener<AuthResult>(){
            public void onComplete(Task<AuthResult> task){
                if (task.isSuccessful()){
                    Toast.makeText(createacc.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    FirebaseUser firebaseUser = auth.getCurrentUser();

                    firebaseUser.sendEmailVerification();

                    Intent intent = new Intent(createacc.this,service.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }
            }
   });
}
}
