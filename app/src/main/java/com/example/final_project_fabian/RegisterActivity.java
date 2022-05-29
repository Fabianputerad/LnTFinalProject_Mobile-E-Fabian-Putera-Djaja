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
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email, password, name, confirmpassword, id;
    private Button btnRegister;
    private TextView loginText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.et_regisEmail);
        password = findViewById(R.id.et_regispassword);
        name = findViewById(R.id.et_nama);
        id = findViewById(R.id.et_nomor);
        confirmpassword = findViewById(R.id.et_confirmpass);
        btnRegister = findViewById(R.id.btn_regis);
        loginText = findViewById(R.id.tv_tologin);
        
        btnRegister.setOnClickListener(view ->{
            register();
        });
        
        loginText.setOnClickListener(view ->{
            startActivity(new Intent(RegisterActivity.this, loginActivity.class));
        });
    }

    private void register() {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();
        String nama = name.getText().toString().trim();
        String confirm = confirmpassword.getText().toString().trim();
        String nomorId = id.getText().toString().trim();

        if(nama.length()<=5 ){
            name.setError("Minimal 5 huruf");
        }
        if(user.isEmpty()){
            email.setError("Email Cannot be empty");
        }
        if(pass.isEmpty()){
            password.setError("Password Cannot be empty");
        }
        if(nama.isEmpty()){
            name.setError("Nama Cannot be empty");
        }
        if(confirm.isEmpty()){
            confirmpassword.setError("Cannot be empty");
        }
        if (confirm != pass){
            confirmpassword.setError("Error");
        }
        if(nomorId.isEmpty()){
            id.setError("ID Cannot be empty");
        }

        if(!user.isEmpty() && !pass.isEmpty() && !nama.isEmpty() && !confirm.isEmpty() && !nomorId.isEmpty()){
            mAuth.createUserWithEmailAndPassword(user, pass)
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Data data = new Data(user, pass, confirm, nama, nomorId);
                                FirebaseDatabase.getInstance().getReference().child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(RegisterActivity.this, "Register Successful",Toast.LENGTH_SHORT).show();
                                    }
                                });

                                startActivity(new Intent(RegisterActivity.this, loginActivity.class));
                            } else {
                                Toast.makeText(RegisterActivity.this, "Register Failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}