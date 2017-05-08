package com.example.vanessa.e_vagas;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import banco.EmpresaBD;
import classe.UsuarioEmpresa;

public class CadastroActivity extends AppCompatActivity{

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

   public void mensagenExibir(View view){

       UsuarioEmpresa usuarioEmpresa = new UsuarioEmpresa();
       usuarioEmpresa.setEmpresa(String.valueOf(R.id.nomeTextPJ));
       usuarioEmpresa.setCnpj(String.valueOf(R.id.cnpjPJ));
       usuarioEmpresa.setEmail(String.valueOf(R.id.emailTextPJ));
       usuarioEmpresa.setSenha(String.valueOf(R.id.senhaTextPJ));
       EmpresaBD empresa = new EmpresaBD(this);

       empresa.CadastrarEmpresa(usuarioEmpresa);

       if(
                usuarioEmpresa.getEmpresa().equals(String.valueOf(R.id.nomeTextPJ)) &&
                usuarioEmpresa.getCnpj().equals(String.valueOf(R.id.cnpjPJ)) &&
                usuarioEmpresa.getEmail().equals(String.valueOf(R.id.emailTextPJ)) &&
                usuarioEmpresa.getSenha().equals(String.valueOf(R.id.senhaTextPJ))) {

           Context context = this;
           Toast toast = Toast.makeText(context, "Cadastrado com Sucesso", Toast.LENGTH_LONG);
           toast.show();
           startActivity(new Intent(this, LoginActivity.class));
           finish();
       }

}
}

