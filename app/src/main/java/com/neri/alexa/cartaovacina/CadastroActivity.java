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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        btnCadastra = (Button) findViewById(R.id.buttonCadastra);
        editNome = (EditText) findViewById(R.id.editTextName);
        editEmail = (EditText) findViewById(R.id.editTextEmail);


        btnCadastra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                setUsuario(new Usuario());
                BancoDados bd = new BancoDados(CadastroActivity.this);

                usuario.setNome(  editNome.getText().toString());
                usuario.setEmail(editEmail.getText().toString());

                boolean res =  bd.salvaUsuario(usuario);

                if (res=true) {
                    alert("cadsatrado");
                }else{
                    alert("Erro ao cadastra");
                }
            }
        });

    }


      private void alert(String s ){
        Toast.makeText(this,s, Toast.LENGTH_SHORT).show();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public BancoDados getBanco() {
        return banco;
    }

    public void setBanco(BancoDados banco) {
        this.banco = banco;
    }

}
