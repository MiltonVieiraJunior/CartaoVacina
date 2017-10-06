package com.neri.alexa.cartaovacina.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.neri.alexa.cartaovacina.Model.VacinaTomada;
import com.neri.alexa.cartaovacina.R;
import java.util.ArrayList;


/**
 * Created by alexa on 03/10/2017.
 */

 public class VacinaTomadaAdapter extends ArrayAdapter {
        private Context context = null;
        private final ArrayList<VacinaTomada> elementos;

        public VacinaTomadaAdapter(Context context, ArrayList<VacinaTomada> elementos) {
            super(context, R.layout.vacina, elementos);
            this.context = context;
            this.elementos = elementos;
        }

        public View getView(int position, View contvertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View rowView = inflater.inflate(R.layout.vacinatomada, parent, false);

            TextView nomeVacina = (TextView) rowView.findViewById(R.id.textViewVacinaTomada);

            nomeVacina.setText(elementos.get(position).getNome());

            return rowView;
        }
}


