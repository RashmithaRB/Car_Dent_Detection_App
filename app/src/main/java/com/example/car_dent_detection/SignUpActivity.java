package com.example.car_dent_detection;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private EditText emailEt, passEt, verifyPassEt;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        emailEt = findViewById(R.id.emailEt);
        passEt = findViewById(R.id.passEt);
        verifyPassEt = findViewById(R.id.verifyPassEt);
        progressBar = findViewById(R.id.progressBar);

        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.nextBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        findViewById(R.id.textViewSignIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
            }
        });
    }

    private void registerUser() {
        String email = emailEt.getText().toString().trim();
        String password = passEt.getText().toString().trim();
        String verifyPassword = verifyPassEt.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            emailEt.setError("Enter your email");
            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEt.setError("Enter a valid email");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            passEt.setError("Enter your password");
            return;
        }

        if (TextUtils.isEmpty(verifyPassword)) {
            verifyPassEt.setError("Re-enter your password");
            return;
        }

        if (!password.equals(verifyPassword)) {
            verifyPassEt.setError("Passwords do not match");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        // Register user in Firebase Authentication
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if (task.isSuccessful()) {
                    Toast.makeText(SignUpActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    // Redirect to sign-in page
                    startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                    finish();
                } else {
                    Toast.makeText(SignUpActivity.this, "Registration failed. Try again.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
