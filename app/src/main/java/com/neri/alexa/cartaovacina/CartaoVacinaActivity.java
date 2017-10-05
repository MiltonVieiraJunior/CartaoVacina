package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.neri.alexa.cartaovacina.Model.Usuario;
import com.neri.alexa.cartaovacina.Repositorio.BancoDados;

public class CartaoVacinaActivity extends AppCompatActivity {

    private BancoDados bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao_vacina);

        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID",0);
        bd = new BancoDados(this);
        final Usuario usuario = bd.getUsuario(id);

        final TextView TextNome =  (TextView) findViewById(R.id.textViewNome);

        TextNome.setText(usuario.getNome());

        final Button alterar =  (Button) findViewById(R.id.buttonVacinaAlterar);
        final Button remover = (Button) findViewById(R.id.buttonRemoverVacina);
        final Button adicionarVacina = (Button) findViewById(R.id.buttonAdicionarVacina);

        ListView listaVacina =  (ListView) findViewById(R.id.listViewVacinasTomadas);

       // ArrayList<Usuario> listaUsuario = bd.getAllVacina();
       // VacinaTomadaAdapter adapter = new VacinaTomadaAdapter(this, listaUsuario);

      //  listaVacina.setAdapter(adapter);






        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(CartaoVacinaActivity.this, AlterarERemoverUsuarioActivity.class);
                intent.putExtra("ID", usuario.getId());
                startActivity(intent);
            }
        });

        remover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bd.deletaUsuario(usuario);
                finish();
            }
        });

        adicionarVacina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CartaoVacinaActivity.this, AdicionarVacinasActivity.class);
                intent.putExtra("ID", usuario.getId());
                startActivity(intent);
            }
        });




    }

}
