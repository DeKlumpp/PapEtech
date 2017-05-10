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
import banco.UsuarioBD;
import banco.VagaBD;
import classe.Usuario;

public class LoginActivity extends AppCompatActivity {

    boolean statusMenu;
    private TextView output;
    private DataHelper dh;
    EditText editLogin;
//    Usuario usuario;
    VagaBD v;
    Usuario usuario = new Usuario();
    UsuarioBD bd = new UsuarioBD(this);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //deve-se setar os valores com uma consulta do banco,
        // pois ela identifica o usuário PJ com PF
//        usuario = new Usuario("teste", "teste", "emp","as","as","as","as");
        usuario.setTipo("emp");
    }

    public void abrir(View view) {
        startActivity(new Intent(this, CadastroActivity.class));
    }

    public void abrirMain(View view) {

        EditText txtLogin = (EditText) findViewById(R.id.loginText);
        EditText txtSenha = (EditText) findViewById(R.id.senhaText);

        //colocar um if pra ver se retorna o user correto
        if (bd.consultaLogin(txtLogin.getText().toString(), txtSenha.getText().toString()) == true) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("status", usuario.getTipo());
            setResult(Activity.RESULT_OK, intent);
            finish();
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(this, "Usuario ou senha incorretos", Toast.LENGTH_LONG);
            toast.show();
        }
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




