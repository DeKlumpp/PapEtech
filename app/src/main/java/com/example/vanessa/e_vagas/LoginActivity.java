package com.example.vanessa.e_vagas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import banco.DataHelper;
import banco.VagaBD;
import classe.Usuario;

public class LoginActivity extends AppCompatActivity {

    boolean statusMenu;
    private TextView output;
    private DataHelper dh;
    EditText editLogin;
    Usuario usuario;
    VagaBD v;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        usuario = new Usuario("teste","teste","us");
    }

    public void abrirMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("status",usuario.getTipo());
        setResult(Activity.RESULT_OK,intent);
        finish();
        startActivity(intent);
    }
}


//aqui estou fazendo um teste pra abrir o menu de add vagas para empresas e esconder para usuário comuns
//editLogin pega o que for digitado no Usuario do login
//        editLogin = (EditText) findViewById(R.id.loginText);


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


//
//    public void abrirMain(View v){
//        //O botão do login chama esse método para verificar se vai aparecer o menu ou não(ainda n está fucnionando)
//        //coloquei dois tipos de usuário US= usuario , e = Empresa.
//        if(editLogin.getText().toString().equals(u.getUsuario().toString())){
//            if(u.getTipo().toString() == "e") {
//                statusMenu = true;
//                startActivity(new Intent(this, MainActivity.class));
//            }
//        }
//        if(editLogin.getText().toString().equals(u.getUsuario().toString())){
//            if(u.getTipo().toString() == "us") {
//                statusMenu = true;
//                startActivity(new Intent(this, MainActivity.class));
//            }
//        }
//
//        else{
//            Toast toast = Toast.makeText(this, "Erro no Login", Toast.LENGTH_LONG);
//            toast.show();
//        }
//    }




