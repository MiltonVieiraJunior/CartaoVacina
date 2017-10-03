package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.neri.alexa.cartaovacina.Modal.Usuario;
import com.neri.alexa.cartaovacina.Repositorio.BancoDados;

public class AdicionarVacinasActivity extends AppCompatActivity {

    private BancoDados bd;

    Spinner vacinas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_vacinas);

        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID",0);
        bd = new BancoDados(this);
        final Usuario usuario = bd.getUsuario(id);


        vacinas = (Spinner) findViewById(R.id.spinner);
        String []opciones = {"hepatite", "sarampo","toma"};

        ArrayAdapter<String> adapter = new  ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
        vacinas.setAdapter(adapter);







    }
}
