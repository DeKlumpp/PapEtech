package com.example.vanessa.e_vagas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TabHost;
import android.widget.Toast;

import banco.UsuarioBD;
import classe.Usuario;

public class CadastroActivity extends AppCompatActivity {
    UsuarioBD userBD = new UsuarioBD(this);
    Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide(); // tira a barra azul de cima (Teste)
        setContentView(R.layout.cadastro);

        TabHost abas = (TabHost) findViewById(R.id.tabhost);
        abas.setup();

        TabHost.TabSpec descritor = abas.newTabSpec("aba1");
        descritor.setContent(R.id.Pessoa_Fisica);
        descritor.setIndicator(getString(R.string.cadastroPF));
        abas.addTab(descritor);

        descritor = abas.newTabSpec("aba2");
        descritor.setContent(R.id.Pessoa_Juridica);
        descritor.setIndicator(getString(R.string.cadastroPJ));
        abas.addTab(descritor);
    }

    public void cadastrarPF(View view) {

        usuario.setUsuario(((EditText) findViewById(R.id.nomeTextPJ)).getText().toString());
        usuario.setSobrenome(((EditText) findViewById(R.id.sobrenomeTextPF)).getText().toString());
        usuario.setCpf(((EditText) findViewById(R.id.cpfTextPF)).getText().toString());
        usuario.setEmail(((EditText) findViewById(R.id.emailTextPF)).getText().toString());
        usuario.setSenha(((EditText) findViewById(R.id.senhaTextPF)).getText().toString());

        userBD.CadastrarUsuario(usuario);

        mensagemLogin();
    }

    public void cadastrarPJ(View view) {

        usuario.setNome(((EditText) findViewById(R.id.nomeTextPJ)).getText().toString());
        usuario.setCnpj(((EditText) findViewById(R.id.cnpjPJ)).getText().toString());
        usuario.setEmail(((EditText) findViewById(R.id.emailTextPJ)).getText().toString());
        usuario.setSenha(((EditText) findViewById(R.id.senhaTextPJ)).getText().toString());

        userBD.CadastrarEmpresa(usuario);
        mensagemLogin();
    }

    private void mensagemLogin(){
        Context context = this;
        Toast toast = Toast.makeText(context, "Cadastrado com Sucesso", Toast.LENGTH_LONG);
        toast.show();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

}

