package com.neri.alexa.cartaovacina.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.neri.alexa.cartaovacina.Model.Hospital;
import com.neri.alexa.cartaovacina.R;

import java.util.ArrayList;
/**
 * Created by alexa on 23/09/2017.
 */
public class HospitalAdapter extends ArrayAdapter {

    private Context context = null;
    private final ArrayList<Hospital> elementos;

    public HospitalAdapter(Context context, ArrayList<Hospital> elementos) {
        super(context, R.layout.hospital, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    public View getView (int position, View contvertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.hospital, parent, false);

        TextView nomeHospital = (TextView) rowView.findViewById(R.id.nomeHospital);
        TextView fone =  (TextView) rowView.findViewById(R.id.editTextFone);

        nomeHospital.setText(elementos.get(position).getNome());
        fone.setText(elementos.get(position).getFone());
        return  rowView;
    }
}
