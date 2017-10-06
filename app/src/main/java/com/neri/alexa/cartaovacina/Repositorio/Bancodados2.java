package com.neri.alexa.cartaovacina.Repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.neri.alexa.cartaovacina.Model.VacinaTomada;

import java.util.ArrayList;

/**
 * Created by alexa on 06/10/2017.
 */

public class Bancodados2 extends SQLiteOpenHelper {

    private static String NOME_BANCO = "cartaovacina2.db";
    private static final int VERSAO = 1;
    private static final String ID_VACINA = "id_vacina";
    private static final String TABELA2 = "vacinass";
    private static final String VACINA = "vacina";

    public Bancodados2(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE IF NOT EXISTS " + TABELA2 + " ( " +
                " " + ID_VACINA + " integer primary key , " +
                " " + VACINA + " varchar  );";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABELA2;
        db.execSQL(sql);
        onCreate(db);
    }

    public void salvaVacina(VacinaTomada v) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put (ID_VACINA, v.getId());
        values.put(VACINA, v.getNome());

        db.insert(TABELA2, null, values);
        db.close();
    }

    private VacinaTomada cursorToVacina(Cursor cursor) {
        VacinaTomada vacina = new VacinaTomada();
        vacina.setId(Integer.parseInt(cursor.getString(0)));
        vacina.setNome(cursor.getString(1));

        return vacina;
    }

    public ArrayList<VacinaTomada> getAllVacina(int i) {

        ArrayList<VacinaTomada> listaVacina = new ArrayList<VacinaTomada>();

        String query = "SELECT * FROM " + TABELA2 +" WHERE "+ID_VACINA+ " = " +String.valueOf(i);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                VacinaTomada va = cursorToVacina(cursor);
                listaVacina.add(va);
            } while (cursor.moveToNext());
        }
        return listaVacina;
    }

    public int deleteVacinao (VacinaTomada vacina)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        int i = db.delete(TABELA2,ID_VACINA+"=?", new String[] {String.valueOf(vacina.getId())});
        db.close();
        return i;
    }
}

