package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.neri.alexa.cartaovacina.Adapter.UsuarioAdapter;
import com.neri.alexa.cartaovacina.Modal.Hospital;
import com.neri.alexa.cartaovacina.Modal.Usuario;
import com.neri.alexa.cartaovacina.Repositorio.BancoDados;

import java.util.ArrayList;

public class ListaUsuarioActivity extends AppCompatActivity {

    private BancoDados bd;
    ArrayList<Usuario> listaUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bd =new BancoDados(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);
    }

    @Override
    protected void onStart() {
        super.onStart();

        ListView lista = (ListView) findViewById(R.id.listVIewUsuario);
        listaUsuario = bd.getAllUsuario();
        UsuarioAdapter adapter = new UsuarioAdapter(this, listaUsuario);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListaUsuarioActivity.this, CartaoVacinaActivity.class);
                intent.putExtra("ID", listaUsuario.get(position).getId());
                startActivity(intent);
            }
        });


    }

}

