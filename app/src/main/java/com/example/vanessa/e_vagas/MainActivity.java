package com.example.vanessa.e_vagas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import banco.VagaBD;
import classe.Usuario;
import classe.Vaga;

public class MainActivity extends AppCompatActivity {

    private List<String> listaVagas = new ArrayList(); //lista de vagas da tela
    private List<Vaga> listaObj = new ArrayList();

    private ArrayAdapter<String> adapter;
    LoginActivity login = new LoginActivity();

    private DateFormat df = null;
    private DateFormat hf = null;

    private AlertDialog dialog;
    private Vaga vaga = null; //objeto que transita as informações

    private VagaBD db; //operações do banco da vaga
    Usuario usuario;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        df = android.text.format.DateFormat.getDateFormat(getApplicationContext());
        hf = android.text.format.DateFormat.getTimeFormat(getApplicationContext());

        db = new VagaBD(this);

        //consulta todas as vagas automaticamente quando entra na tela
        listaObj = db.consultarVagas();

        //Cria a lista na tela
        final ListView lista = (ListView) findViewById(R.id.lista);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaVagas);
        lista.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        bundle = getIntent().getExtras();
        String tipo = bundle.getString("status").toString();

        usuario = new Usuario("teste", "teste", tipo);

        //Traz os itens do banco
        atualizaLista();

    }

    public void apresentarVaga(final int index) {

        //lê do banco onde irá trazer  tabVaga.nome, tabVaga.local, tabVaga.desc e tabEmpresa.empresa
//
//        Intent intent = new Intent(this, DescVagaActivity.class);
//        setResult(Activity.RESULT_OK, intent);
//        finish();
//        startActivity(intent);
    }


    //implementar clique da vaga que apresenta os dados da vaga na outra tela
//        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                listaObj.get(position);
//                apresentarVaga(position);
//
//            }
//        });

    public void pesquisaFiltro(View view) {

        EditText txtFiltro = (EditText) findViewById(R.id.pesquisa);

        listaObj = db.consultaFiltro(txtFiltro.getText().toString());

        if (listaObj.isEmpty() == true)
            listaVagas.clear();
        else
            atualizaLista();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //ao invés de us, deve se usar o tipo empresa
        if (usuario.getTipo().equals("emp")){
            //linha que exibe o menu
            getMenuInflater().inflate(R.menu.menu_cadastrovaga, menu);
        }
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
    }
}


