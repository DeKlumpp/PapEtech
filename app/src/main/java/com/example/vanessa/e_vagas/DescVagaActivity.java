package com.example.vanessa.e_vagas;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import banco.UsuarioBD;
import banco.VagaBD;
import classe.Usuario;
import classe.Vaga;

public class DescVagaActivity extends AppCompatActivity {

    private AlertDialog dialog;
    VagaBD vagaBD = new VagaBD(this);
    Vaga vagaOBJ = new Vaga();
    Usuario usuario = new Usuario();
    UsuarioBD usuarioBD = new UsuarioBD(this);

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bundle = getIntent().getExtras();

        String idVaga = String.valueOf(bundle.getString("idVaga"));
        String tipoUser = String.valueOf(bundle.getString("status"));
        usuario.setTipo(tipoUser);
        String curriculo = String.valueOf(bundle.getString("cv"));

        if (tipoUser.equals("user"))
            usuario.setCv(curriculo);

        setContentView(R.layout.desc_vaga);
        //faz uma consulta no banco com o id/filtro e apresenta nos camposa
        List<Vaga> vaga = new ArrayList();
        vaga = vagaBD.consultaFiltro(null, idVaga);

        vagaOBJ = vaga.get(0);
        // o nome da empresa é a consulta no banco com o id q foi logado anteriormente
        TextView txtEmp = (TextView) findViewById(R.id.empresaText);
        txtEmp.setText(vagaOBJ.getNome().toString());
        TextView txtVaga = (TextView) findViewById(R.id.vagaText);
        txtVaga.setText(vagaOBJ.getNome().toString());
        TextView txtLocal = (TextView) findViewById(R.id.localText);
        txtLocal.setText(vagaOBJ.getLocal());
        TextView txtDescricao = (TextView) findViewById(R.id.descricaoText);
        txtDescricao.setText(vagaOBJ.getDesc());
    }

    public void voltarVaga(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public AlertDialog mostraPoPup() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.confirma);
        builder.setMessage("Confirma candidatura?");
        builder.setPositiveButton(getString(R.string.sim), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                enviarEmail();
            }
        });
        builder.setNegativeButton(getString(R.string.nao), null);
        return builder.create();
    }

    //o dialog chama esse cara
    public void enviarEmail() {
        Log.i("email: ", "");

        String emailEmp = vagaOBJ.getEmail();
        String emailDestino = emailEmp;
        String assunto = "Candidato para a vaga " + vagaOBJ.getNome();
        String mensagem = "Informações sobre o candidato: " + usuario.getCv();

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
            e.printStackTrace();
        }
    }

    public void confirmarEnvio(View view) {
        if (usuario.getTipo().equals("emp")) {
            Toast toast = Toast.makeText(this, "Não é possível enviar", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            dialog = mostraPoPup();
            dialog.show();
        }
    }
}
