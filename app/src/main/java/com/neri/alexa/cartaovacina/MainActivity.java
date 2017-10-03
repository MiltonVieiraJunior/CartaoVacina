package com.neri.alexa.cartaovacina;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ImageView image = (ImageView) findViewById(R.id.imageView);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.buttonCadastroUsusario:
                intent = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonImc:
                intent = new Intent(MainActivity.this, ImcActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonVacina:
                intent = new Intent(MainActivity.this, ListaVacinaActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonLocais:
                intent = new Intent(MainActivity.this, HospitaListActivity.class);
                startActivity(intent);
                break;

            case R.id.buttonCartao:
                intent = new Intent(MainActivity.this, ListaUsuarioActivity.class);
                startActivity(intent);;
                break;
        }
    }
}
