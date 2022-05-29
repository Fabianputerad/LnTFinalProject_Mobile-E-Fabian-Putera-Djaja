package com.example.final_project_fabian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class bgnRuang extends AppCompatActivity {
    private Button btnPiramid, btnSBalok, btnTabung;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bgn_ruang);


        btnPiramid = findViewById(R.id.Piramid);
        btnSBalok = findViewById(R.id.Balok);
        btnTabung = findViewById(R.id.Tabung);


        btnPiramid.setOnClickListener(View ->{
            startActivity(new Intent(bgnRuang.this, Piramid.class));
        });
        btnSBalok.setOnClickListener(View ->{
            startActivity(new Intent(bgnRuang.this,Balok.class));
        });
        btnTabung.setOnClickListener(View ->{
            startActivity(new Intent(bgnRuang.this, Tabung.class));
        });
    }
}