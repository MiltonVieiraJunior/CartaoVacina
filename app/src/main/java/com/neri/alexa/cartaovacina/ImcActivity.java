package com.neri.alexa.cartaovacina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ImcActivity extends AppCompatActivity {

    private Button btnResultado ;
    private EditText editPeso;
    private EditText editAltura;
    private TextView editResultado;
    private TextView resul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        btnResultado =  (Button) findViewById(R.id.buttonResultado);
        editPeso =  (EditText) findViewById(R.id.editTextPeso);
        editAltura =  (EditText)findViewById(R.id.editTextAltura);
        editResultado =  (TextView) findViewById(R.id.editTextResultado) ;
        resul =  (TextView) findViewById(R.id.textView7);

        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double peso = Double.parseDouble(editPeso.getText().toString());
                double altura  = Double.parseDouble(editAltura.getText().toString());

                double resultado =  peso / (altura*altura);
                editResultado.setText(String.valueOf(resultado));

                if (resultado<18.5){
                    resul.setText("Abaixo do Peso");
                }else{
                    if (resultado>=18.5 && resultado<25){
                        resul.setText("Peso Normal");
                    }else{
                        if(resultado>=25 && resultado<30) {
                            resul.setText("Acima do Peso");
                        }else{
                            if (resultado>=30){
                                resul.setText("Obeso");
                            }
                        }
                    }
                }
            }
        });
    }
}
