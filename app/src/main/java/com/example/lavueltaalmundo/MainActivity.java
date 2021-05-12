package com.example.lavueltaalmundo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {


    EditText intPais;
    EditText intExperiencia;
    Button guardar;
    SharedPreferences sharedPreferences;
    Listado listado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        guardar = findViewById(R.id.guardar);
        intPais = findViewById(R.id.introPais);
        intExperiencia = findViewById(R.id.introExp);


        sharedPreferences = getSharedPreferences("Nombres", MODE_PRIVATE);

        String json = sharedPreferences.getString("paises", "");
        if (!json.isEmpty()) {
            listado = new Listado();
            listado = listado.fromJson(json);


        } else {
            listado = new Listado();
        }

    }

    /*Guarda los datos en el Array */

    public void guardarDatos(View view) {

        if (intPais.getText().toString().isEmpty()) {

            Toast.makeText(this, "No has introducido destino", Toast.LENGTH_SHORT).show();

        } else if (intExperiencia.getText().toString().isEmpty()) {

            Toast.makeText(this, "No has introducido experiencia", Toast.LENGTH_SHORT).show();

        } else {


            String pais = intPais.getText().toString();
            String texto = intExperiencia.getText().toString();

            Listado paises = new Listado();
            paises.pais = pais;
            paises.texto = texto;

            listado.paises.add(paises);

            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("paises", listado.toJson());
            editor.apply();

            /*al pulsar para guardar los datos salta un toast que confirma el registro, se pasa
            a la seguiente pantalla y esta se finaliza
             */
            Intent intent = new Intent(this, PaginaLista.class);
            startActivity(intent);

            Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show();

            finish();

        }


    }


}



