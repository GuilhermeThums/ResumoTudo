package com.example.resumotudo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Tela2 extends AppCompatActivity {
    TextView txvNome;
    TextView txvTelefone;
    TextView txvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        txvNome = findViewById(R.id.txvNome);
        txvTelefone = findViewById(R.id.txvTelefone);
        txvEmail = findViewById(R.id.txvEmail);

        Bundle args = getIntent().getExtras();



    }
}
