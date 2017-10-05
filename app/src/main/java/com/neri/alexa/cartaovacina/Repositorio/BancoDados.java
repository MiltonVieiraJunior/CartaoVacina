package com.neri.alexa.cartaovacina.Repositorio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.neri.alexa.cartaovacina.Model.Usuario;

import java.util.ArrayList;


/**
 * Created by alexa on 17/09/2017.
 * Editado por Ravi em 25/09/2017
 */

public class BancoDados extends SQLiteOpenHelper{

    private static String NOME_BANCO = "cartaovacina.db";
    private static final int VERSAO = 1;
    private static final String ID = "id";
    private static final String ID_VACINA =  "id_vacina";
    private static final String TABELA = "usuario";
    private static final String TABELA2 = "vacinas";
    private static final String NOME =  "nome";
    private static final String EMAIL = "email";
    private static final String DATA = "data";
    private static final String VACINA =  "vacina";
    private static final String sTABLE_USUARIO_VACINA = "tb_usuario_vacina";
    private static final String sCOLUMN_USUARIO = "usuario";



    private static  final String[] COLUNAS = {ID,NOME,EMAIL};


    public BancoDados(Context context){
        super(context,NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE IF NOT EXISTS " + TABELA + " ( " +
                " " + ID + " integer primary key autoincrement, " +
                " " + NOME + " varchar, " + EMAIL + " varchar " + DATA + " varchar  );" +

                "CREATE TABLE IF NOT EXISTS " + TABELA2 + " ( " +
                " " + ID_VACINA + " integer primary key autoincrement, " +
                " " + VACINA + " varchar " + "FOREIGN KEY(" + ID_VACINA + ") REFERENCES " + TABELA + "( " + ID + " );" +

                "CREATE TABLE IF NOT EXISTS " + sTABLE_USUARIO_VACINA + " ( " +
                " " + ID + " integer primary key autoincrement, " +
                " " + VACINA + " integer, "
                + sCOLUMN_USUARIO + " integer "
                + "FOREIGN KEY(" + VACINA + ") REFERENCES " + TABELA2 + "( " + ID + " );"
                + "FOREIGN KEY(" + sCOLUMN_USUARIO + ") REFERENCES " + TABELA + "( " + ID + " );";


        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS "+TABELA;
        db.execSQL(sql);
        onCreate(db);

    }

    public void salvaVacina (Usuario usuario){
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put (VACINA, usuario.getVacina().getNome());

        db.insert (TABELA2,null,values);
        db.close();

    }

    public boolean salvaUsuario (Usuario usuario)
    {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put (NOME, usuario.getNome());
        values.put (EMAIL, usuario.getEmail());

        db.insert (TABELA,null,values);
        db.close();
        return true;
    }

    public Usuario getUsuario(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =  db.query(TABELA, COLUNAS,"id = ?",new String[]{String.valueOf(id)},null,null,null,null);
        if (cursor==null){
            return null;
        }else{
            cursor.moveToFirst();
            Usuario usuario = cursorToUsuario(cursor);
            return usuario;
        }
    }

    private Usuario cursorToUsuario (Cursor cursor){
        Usuario usuario = new Usuario();
        usuario.setId(Integer.parseInt(cursor.getString(0)));
        usuario.setNome(cursor.getString(1));
        usuario.setEmail(cursor.getString(2));
        return usuario;
    }




    public ArrayList<Usuario> getAllVacina(){

        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

        String query = "SELECT * FROM " + TABELA;

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()){
            do{
                Usuario usuario = cursorToUsuario(cursor);
                listaUsuarios.add(usuario);

            }while (cursor.moveToNext());
        }
        return listaUsuarios;
    }








    public ArrayList<Usuario> getAllUsuario(){

        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

        String query = "SELECT * FROM " + TABELA;

        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);

       if (cursor.moveToFirst()){
            do{
                Usuario usuario = cursorToUsuario(cursor);
                listaUsuarios.add(usuario);

            }while (cursor.moveToNext());
      }
        return listaUsuarios;
    }


    public int atualizaUsuario (Usuario usuario)
    {
            SQLiteDatabase db =this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put (NOME, usuario.getNome());
            values.put (EMAIL, usuario.getEmail());

        int i = db.update(TABELA,values,ID+" = ? ", new String[] {String.valueOf(usuario.getId())});

        db.close();

        return i;
    }

    public int deletaUsuario (Usuario usuario)
    {

            SQLiteDatabase db=this.getWritableDatabase();

        int i = db.delete(TABELA,ID+"=?", new String[] {String.valueOf(usuario.getId())});
        db.close();
        return i;
    }





}
