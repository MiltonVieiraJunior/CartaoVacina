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

    public String salvaUsuario (Usuario user){
        try{
            Cursor cursor = getBanco().rawQuery("SELECT * FROM "+TABELA+" WHERE "+EMAIL+" = '"+user.getEmail()+"'", null);
            cursor.moveToFirst();

            if (cursor == null){
                getBanco().execSQL("INSERT INTO "+TABELA+" ("+NOME+", "+EMAIL+") VALUES ('"+user.getNome()+"', '"+user.getEmail()+"');");
                return "Usuário cadastrado com sucesso!";
            } else {
                return "Já existe um usuário com este e-mail!";
            }
        }catch(Exception e){
            e.printStackTrace();
            return "Erro ao cadastrar o usuário!";
        }
    }

    public SQLiteDatabase getBanco() {
        return banco;
    }

    public void setBanco(SQLiteDatabase banco) {
        this.banco = banco;
    }
}