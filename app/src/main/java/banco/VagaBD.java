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

import classe.Vaga;

/**
 * Created by Andreh on 15/04/2017.
 */

public class VagaBD extends SQLiteOpenHelper {
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public VagaBD(Context context) {
        super(context, "Vagas", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Vaga (_id integer primary key autoincrement, nome text," +
                " desc text, local text, anuncio text);");
    }

    public List<Vaga> consultarVagas() {
        List<Vaga> lista = new ArrayList();

        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor cursor = db.rawQuery("SELECT _id, nome, desc, local, anuncio FROM Vaga", null);
            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {
                Vaga vaga = new Vaga();
                vaga.setIdVaga(cursor.getLong(0));
                vaga.setNome(cursor.getString(1));
                vaga.setDesc(cursor.getString(2));
                vaga.setLocal(cursor.getString(3));
                vaga.setAnuncio(df.parse(cursor.getString(4)));
                lista.add(vaga);
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

    public List<Vaga> consultaFiltro(String filtro) {
        List<Vaga> lista = new ArrayList();

        SQLiteDatabase db = getReadableDatabase();

        try {
            Cursor cursor = db.rawQuery("SELECT _id, nome, desc, local, anuncio " +
                    "  FROM Vaga " +
                    " where nome like '%" + filtro + "%'", null);

            cursor.moveToFirst();

            for (int i = 0; i < cursor.getCount(); i++) {
                Vaga vaga = new Vaga();
                vaga.setIdVaga(cursor.getLong(0));
                vaga.setNome(cursor.getString(1));
                vaga.setDesc(cursor.getString(2));
                vaga.setLocal(cursor.getString(3));
                vaga.setAnuncio(df.parse(cursor.getString(4)));
                lista.add(vaga);
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

    public Vaga salvarVaga(Vaga vaga) {
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("nome", vaga.getNome());
            values.put("desc", vaga.getDesc());
            values.put("local", vaga.getLocal());
            values.put("anuncio", df.format(vaga.getAnuncio()));
            db.insert("Vaga", null, values);
        } finally {
            db.close();
        }
        return vaga;
    }

}
