package com.example.final_project_fabian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Lingkaran1 extends AppCompatActivity {
    private Button btnHasil;
    private EditText etJari;
    private TextView hasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran1);
        btnHasil = findViewById((R.id.btn_hasil));
        etJari = findViewById(R.id.jari);
        hasil = findViewById(R.id.hasil);

        btnHasil.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Jari2 = etJari.getText().toString();
                if (Jari2.isEmpty()){
                    etJari.setError("Input nilai untuk dikalkulasi");
                    etJari.requestFocus();
                }
                else{
                    Double num = Double.parseDouble(Jari2);
                    Double Luas = 3.14 *(num*2);
                    hasil.setText(String.format("%.2f", Luas));
                }
            }
        }));


    }
}