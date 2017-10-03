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
                intent.putExtra("endereco", addHospital().get(posicaoDaLinha).getEndereço());
                intent.putExtra("bairro", addHospital().get(posicaoDaLinha).getBairro());

                startActivity(intent);
            }
        });
    }

    private ArrayList<Hospital> addHospital(){
        ArrayList<Hospital> hospital = new ArrayList<Hospital>();
        Hospital a = new Hospital("Hospital Agamenon Magalhoes ","Estrada do Arraial, 2723","Casa Amarela","3184-1720");
        hospital.add(a);
        Hospital b = new Hospital("Hospital Da Policia Militar ","Praca Do Derby, s/n","Derby","3181-6400");
        hospital.add(b);
        Hospital c = new Hospital("Hospital Getulio vargas  ","AV. Gal San Martin ","Cordeiro","3181-5460");
        hospital.add(c);
        Hospital d = new Hospital("Hospital Das Clinicas ","AV Prof. Moraes Rego, 1235","Cidade Universitaria","2126-3633");
        hospital.add(d);
        Hospital e = new Hospital("US 126 Vereador Romildo Gomes ","Rua Jalisco, s/n","Ibiribeira","3355-3330");
        hospital.add(e);
        Hospital f= new Hospital("US 164 Cravo Gama ","Rua Londrina, s/n","Afogados","3355-2230");
        hospital.add(f);
        Hospital g = new Hospital("Us 240 coelhos I ","Rua Bituruna, 110","Coelhos","3355-4648");
        hospital.add(g);
        Hospital h = new Hospital("Us 270 Usf beira do rio ","Rua Ribeiro de Brito, 1361","Boa VIagem ","3355-6090");
        hospital.add(h);
        return hospital;
    }
}
