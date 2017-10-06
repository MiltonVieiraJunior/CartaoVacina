package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.neri.alexa.cartaovacina.Model.Usuario;
import com.neri.alexa.cartaovacina.Model.VacinaTomada;
import com.neri.alexa.cartaovacina.Repositorio.BancoDados;
import com.neri.alexa.cartaovacina.Repositorio.Bancodados2;

public class AdicionarVacinasActivity extends AppCompatActivity {

    private BancoDados bd;
    private Bancodados2 d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_vacinas);

        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID",0);
        bd = new BancoDados(this);
        d= new Bancodados2(this);
        final Usuario usuario = bd.getUsuario(id);

        Button addVacina =  (Button) findViewById(R.id.ADDvaciana);
        final EditText editText = (EditText) findViewById(R.id.editTextVacinaAdd);

        addVacina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                VacinaTomada va = new VacinaTomada();
                va.setNome(editText.getText().toString());
                va.setId(usuario.getId());
                d.salvaVacina(va);
                Toast.makeText(getBaseContext(), "Vacina Adicionada com Sucesso.", Toast.LENGTH_LONG).show();
                finish();

            }
        });
    }
}
