package com.example.vanessa.e_vagas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
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

    private VagaBD db = new VagaBD(this); //operações do banco da vaga
    Usuario usuario = new Usuario();

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);

        listaObj = db.consultarVagas();
        //Cria a lista na tela
        final ListView lista = (ListView) findViewById(R.id.lista);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listaVagas);
        lista.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        //traz o tipo de usuário com o resultado do cursor
        bundle = getIntent().getExtras();
        if (bundle != null) {
            String tipo = bundle.getString("status").toString();
            usuario.setTipo(tipo);
        }
        atualizaLista();

        //clique da vaga que apresenta os dados da vaga na outra tela
        final Intent intent = new Intent(this,DescVagaActivity.class);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick (AdapterView < ? > parent, View view,int position, long id){
                vaga = listaObj.get(position);
                String idVaga = vaga.getIdVaga().toString();
                intent.putExtra("status",usuario.getTipo());
                intent.putExtra("idVaga",idVaga);
                startActivity(intent);
            }
        });
    }

    public void pesquisaFiltro(View view) {
        EditText txtFiltro = (EditText) findViewById(R.id.pesquisa);
        listaObj = db.consultaFiltro(txtFiltro.getText().toString(), null);

        if (listaObj.isEmpty() == true)
            listaVagas.clear();
        else
            atualizaLista();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (usuario.getTipo().equals("emp")) {
            getMenuInflater().inflate(R.menu.menu_cadastrovaga, menu);   // linha que exibe o menu
        }
        return true;
    }

    private void novo(MenuItem item) {
        Intent intent = new Intent(getBaseContext(), CadastroVagaActivity.class);
        intent.putExtra("status", usuario.getTipo());
        startActivityForResult(intent, 2);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.cadastrovaga) novo(item);
        return super.onOptionsItemSelected(item);
    }

    public void atualizaLista() {
        df = android.text.format.DateFormat.getDateFormat(getApplicationContext());
        hf = android.text.format.DateFormat.getTimeFormat(getApplicationContext());
        listaVagas.clear();
        for (Vaga v : listaObj) {
            listaVagas.add(v.getNome() + " - " + df.format(v.getAnuncio()) +
                    " " + hf.format((v.getAnuncio())));
        }
    }

//    public void apresentarVaga(final int index) {

        //se ele insere o id automagicamente - é só apresentar ele na tela, ou deixar invisível,
        // daí vc puxa e faz a consulta no banco com esse id pra poder apresentar na outra tela.


        //lê do banco onde irá trazer  tabVaga.nome, tabVaga.local, tabVaga.desc e tabEmpresa.empresa

//        Intent intent = new Intent(this, DescVagaActivity.class);
//        setResult(Activity.RESULT_OK, intent);
//        finish();
//        startActivity(intent);
//    }
}


