package com.example.vanessa.e_vagas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

import banco.VagaBD;
import classe.Usuario;
import classe.Vaga;

public class CadastroVagaActivity extends AppCompatActivity {
    private DateFormat df = null;
    private DateFormat hf = null;
    Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getIntent().getExtras();
        if (bundle != null) {
            String tipo = bundle.getString("status").toString();
            usuario.setTipo(tipo);
        }
        setContentView(R.layout.cadastro_vaga);

        df = android.text.format.DateFormat.getDateFormat(getApplicationContext());
        hf = android.text.format.DateFormat.getTimeFormat(getApplicationContext());
    }

    public void cadastrarVaga(View view) {
        VagaBD db = new VagaBD(this);
        Vaga vaga = new Vaga();

        vaga.setNome(((EditText) findViewById(R.id.nomeVaga)).getText().toString());
        vaga.setDesc(((EditText) findViewById(R.id.descricaoVaga)).getText().toString());
        vaga.setLocal(((EditText) findViewById(R.id.localVaga)).getText().toString());
        vaga.setAnuncio(new Date());

        Toast toast = Toast.makeText(this, "Informe o nome, descrição e local da vaga.", Toast.LENGTH_SHORT);

        if (vaga.getNome().toString().trim().isEmpty() || vaga.getDesc().toString().trim().isEmpty() ||
                vaga.getLocal().toString().trim().isEmpty())
            toast.show();
        else {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("status",usuario.getTipo());
            //salva a vaga no banco
            db.salvarVaga(vaga);
            finish();
            startActivity(intent);
        }
    }
}
