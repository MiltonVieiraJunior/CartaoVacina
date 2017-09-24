package com.neri.alexa.cartaovacina.Repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.neri.alexa.cartaovacina.Modal.Usuario;


/**
 * Created by alexa on 17/09/2017.
 */

public class BancoDados extends SQLiteOpenHelper{

    private static String NOME_BANCO = "cartaovacina.db";
    private static final int VERSAO = 1;
    private static final String ID = "id";
    private static final String TABELA = "usuario";
    private static final String NOME =  "nome";
    private static final String EMAIL = "email";


    public BancoDados(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       String sql  =  "CREATE TABLE "+TABELA+" ( "+
               " " + ID + " integer primary key autoincrement, " +
               " "+NOME+" text, " +EMAIL+ " text );";

       db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IS EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);

    }

    public long salvaUsuario (Usuario u){
        ContentValues values = new ContentValues();
        long retornoBD;

        values.put (NOME, u.getNome());
        values.put (EMAIL, u.getEmail());

        retornoBD = getWritableDatabase().insert(TABELA, null, values);

        return  retornoBD;
    }
}
