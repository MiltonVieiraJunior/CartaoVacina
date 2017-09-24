package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.neri.alexa.cartaovacina.Modal.Usuario;
import com.neri.alexa.cartaovacina.Repositorio.BancoDados;

public class CadastroActivity extends AppCompatActivity {

    private Button btnCadastra;
    private EditText editNome;
    private EditText editEmail;
    private Usuario usuario;
    private BancoDados banco;
    private long retorno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCadastra = (Button) findViewById(R.id.buttonCadastra);
        editNome = (EditText) findViewById(R.id.editTextName);
        editEmail = (EditText) findViewById(R.id.editTextEmail);

        Intent i = getIntent();

        usuario = new Usuario();
        banco = new BancoDados(CadastroActivity.this);

        btnCadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              usuario.setNome(  editNome.getText().toString());
              usuario.setNome( editEmail.getText().toString());

                retorno = banco.salvaUsuario(usuario);

                if (retorno == -1) {
                    alert("erro ao cadastra");
                } else {
                   alert("sucesso");
                }

            }
        });

    }


     private void alert(String s ){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
     }


}
