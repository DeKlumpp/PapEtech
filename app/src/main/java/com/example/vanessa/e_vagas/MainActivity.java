package com.example.vanessa.e_vagas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<String> opcoes;
    ArrayAdapter<String> adaptador;
    ListView lvOpcoes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declarar um objeto da lista.
        final String[] itens = {"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};

        //Pegar um componente ListView do layout de tela.
        ListView lista = (ListView) findViewById(R.id.lista);

        //Adicionar layout e valores do ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),
                android.R.layout.simple_list_item_1, itens);
        lista.setAdapter(adapter);

        //Notificar alteração na lista
        adapter.notifyDataSetChanged();

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSelecionado = itens[position];
                detalhes(view);
                }
        });}


    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.teste1:
                startActivity(new Intent(this, CadastroActivity.class));
                return true;
            case R.id.teste2:
                //startActivity(new Intent(this, CadastroActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        if(getIntent().getBooleanExtra("SAIR", false)){
            finish();
        }
        super.onResume();
    }
    public void detalhes(View v){startActivity(new Intent(this, DescVagaActivity.class));

        //cria o objeti lista
      /* lvOpcoes = (ListView) findViewById(R.id.list);

        opcoes = new ArrayList<String>();
        //adiciona os objetos ta lista
        opcoes.add("Navegar na Internet");
        opcoes.add("Fazer uma ligação");
        opcoes.add("Sobre");
        opcoes.add("Sair");

        adaptador = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, opcoes);
        lvOpcoes.setAdapter(adaptador);
            lvOpcoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    switch (position){
                        case 0: navegarInternet();
                            break;
                        case 1: fazerLigacao();
                            break;
                        case 2: exibirSobre();
                            break;
                        case 3: finish();
                            break;
                    }
                }
            });
        }
//acoes para clique
    private void exibirSobre() {
        Intent it = new Intent(MainActivity.this, actSobre.class);
        startActivity(it);
    }

    private void fazerLigacao() {
        Uri uri = Uri.parse("tel:0123456789012");
        Intent itNavegar = new Intent(Intent.ACTION_DIAL,uri);
        startActivity(itNavegar);
    }

    private void navegarInternet() {
        Uri uri = Uri.parse("http://www.devmedia.com.br");
        Intent itNavegar = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(itNavegar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            Toast.makeText(this,"Selecionou em configuração",Toast.LENGTH_SHORT).show();
            return true;
        }

        if (item.getItemId() == R.id.action_gravar) {
            Toast.makeText(this,"Selecionou em gravar",Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }*/
    }
}