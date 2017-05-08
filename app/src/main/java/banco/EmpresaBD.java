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

import classe.UsuarioEmpresa;

/**
 * Created by Caio on 04/05/2017.
 */

public class EmpresaBD extends SQLiteOpenHelper{

    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public EmpresaBD(Context context) {
        super(context, "Valet", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Usuario (_id integer primary key autoincrement, empresa text," +
                " cnpj text, email text, senha text);");
    }

    public List<UsuarioEmpresa> consultarCadastros() {
        List<UsuarioEmpresa> lista = new ArrayList();

        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor cursor = db.rawQuery("SELECT _id, empresa, cnpj, email, senha FROM Usuario", null);
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {
                UsuarioEmpresa empresa = new UsuarioEmpresa();
                empresa.setId(cursor.getLong(0));
                empresa.setEmpresa(cursor.getString(1));
                empresa.setCnpj(cursor.getString(2));
                empresa.setEmail(cursor.getString(3));
                empresa.setSenha(cursor.getString(4));
                lista.add(empresa);
                cursor.moveToNext();
            }
            cursor.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return lista;
    }

    public UsuarioEmpresa CadastrarEmpresa(UsuarioEmpresa empresa) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("empresa", empresa.getEmpresa());
            values.put("cnpj", empresa.getCnpj());
            values.put("email", empresa.getEmail());
            values.put("senha", empresa.getSenha());
            //values.put("id_empresa", empresa.getId());        pega o id do objeto empresa e insere no banco

            if (empresa.getId() == null) {
                long id = db.insert("Usuario", null, values);
                empresa.setId(id);
            }
        } finally {
            db.close();
        }
        return empresa;
    }



    public boolean consultaEmpresa(String email, String senha) {

        SQLiteDatabase db = getReadableDatabase();

            Cursor cursor = db.rawQuery("SELECT nome, senha " + "  FROM Usuario " +
                    " where nome = " + email + "and senha = " + senha, null);

            cursor.moveToFirst();
            cursor.close();
        if (cursor.getCount() != 0)
        return true;

        return false;
    }



}
