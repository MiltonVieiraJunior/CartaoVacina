package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neri.alexa.cartaovacina.Adapter.VacinaAdapter;
import com.neri.alexa.cartaovacina.Modal.Vacina;

import java.util.ArrayList;

public class ListaVacinaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_vacina);

        ListView lista = (ListView) findViewById(R.id.lista);
        ArrayAdapter adapter = new VacinaAdapter(this, addvacinas());
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int posicaoDaLinha, long id) {


                    Intent intent= new Intent(ListaVacinaActivity.this, DescricaoVacinaActivity.class);
                    intent.putExtra("nome", addvacinas().get(posicaoDaLinha).getNome());
                    intent.putExtra("idade", addvacinas().get(posicaoDaLinha).getIdade());
                    intent.putExtra("doenca", addvacinas().get(posicaoDaLinha).getDoenca_protecao());
                intent.putExtra("dose", addvacinas().get(posicaoDaLinha).getDose());
                intent.putExtra("quantidade", addvacinas().get(posicaoDaLinha).getQtd());
                intent.putExtra("via", addvacinas().get(posicaoDaLinha).getVia_adm());

                    startActivity(intent);

            }
        });
    }

    private ArrayList<Vacina> addvacinas(){
        ArrayList<Vacina> vacina = new ArrayList<Vacina>();

        Vacina v = new Vacina("alex","3 meses","aline","fojsdo", "ofojdof","fidjfosj");
        vacina.add(v);

        return vacina;

    }
}
