package com.example.admin1.libraryapp;

import java.util.ArrayList;
import java.util.HashMap;

public class ListasCategorias {


    public static HashMap<String, ArrayList<Object>> getData(ArrayList<Object> articulos) {

        HashMap<String, ArrayList<Object>> categorias = new HashMap<String, ArrayList<Object>>();

        for (Object art:  articulos) {
            Articulos articulo = (Articulos) art;
            String tipo=art.getClass().getSimpleName();
            if(!categorias.containsKey(tipo)){
                categorias.put(tipo, new ArrayList<Object>());
            }
            categorias.get(tipo).add(articulo);
        }

        return categorias;
    }
    public static HashMap<String, ArrayList<Object>> getDataCarrito(ArrayList<Object> articulos) {

        HashMap<String, ArrayList<Object>> categorias = new HashMap<String, ArrayList<Object>>();

        for (Object art:  articulos) {
            if(((Articulos)art).isEnListaCompra())
            {
                Articulos articulo = (Articulos) art;
                String tipo=art.getClass().getSimpleName();
                if(!categorias.containsKey(tipo)){
                    categorias.put(tipo, new ArrayList<Object>());
                }
                categorias.get(tipo).add(articulo);
            }
        }

        return categorias;
    }
}
