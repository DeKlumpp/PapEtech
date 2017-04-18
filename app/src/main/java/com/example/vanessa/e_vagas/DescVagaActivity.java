package com.example.vanessa.e_vagas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class DescVagaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.desc_vaga);
    }

    public void voltarVaga(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
    String email = "caio@etech.com.br";
    public void enviarEmail(View view){
        Toast toast = Toast.makeText(this, "Enviado com Sucesso para o E-mail: "+email, Toast.LENGTH_LONG);
        toast.show();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
