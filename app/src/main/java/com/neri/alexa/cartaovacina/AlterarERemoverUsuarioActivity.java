package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.neri.alexa.cartaovacina.Model.Usuario;
import com.neri.alexa.cartaovacina.Repositorio.BancoDados;

public class AlterarERemoverUsuarioActivity extends AppCompatActivity {

    private BancoDados bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_eremover_usuario);

        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID",0);
        bd= new BancoDados(this);
        final Usuario usuario = bd.getUsuario(id);

        final EditText EditNome =  (EditText) findViewById(R.id.editTextEDItarNome);
        final EditText EditEmail =  (EditText) findViewById(R.id.editTextEditarEmail);

        EditNome.setText(usuario.getNome());
        EditEmail.setText(usuario.getEmail());


        Button alterar =  (Button) findViewById(R.id.buttonAlterarUsuario);


        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuario.setNome(usuario.getNome().toString());
                usuario.setEmail(usuario.getEmail().toString());
                bd.atualizaUsuario(usuario);
                Toast.makeText(getBaseContext(), "Usuario alterado com sucesso.", Toast.LENGTH_LONG).show();
                finish();
            }
        });





    }
}
