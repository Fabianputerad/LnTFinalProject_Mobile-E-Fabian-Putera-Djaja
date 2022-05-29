package com.example.final_project_fabian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Tabung extends AppCompatActivity {
    private Button btnHasil;
    private EditText etJari, etTinggi;
    private TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabung);
        btnHasil = findViewById((R.id.btn_hasil));
        etJari = findViewById(R.id.Jari);
        etTinggi = findViewById(R.id.Tinggi);
        hasil = findViewById(R.id.hasil);
        btnHasil.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tinggi = etTinggi.getText().toString();
                String jari = etJari.getText().toString();
                if (tinggi.isEmpty() && jari.isEmpty()){
                    etTinggi.setError("Input nilai untuk dikalkulasi");
                    etTinggi.requestFocus();
                    etJari.setError("Input nilai untuk dikalkulasi");
                    etJari.requestFocus();

                }
                else{
                    Double num = Double.parseDouble(tinggi);
                    Double num2 = Double.parseDouble(jari);
                    Double Volume = 3.14*num2*num2*num;
                    hasil.setText(String.format("%.2f", Volume));
                }
            }
        }));
    }
}