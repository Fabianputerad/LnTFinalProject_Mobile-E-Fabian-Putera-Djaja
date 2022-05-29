package com.example.final_project_fabian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;


public class count extends AppCompatActivity {
    private TextView textView;
    private Button increaseBTN;
    private Button decreaseBTN;
    private Button resetBTN;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        mAuth = FirebaseAuth.getInstance();

        setUI();
        increaseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = Integer.toString(Integer.parseInt(textView.getText().toString())+1);
                textView.setText((newText));
            }
        });
        decreaseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Integer.parseInt(textView.getText().toString()) != 0) {
                    String newText = Integer.toString(Integer.parseInt(textView.getText().toString())-1);
                    textView.setText((newText));
                }
            }
        });
        resetBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newText = Integer.toString(Integer.parseInt(textView.getText().toString())*0);
                textView.setText((newText));
            }
        });


    }

    private void setUI(){
        textView = findViewById(R.id.counterText);
        increaseBTN = findViewById(R.id.pls_btn);
        decreaseBTN = findViewById(R.id.min_btn);
        resetBTN = findViewById(R.id.reset_btn);
    }
//    private void initCounter() {
//        count = 0;
//        counterTxt.setText(0);
//    }
//    private void plusCounter(){
//        count++;
//        counterTxt.setText(count);
//    }
//    private void minCounter(){
//        count--;
//        counterTxt.setText(count);
//    }
}