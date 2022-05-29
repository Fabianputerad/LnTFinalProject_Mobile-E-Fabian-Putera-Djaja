package com.example.final_project_fabian;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class bgnDatar extends AppCompatActivity {
    private Button btnPersegi, btnSegitiga, btnLingkaran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bgn_datar);

        btnLingkaran = findViewById(R.id.lingkaran);
        btnPersegi = findViewById(R.id.persegi);
        btnSegitiga = findViewById(R.id.segitiga);


        btnPersegi.setOnClickListener(View ->{
            startActivity(new Intent(bgnDatar.this, Persegi.class));
        });
        btnSegitiga.setOnClickListener(View ->{
            startActivity(new Intent(bgnDatar.this,Segitiga.class));
        });
        btnLingkaran.setOnClickListener(View ->{
            startActivity(new Intent(bgnDatar.this, Lingkaran1.class));
        });
    }

    }

