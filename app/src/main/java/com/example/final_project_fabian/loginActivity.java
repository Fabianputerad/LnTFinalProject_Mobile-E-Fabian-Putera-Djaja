package com.example.final_project_fabian;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email, password;
    private Button btnLogin;
    private TextView registerText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.et_loginEmail);
        password = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        registerText = findViewById(R.id.tv_toregister);
        
        btnLogin.setOnClickListener(view -> {
            login();
        });

        registerText.setOnClickListener(view -> {
            startActivity(new Intent(loginActivity.this, RegisterActivity.class));
        });
    }

    private void login() {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if(user.isEmpty()){
            email.setError("Email Cannot be empty");
        }
        if(pass.isEmpty()){
            password.setError("Password Cannot be empty");
        }
        if(!user.isEmpty() && !pass.isEmpty()){
            mAuth.signInWithEmailAndPassword(user, pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(loginActivity.this, "Login Succsessful", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(loginActivity.this, MainActivity.class));
                            }
                            else{
                                Toast.makeText(loginActivity.this, "Log in Failed" +task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}