package com.example.final_project_fabian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Segitiga extends AppCompatActivity {
    private Button btnHasil;
    private EditText etTinggi, etAlas;
    private TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga2);
        btnHasil = findViewById((R.id.btn_hasil));
        etAlas = findViewById(R.id.Alas);
        etTinggi = findViewById(R.id.Tinggi);
        hasil = findViewById(R.id.hasil);

        btnHasil.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String alas = etAlas.getText().toString();
                String tinggi = etTinggi.getText().toString();
                if (tinggi.isEmpty()&& alas.isEmpty()){
                    etAlas.setError("Input nilai untuk dikalkulasi");
                    etAlas.requestFocus();
                    etTinggi.setError("Input nilai untuk dikalkulasi");
                    etTinggi.requestFocus();
                }
                else{
                    Double num = Double.parseDouble(alas);
                    Double num2 = Double.parseDouble(tinggi);
                    Double Luas = 0.5*num*num2;
                    hasil.setText(String.format("%.2f", Luas));
                }
            }
        }));
    }
}