package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neri.alexa.cartaovacina.Adapter.HospitalAdapter;
import com.neri.alexa.cartaovacina.Modal.Hospital;

import java.util.ArrayList;

public class HospitaListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospita_list);

        ListView lista = (ListView) findViewById(R.id.listaHospital);
        ArrayAdapter adapter = new HospitalAdapter(this, addHospital());
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int posicaoDaLinha, long id) {


                Intent intent= new Intent(HospitaListActivity.this, DescricaoHospitalActivity.class);
                intent.putExtra("nome", addHospital().get(posicaoDaLinha).getNome());
                intent.putExtra("fone", addHospital().get(posicaoDaLinha).getFone());
                intent.putExtra("endereço", addHospital().get(posicaoDaLinha).getEndereço());
                intent.putExtra("bairro", addHospital().get(posicaoDaLinha).getBairro());


                startActivity(intent);

            }
        });
    }

    private ArrayList<Hospital> addHospital(){
        ArrayList<Hospital> hospital = new ArrayList<Hospital>();

        Hospital h = new Hospital("barra de sirinhaem","vaicimeses","aline","fojsdo");
        hospital.add(h);

        return hospital;

    }




}
