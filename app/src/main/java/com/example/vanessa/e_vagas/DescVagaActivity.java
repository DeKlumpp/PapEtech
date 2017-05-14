package com.example.vanessa.e_vagas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
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
    String email = "caio@etech.com.br";
    public void enviarEmail(View view){
        Toast toast = Toast.makeText(this, "Enviado com Sucesso para o E-mail: "+ email, Toast.LENGTH_LONG);
        toast.show();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
