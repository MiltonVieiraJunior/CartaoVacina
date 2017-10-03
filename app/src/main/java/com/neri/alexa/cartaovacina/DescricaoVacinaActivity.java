package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DescricaoVacinaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descricao_vacina);

        Intent intent = getIntent();
        String nome = (String) intent.getSerializableExtra("nome");
        String idade = (String) intent.getSerializableExtra("idade");

        String dose = (String) intent.getSerializableExtra("dose");
        String quantidade = (String) intent.getSerializableExtra("quantidade");


        TextView Tnome = (TextView) findViewById(R.id.textViewNome);
        TextView Tidade = (TextView) findViewById(R.id.textViewIdade);

        TextView Tdose = (TextView) findViewById(R.id.textViewDose);
        TextView Tquantidade = (TextView) findViewById(R.id.TextViewQtd);


        Tnome.setText(nome);
        Tidade.setText(idade);

        Tdose.setText(dose);
        Tquantidade.setText(quantidade);

    }
}
