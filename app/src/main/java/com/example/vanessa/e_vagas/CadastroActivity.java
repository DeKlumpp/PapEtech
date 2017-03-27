package com.example.vanessa.e_vagas;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);
    }

   public void mensagenExibir(View view){
        Context context = this;
        Toast toast = Toast.makeText(context, "Cadastrado com Sucesso", Toast.LENGTH_LONG);
        toast.show();
       setContentView(R.layout.login);

};
}

