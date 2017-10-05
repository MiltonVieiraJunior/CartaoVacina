package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

        final TextView Tnome = (TextView) findViewById(R.id.desHospital);
        final TextView Tfone = (TextView) findViewById(R.id.textViewDescFone);
        final TextView Tbairro = (TextView) findViewById(R.id.textViewDesBairro);
        final TextView Tendereco = (TextView) findViewById(R.id.textViewDesendereco);

        Tnome.setText(nome);
        Tfone.setText(fone);
        Tbairro.setText(bairro);
        Tendereco.setText(endereco);

        Tfone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri uri = Uri.parse("tel:" + Tfone.getText().toString());
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);

                startActivity(intent);
            }
        });

    }
}
