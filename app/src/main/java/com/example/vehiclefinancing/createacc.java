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
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


import java.util.regex.Pattern;

public class createacc extends AppCompatActivity {

    EditText signupName, signupNumber, signupPassword, signupEmail;
    Button b;
    FirebaseDatabase database;
    DatabaseReference reference;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.createacc);

        signupName = findViewById(R.id.name);
        signupNumber = findViewById(R.id.number);
        signupEmail = findViewById(R.id.emaill);
        signupPassword = findViewById(R.id.password);
        b = findViewById(R.id.button2);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database = FirebaseDatabase.getInstance();
                reference = database.getReference("users");


                String name = signupName.getText().toString();
                String number = signupNumber.getText().toString();
                String email = signupEmail.getText().toString();
                String password = signupPassword.getText().toString();

                Query checkUserDatabase = reference.orderByChild("name").equalTo(name);
                checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        String emailFromDB = snapshot.child(name).child("email").getValue(String.class);
                        if (snapshot.exists()) {
                            signupName.setError("User Already Exist");
                            signupName.requestFocus();
                        } else {
                            HelperClass helperClass = new HelperClass(name, number, email, password);
                            reference.child(name).setValue(helperClass);

                            if (TextUtils.isEmpty(name)) {
                                Toast.makeText(createacc.this, "Please enter full name", Toast.LENGTH_LONG).show();
                                signupName.setError("Full name is required");
                                signupName.requestFocus();
                            } else if (TextUtils.isEmpty(number)) {
                                Toast.makeText(createacc.this, "Please enter phone number", Toast.LENGTH_LONG).show();
                                signupNumber.setError("Phone Number is required");
                                signupNumber.requestFocus();
                            } else if (number.length() != 10) {
                                Toast.makeText(createacc.this, "Please re-enter phone number", Toast.LENGTH_LONG).show();
                                signupNumber.setError("Phone Number should be 10 digit");
                                signupNumber.requestFocus();
                            } else if (TextUtils.isEmpty(email)) {
                                Toast.makeText(createacc.this, "Please enter email", Toast.LENGTH_LONG).show();
                                signupEmail.setError("Email is required");
                                signupEmail.requestFocus();
                            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                                Toast.makeText(createacc.this, "Please re-enter email", Toast.LENGTH_LONG).show();
                                signupEmail.setError("Valid email is required");
                                signupEmail.requestFocus();
                            } else if (TextUtils.isEmpty(password)) {
                                Toast.makeText(createacc.this, "Please enter password", Toast.LENGTH_LONG).show();
                                signupPassword.setError("Password is required");
                                signupPassword.requestFocus();
                            } else if (password.length() < 8) {
                                Toast.makeText(createacc.this, "Password should be at least 8 digits", Toast.LENGTH_LONG).show();
                                signupPassword.setError("Password too weak");
                                signupPassword.requestFocus();
                            } else {
                                registerUser( name, number, email, password);
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }

        });
    }


    private void registerUser(String name, String number, String email, String password) {
        FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(createacc.this, new OnCompleteListener<AuthResult>() {
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(createacc.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                    FirebaseUser firebaseUser = auth.getCurrentUser();

                    assert firebaseUser != null;
                    firebaseUser.sendEmailVerification();

                    Intent intent = new Intent(createacc.this, service.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });
    }
}
