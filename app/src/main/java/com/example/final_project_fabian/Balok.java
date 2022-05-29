package com.example.final_project_fabian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Balok extends AppCompatActivity {
    private Button btnHasil;
    private EditText etPanjang, etLebar, etTinggi;
    private TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balok);

        btnHasil = findViewById((R.id.btn_hasil));
        etPanjang = findViewById(R.id.Panjang);
        etLebar = findViewById(R.id.Lebar);
        etTinggi = findViewById(R.id.Tinggi);
        hasil = findViewById(R.id.hasil);

        btnHasil.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tinggi = etTinggi.getText().toString();
                String panjang = etPanjang.getText().toString();
                String lebar = etLebar.getText().toString();
                if (tinggi.isEmpty() && panjang.isEmpty() && lebar.isEmpty()){
                    etTinggi.setError("Input nilai untuk dikalkulasi");
                    etTinggi.requestFocus();
                    etPanjang.setError("Input nilai untuk dikalkulasi");
                    etPanjang.requestFocus();
                    etLebar.setError("Input nilai untuk dikalkulasi");
                    etLebar.requestFocus();

                }
                else{
                    Double num = Double.parseDouble(tinggi);
                    Double num2 = Double.parseDouble(panjang);
                    Double num3 = Double.parseDouble(lebar);
                    Double Volume =num*num2*num3;
                    hasil.setText(String.format("%.2f", Volume));
                }
            }
        }));
    }
}