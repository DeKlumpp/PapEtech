package com.example.vanessa.e_vagas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }

    public void startCadastroActivity(View view){
        Intent cadastroActivity = new Intent(this, CadastroActivity.class);
        startActivity(cadastroActivity);
    }
}



