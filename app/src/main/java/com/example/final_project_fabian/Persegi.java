package com.example.final_project_fabian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Persegi extends AppCompatActivity {
    private Button btnHasil;
    private EditText etSisi;
    private TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persegi2);
        btnHasil = findViewById((R.id.btn_hasil));
        etSisi = findViewById(R.id.sisi);
        hasil = findViewById(R.id.hasil);

        btnHasil.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Sisi = etSisi.getText().toString();
                if (Sisi.isEmpty()){
                    etSisi.setError("Input nilai untuk dikalkulasi");
                    etSisi.requestFocus();

                }
                else{
                    Double num = Double.parseDouble(Sisi);
                    Double Luas = num*num;
                    hasil.setText(String.format("%.2f", Luas));
                }
            }
        }));
    }
}