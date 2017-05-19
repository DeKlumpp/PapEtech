package com.example.vanessa.e_vagas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import banco.VagaBD;
import classe.Vaga;

public class DescVagaActivity extends AppCompatActivity {

    VagaBD vagaBD = new VagaBD(this);
    Vaga vagaOBJ = new Vaga();

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getIntent().getExtras();
        String idVaga = String.valueOf(bundle.getString("idVaga"));
        setContentView(R.layout.desc_vaga);
        //faz uma consulta no banco com o id/filtro e apresenta nos camposa
        List<Vaga> vaga = new ArrayList();
        vaga = vagaBD.consultaFiltro(null,idVaga);

        vagaOBJ = vaga.get(0);
        // o nome da empresa é a consulta no bancocom o id q foi logado anteriormente
        TextView txtEmp = (TextView) findViewById(R.id.empresaText);
        txtEmp.setText(vagaOBJ.getNome());
        TextView txtVaga = (TextView) findViewById(R.id.vagaText);
        txtVaga.setText(vagaOBJ.getNome());
        TextView txtLocal = (TextView) findViewById(R.id.localText);
        txtLocal.setText(vagaOBJ.getLocal());
        TextView txtDescricao = (TextView) findViewById(R.id.descricaoText);
        txtDescricao.setText(vagaOBJ.getDesc());
    }

    public void voltarVaga(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }


    public void enviarEmail(View view) {

        Log.i("email: ","");
        String emailDestino = "andremian@hotmail.com";
        String assunto = "Vaga 123";
        String mensagem = "Dennis babaca";

        String to = emailDestino;
        String subject = assunto;
        String message = mensagem;

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        //need this to prompts email client only
        email.setType("message/rfc822");
        try {
            startActivity(Intent.createChooser(email, "E-mail"));
            finish();
        } catch (Exception e) {
            Toast toast = Toast.makeText(this, "Enviado com Sucesso para o E-mail: " + emailDestino, Toast.LENGTH_LONG);
            toast.show();
            e.printStackTrace();
        }
    }
}
