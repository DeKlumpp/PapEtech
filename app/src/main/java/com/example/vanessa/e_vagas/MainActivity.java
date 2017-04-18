package com.example.vanessa.e_vagas;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.text.Editable;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import banco.VagaBD;
import classe.Vaga;

public class MainActivity extends AppCompatActivity {

    private List<String> listaVagas = new ArrayList(); //lista de vagas da tela
    private List<Vaga> listaObj = new ArrayList();

    private ArrayAdapter<String> adapter;

    private DateFormat df = null;
    private DateFormat hf = null;

    private AlertDialog dialog;
    private Vaga vaga = null; //objeto que transita as informações

    private VagaBD db; //operações do banco da vaga

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        df = android.text.format.DateFormat.getDateFormat(getApplicationContext());
        hf = android.text.format.DateFormat.getTimeFormat(getApplicationContext());

        db = new VagaBD(this);
        //consulta todas as vagas automaticamente quando entra na tela
        listaObj = db.consultarVagas();

        // seta/adiciona a vaga na lista
        atualizaLista();

    }

    public void abrirVaga(View v) {
        startActivity(new Intent(this, DescVagaActivity.class));
        finish();
    }

    public void pesquisaFiltro(View view) {

        EditText txtFiltro = (EditText) findViewById(R.id.pesquisa);

        listaObj = db.consultaFiltro(txtFiltro.getText().toString());

        if (listaObj.isEmpty() == true)
            listaVagas.clear();

        else {
            atualizaLista();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cadastrovaga, menu);
        return true;
    }

    private void novo(MenuItem item) {
        Intent intent = new Intent(getBaseContext(), CadastroVagaActivity.class);
        startActivityForResult(intent, 2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.cadastrovaga) novo(item);
        return super.onOptionsItemSelected(item);
    }

    public void atualizaLista() {
        listaVagas.clear();
        for (Vaga v : listaObj) {
            listaVagas.add(v.getNome() + " - " + df.format(v.getAnuncio()) +
                    " " + hf.format((v.getAnuncio())));
        }

        final ListView lista = (ListView) findViewById(R.id.lista);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaVagas);
        lista.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}


