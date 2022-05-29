package com.example.final_project_fabian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Piramid extends AppCompatActivity {
    private Button btnHasil;
    private EditText etAlas, etTinggi;
    private TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piramid);

        btnHasil = findViewById((R.id.btn_hasil));
        etAlas = findViewById(R.id.Alas);
        etTinggi = findViewById(R.id.Tinggi);
        hasil = findViewById(R.id.hasil);
        btnHasil.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tinggi = etTinggi.getText().toString();
                String alas = etAlas.getText().toString();
                if (tinggi.isEmpty() && alas.isEmpty()){
                    etTinggi.setError("Input nilai untuk dikalkulasi");
                    etTinggi.requestFocus();
                    etAlas.setError("Input nilai untuk dikalkulasi");
                    etAlas.requestFocus();

                }
                else{
                    Double num = Double.parseDouble(tinggi);
                    Double num2 = Double.parseDouble(alas);
                    Double Luas = num2*num2;
                    Double Volume = 1/3 * Luas * num;
                    hasil.setText(String.format("%.2f", Volume));
                }
            }
        }));
    }
}