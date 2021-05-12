package com.example.lavueltaalmundo;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class PaginaLista extends AppCompatActivity implements AdapterView.OnItemLongClickListener {

    ListView lista;
    SharedPreferences sharedPreferences;
    Listado listado;

/*Se reciben los datos del arrayList guardados en la página anterior y se muestran en el adapter personalizado*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_lista);

        lista = findViewById(R.id.lista);

        sharedPreferences = getSharedPreferences("Nombres", MODE_PRIVATE);

        String json = sharedPreferences.getString("paises", "");


        if (!json.isEmpty()) {
            listado = new Listado();
            listado = listado.fromJson(json);

            MiAdapter adapter = new MiAdapter(this, R.layout.listacompleta, listado.paises);

            lista.setAdapter(adapter);
            lista.setOnItemLongClickListener(this);


        } else {
            listado = new Listado();
        }

    }
/*Metodo para borrar datos del listado mediante un longClick*/

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

        listado.paises.remove(position);
        ArrayAdapter arrayAdapter = (ArrayAdapter) lista.getAdapter();
        arrayAdapter.notifyDataSetChanged();
        sharedPreferences = getSharedPreferences("Nombres", MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("paises", listado.toJson());
        editor.apply();

        return true;

    }
/*Función del boton atrás para iniciar de nuevo a la página anterior y finalizar la lista*/

    public void atras(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}

/*He tomado la decision de iniciar de nuevo la pagina anterior para que los campos de esta esten en blanco
y el usuario no tenga que  borrar para introducir datos nuevos
 */
