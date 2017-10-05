package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.neri.alexa.cartaovacina.Model.Usuario;
import com.neri.alexa.cartaovacina.Model.Vacina;
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



       // vacinas = (Spinner) findViewById(R.id.spinner);
       // String []opciones = {"hepatite", "sarampo","toma"};

      //  ArrayAdapter<String> adapter = new  ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,opciones);
      //  vacinas.setAdapter(adapter);

        Button addVacina =  (Button) findViewById(R.id.ADDvaciana);
        final EditText editText = (EditText) findViewById(R.id.editTextVacinaAdd);

        addVacina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Vacina va = new Vacina("hepatite","12","fdf","fddf");


                usuario.setVacina(va);

                bd.salvaVacina(usuario);

            }
        });









    }
}
