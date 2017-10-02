package com.neri.alexa.cartaovacina.Repositorio;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Toast;

import com.neri.alexa.cartaovacina.Modal.Usuario;

public class BancoDados extends Activity {

    private static  final String NOME_BANCO = "cartaovacina.db";
    private static final int VERSAO = 1;
    private static final String ID = "id";
    private static final String TABELA = "usuario";
    private static final String NOME =  "nome";
    private static final String EMAIL = "email";
    private SQLiteDatabase banco;

    @Override
    public void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);

        setBanco(openOrCreateDatabase(NOME_BANCO, MODE_PRIVATE, null));

        getBanco().execSQL( "CREATE TABLE IF NOT EXISTS "+TABELA+" ( "+
                ID+" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                NOME+" VARCHAR, " +
                EMAIL+ " VARCHAR );");
    }

    public boolean salvaUsuario (Usuario user){
        try{
            Cursor cursor = getBanco().rawQuery("SELECT * FROM "+TABELA+" WHERE "+EMAIL+" = '"+user.getEmail()+"'", null);
            cursor.moveToFirst();

            if (cursor == null){
                getBanco().execSQL("INSERT INTO "+TABELA+" ("+NOME+", "+EMAIL+") VALUES ('"+user.getNome()+"', '"+user.getEmail()+"');");
                return true;
            } else {
                Toast.makeText(getApplicationContext(), "Já existe um usuário com este e-mail", Toast.LENGTH_LONG);
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public SQLiteDatabase getBanco() {
        return banco;
    }

    public void setBanco(SQLiteDatabase banco) {
        this.banco = banco;
    }
}