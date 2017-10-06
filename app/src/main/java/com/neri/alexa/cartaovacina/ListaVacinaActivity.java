package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neri.alexa.cartaovacina.Adapter.VacinaAdapter;
import com.neri.alexa.cartaovacina.Model.Vacina;

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

        Vacina a = new Vacina("Bcg","Ao Nascer","Dose Unica", "0.1 ml");
        vacina.add(a);
        Vacina b= new Vacina("Hepatite B","Ao Nascer","1° Dose", "0.5 ml");
        vacina.add(b);
        Vacina c = new Vacina("Vacina Pentavalente","2 Meses","1° Dose", "0.5 ml");
        vacina.add(c);
        Vacina d = new Vacina("Vacina Inativa Contra Poliomelite","2 Meses","1° Dose", "0.5 ml");
        vacina.add(d);
        Vacina e = new Vacina("Vacina Oral RotaVirus Humano","2 Meses","1° Dose", "1.5 ml");
        vacina.add(e);
        Vacina f = new Vacina("Pneumococica 10","2 Meses","1° Dose", "0.5 ml");
        vacina.add(f);
        Vacina g = new Vacina("Meningococica C","3 Meses","1° Dose", "0.5 ml");
        vacina.add(g);
        Vacina h = new Vacina("Hepatite A","12 Meses"," Dose", "0.5 ml");
        vacina.add(h);
        Vacina i = new Vacina("Triplice Bacteriana ","4 anos"," 2° reforço ", "0.5 ml");
        vacina.add(i);
        Vacina j = new Vacina("Hpv","9 a 11 anos"," ", "0.5 ml");
        vacina.add(j);
        Vacina r = new Vacina("Hepatite B","10 a 19 Anos"," 1° Dose", "");
        vacina.add(r);
        Vacina s = new Vacina("influenza sazonal","60 anos e mais"," Dose unica", "");
        vacina.add(s);

        return vacina;

    }
}
