package com.example.lavueltaalmundo;

import com.google.gson.Gson;
import java.util.ArrayList;

/*Array List de los datos introducidos*/

public class Listado extends Paises {


    public ArrayList<Paises> paises;

    public Listado() {
        paises = new ArrayList<>();
    }

    public String toJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public Listado fromJson(String json) {
        Gson gson = new Gson();
        Listado listado = gson.fromJson(json, Listado.class);
        return listado;
    }


}
