package com.example.admin1.libraryapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListasCategorias {

    public static HashMap<String, List<String>> getData(ArrayList<Object> articulos) {

        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        HashMap<String, ArrayList<String>> categorias = new HashMap<String, ArrayList<String>>();

        for (Object art:  articulos) {
            Articulos articulo = (Articulos) art;
            String tipo=art.getClass().getSimpleName();
            if(!categorias.containsKey(tipo)){
                categorias.put(tipo, new ArrayList<String>());
            }
            categorias.get(tipo).add(articulo.getNombre());
        }

        for(String lista: categorias.keySet()){
            expandableListDetail.put(lista.toUpperCase(), categorias.get(lista));
        }

        return expandableListDetail;
    }
}
