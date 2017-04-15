package com.example.vanessa.e_vagas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Date;

import banco.VagaBD;
import classe.Vaga;

public class CadastroVagaActivity extends AppCompatActivity {
    private DateFormat df = null;
    private DateFormat hf = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro_vaga);

        df = android.text.format.DateFormat.getDateFormat(getApplicationContext());
        hf = android.text.format.DateFormat.getTimeFormat(getApplicationContext());

    }

    public void cadastrarVaga(View view) {

        //manda a vaga pra outra tela
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("nome", ((EditText) findViewById(R.id.nomeVaga)).getText().toString());
        intent.putExtra("desc", ((EditText) findViewById(R.id.descricaoVaga)).getText().toString());
        intent.putExtra("local", ((EditText) findViewById(R.id.localVaga)).getText().toString());
        setResult(Activity.RESULT_OK,intent);
        finish();

        //salva a vaga no banco
        VagaBD db = new VagaBD(this);
        Vaga vaga = new Vaga();
        vaga.setNome(((EditText) findViewById(R.id.nomeVaga)).getText().toString());
        vaga.setDesc(((EditText) findViewById(R.id.descricaoVaga)).getText().toString());
        vaga.setLocal(((EditText) findViewById(R.id.localVaga)).getText().toString());
        vaga.setAnuncio(new Date());
        db.salvarVaga(vaga);
        startActivity(intent);
    }
}
