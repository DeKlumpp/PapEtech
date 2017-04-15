package com.example.vanessa.e_vagas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import banco.DataHelper;

public class LoginActivity extends AppCompatActivity {

    private TextView output;
    private DataHelper dh;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }
//
//        this.output = (TextView) this.findViewById(R.id.out_text);
//
//        this.dh = new DataHelper(this);
//        /*this.dh.deleteAll();*/
//        this.dh.insert("Caio", "Caio");
//
//        List<String> names = this.dh.selectAll();
//        StringBuilder sb = new StringBuilder();
//        sb.append("Names in database:\n");
//        for (String name : names) {
//            sb.append(name + "\n");
//        }
//
//        Log.d("EXAMPLE", "names size - " + names.size());
//
//        this.output.setText(sb.toString());
//    }
//
//    public void abrir(View v){
//        startActivity(new Intent(this, CadastroActivity.class));
//    }
//    public void abrirMain(View v){
//        startActivity(new Intent(this, MainActivity.class));
//    }

}



