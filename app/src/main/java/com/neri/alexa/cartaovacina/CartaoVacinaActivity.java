package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.neri.alexa.cartaovacina.Adapter.VacinaTomadaAdapter;
import com.neri.alexa.cartaovacina.Model.Usuario;
import com.neri.alexa.cartaovacina.Model.VacinaTomada;
import com.neri.alexa.cartaovacina.Repositorio.BancoDados;
import com.neri.alexa.cartaovacina.Repositorio.Bancodados2;

import java.util.ArrayList;

public class CartaoVacinaActivity extends AppCompatActivity {

    private BancoDados bd;
    private Bancodados2 d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cartao_vacina);

        d = new Bancodados2(this);
        Intent intent = getIntent();
        final int id = intent.getIntExtra("ID",0);
        bd = new BancoDados(this);
        final Usuario usuario = bd.getUsuario(id);

        final TextView TextNome =  (TextView) findViewById(R.id.textViewNome);

        TextNome.setText(usuario.getNome());

        final Button alterar =  (Button) findViewById(R.id.buttonVacinaAlterar);
        final Button remover = (Button) findViewById(R.id.buttonRemoverVacina);
        final Button adicionarVacina = (Button) findViewById(R.id.buttonAdicionarVacina);

        final ListView lista=  (ListView) findViewById(R.id.listViewVacinasTomadas);

        final ArrayList<VacinaTomada>  listaVacina  = d.getAllVacina(usuario.getId());

        final VacinaTomadaAdapter adapter = new VacinaTomadaAdapter(this, listaVacina);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                d.deleteVacinao( listaVacina.get(position));
                Toast.makeText(getBaseContext(), "Vacina Deletada.", Toast.LENGTH_LONG).show();
            }
        });

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
                Toast.makeText(getBaseContext(), "Usuario Deletado.", Toast.LENGTH_LONG).show();

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
