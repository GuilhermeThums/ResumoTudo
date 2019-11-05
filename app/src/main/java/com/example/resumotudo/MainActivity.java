package com.example.resumotudo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtNome;
    EditText edtTelefone;
    EditText edtEmail;
    EditText edtSenha;
    RadioGroup rdgSexo;
    Button button1;
    Spinner spinnerPais;
    Spinner spinnerEstado;
    Spinner spinnerCidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNome = findViewById(R.id.edtNome);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtEmail = findViewById(R.id.edtEmail);
        edtSenha = findViewById(R.id.edtSenha);
        rdgSexo = findViewById(R.id.rdgSexo);
        //Manda uma mensagem TOAST quando algum radio button é selecionado
        rdgSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rdbMasculino){
                    Toast.makeText(getApplicationContext(), "Escolhido: Masculino!", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "Escolhido: Feminino!", Toast.LENGTH_SHORT).show();
            }
        });

        final String[] paises = getResources().getStringArray(R.array.array_paises);
        final String[] estados = getResources().getStringArray(R.array.array_estados);
        final String[] cidades = getResources().getStringArray(R.array.array_cidades_goias);

        spinnerPais = (Spinner) findViewById(R.id.spinnerPais);
        spinnerEstado = (Spinner) findViewById(R.id.spinnerEstado);
        spinnerCidade = (Spinner) findViewById(R.id.spinnerCidade);

        final ArrayAdapter<String> paisAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, paises);
        final ArrayAdapter<String> estadoAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, estados);
        final ArrayAdapter<String> cidadeAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, cidades);

        spinnerPais.setAdapter(paisAdapter);

        spinnerPais.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 29){
                    spinnerEstado.setAdapter(estadoAdapter);
                } else{
                    spinnerEstado.setAdapter(null);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        spinnerEstado.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if(position == 9){
                    spinnerCidade.setAdapter(cidadeAdapter);
                } else{
                    spinnerCidade.setAdapter(null);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        //Define o botão e um listener para saber quando ele foi clicado
        button1 = findViewById(R.id.btnSeguinte);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTela2();
            }
        });
    }
    //Método que será executado quando o botão for clicado
    private void abrirTela2() {
        //Pega o conteúdo dos editText e passa para strings em variáveis locais
        String nome = edtNome.getText().toString();
        String telefone = edtTelefone.getText().toString();
        String email = edtEmail.getText().toString();
        String senha = edtSenha.getText().toString();

        //Checa se algum campo está vazio
//TextUtil.isEmpty(string) vai checar se a string está vazia. Retorna true ou false
//string.trim() corta os espaços vazios antes e depois da string
//.isEmpty() verifica se a string está vazia. Pode resultar NullPointerException
        if (TextUtils.isEmpty(nome.trim())) {
            Toast.makeText(this, "Campo nome vazio", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(telefone.trim())) {
            Toast.makeText(this, "Campo telefone vazio", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(email.trim())) {
            Toast.makeText(this, "Campo e-mail vazio", Toast.LENGTH_SHORT).show();
        } else if (TextUtils.isEmpty(senha.trim())) {
            Toast.makeText(this, "Campo senha vazio", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Tudo ok!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, Tela2.class);
            Bundle passagem = new Bundle();
            passagem.putString("nome", nome);
            passagem.putString("telefone", telefone);
            passagem.putString("email", email);
            intent.putExtras(passagem);
            startActivity(intent);
        }
    }
}
