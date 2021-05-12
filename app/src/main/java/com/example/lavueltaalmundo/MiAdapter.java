package com.example.lavueltaalmundo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public class MiAdapter extends ArrayAdapter {


    Context context;
    int listacompletaLayout;
    ArrayList<Paises> datos;

/*Adapter personalizado que coloca los datos recibidos del ArrayList en el layout*/

    public MiAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Paises> objects) {
        super(context, resource, objects);
        this.context = context;
        listacompletaLayout = resource;
        datos = objects;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null) {

            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView = layoutInflater.inflate(listacompletaLayout, parent, false);
        }

        TextView cabeceraLista = convertView.findViewById(R.id.cabeceraLista);
        cabeceraLista.setText(datos.get(position).pais);

        TextView textoLista = convertView.findViewById(R.id.textoLista);
        textoLista.setText(datos.get(position).texto);
        return convertView;
    }
}


