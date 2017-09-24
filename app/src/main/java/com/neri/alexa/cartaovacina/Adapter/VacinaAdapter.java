package com.neri.alexa.cartaovacina.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.neri.alexa.cartaovacina.Modal.Vacina;
import com.neri.alexa.cartaovacina.R;

import java.util.ArrayList;

/**
 * Created by alexa on 23/09/2017.
 */

public class VacinaAdapter extends ArrayAdapter{
    private Context context = null;
    private final ArrayList<Vacina> elementos;

    public VacinaAdapter(Context context, ArrayList<Vacina> elementos) {
        super(context, R.layout.vacina, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    public View getView (int position, View contvertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.vacina, parent, false);

        TextView nomeVacina = (TextView) rowView.findViewById(R.id.nomeVacina);
        TextView idade =  (TextView) rowView.findViewById(R.id.idade);

        nomeVacina.setText(elementos.get(position).getNome());
        idade.setText(elementos.get(position).getIdade());

        return  rowView;
    }
}
