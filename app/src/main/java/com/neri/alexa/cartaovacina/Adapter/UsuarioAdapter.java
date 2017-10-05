package com.neri.alexa.cartaovacina.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.neri.alexa.cartaovacina.Model.Hospital;
import com.neri.alexa.cartaovacina.Model.Usuario;
import com.neri.alexa.cartaovacina.R;

import java.util.ArrayList;

/**
 * Created by alexa on 02/10/2017.
 */

public class UsuarioAdapter extends ArrayAdapter<Usuario> {

    private Context context = null;
    private final ArrayList<Usuario> elementos;

    public UsuarioAdapter(Context context, ArrayList<Usuario> elementos) {
        super(context, R.layout.usuario, elementos);
        this.context = context;
        this.elementos = elementos;
    }

    public View getView (int position, View contvertView, ViewGroup parent){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.usuario, parent, false);

        TextView nomeUsuario = (TextView) rowView.findViewById(R.id.textViewNomeUsario);


        nomeUsuario.setText(elementos.get(position).getNome());
        return  rowView;
    }

}
