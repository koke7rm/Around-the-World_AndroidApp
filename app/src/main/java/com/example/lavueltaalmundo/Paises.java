package com.example.lavueltaalmundo;

import com.google.gson.Gson;


public class Paises{
    String pais;
    String texto;


    public String toJson() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public Paises fromJson(String json) {
        Gson gson = new Gson();
        Paises pais = gson.fromJson(json, Paises.class);
        return pais;
    }

}