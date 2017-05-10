package banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import classe.Usuario;

/**
 * Created by Caio on 04/05/2017.
 */

public class UsuarioBD extends SQLiteOpenHelper {

    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public UsuarioBD(Context context) {
        super(context, "Usuarios", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Usuario (_id integer primary key autoincrement, " +
                "nome text, sobrenome text, cpf text, cnpj text, email text, senha text);");

    }

    public Usuario CadastrarUsuario(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("nome", usuario.getUsuario());
            values.put("sobrenome", usuario.getSobrenome());
            values.put("cpf", usuario.getCpf());
            values.put("cnpj", (byte[]) null);
            values.put("email", usuario.getEmail());
            values.put("senha", usuario.getSenha());
            //values.put("id_empresa", empresa.getId());        pega o id do objeto empresa e insere no banco

            if (usuario.getId() == null) {
                long id = db.insert("Usuario", null, values);
                usuario.setId(id);
            }
        } finally {
            db.close();
        }
        return usuario;
    }

    public Usuario CadastrarEmpresa(Usuario usuario) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("nome", usuario.getNome());
            values.put("sobrenome", (byte[]) null);
            values.put("cpf", (byte[]) null);
            values.put("cnpj", usuario.getCnpj());
            values.put("email", usuario.getEmail());
            values.put("senha", usuario.getSenha());

            //values.put("id_empresa", empresa.getId());        pega o id do objeto empresa e insere no banco

            if (usuario.getId() == null) {
                long id = db.insert("Usuario", null, values);
                usuario.setId(id);
            }
        } finally {
            db.close();
        }
        return usuario;
    }

    public boolean consultaLogin(String email, String senha) {
        List<Usuario> login = new ArrayList();
        Usuario user = new Usuario();
        SQLiteDatabase db = getReadableDatabase();
        boolean logado;

        try {
            Cursor cursor = db.rawQuery("SELECT email, senha " + "  FROM Usuario " +
                    " where email like '" + email + "' and senha like '" + senha + "'", null);

            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {
                user.setEmail(cursor.getString(0));
                user.setSenha(cursor.getString(1));
                login.add(user);
                cursor.moveToNext();
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        if (user.getEmail().equals(email) && user.getSenha().equals(senha))
             logado = true;
        else
            logado = false;

        return logado;
    }
}


//    public List<UsuarioEmpresa> consultarCadastros() {
//        List<UsuarioEmpresa> lista = new ArrayList();
//
//        SQLiteDatabase db = getReadableDatabase();
//
//        try {
//            Cursor cursor = db.rawQuery("SELECT _id, empresa, cnpj, email, senha FROM Usuario", null);
//            cursor.moveToFirst();
//
//            for (int i = 0; i < cursor.getCount(); i++) {
//                UsuarioEmpresa empresa = new UsuarioEmpresa();
//                empresa.setId(cursor.getLong(0));
//                empresa.setEmpresa(cursor.getString(1));
//                empresa.setCnpj(cursor.getString(2));
//                empresa.setEmail(cursor.getString(3));
//                empresa.setSenha(cursor.getString(4));
//                lista.add(empresa);
//                cursor.moveToNext();
//            }
//            cursor.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            db.close();
//        }
//        return lista;
//    }