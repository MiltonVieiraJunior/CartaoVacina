package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DescricaoHospitalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_hospital);

        Intent intent =getIntent();
        String nome  = (String) intent.getSerializableExtra("nome");
        String fone  = (String) intent.getSerializableExtra("fone");
        String bairro  = (String) intent.getSerializableExtra("bairro");
        String endereco  = (String) intent.getSerializableExtra("endereco");

        TextView Tnome =  (TextView) findViewById(R.id.desHospital);
        TextView Tfone =  (TextView) findViewById(R.id.textViewDescFone);
        TextView Tbairro =  (TextView) findViewById(R.id.textViewDesBairro);
        TextView Tendereco = (TextView) findViewById(R.id.textViewDesendereco);

        Tnome.setText(nome);
        Tfone.setText(fone);
        Tbairro.setText(bairro);
        Tbairro.setText(endereco);

    }
}
