package com.example.admin1.libraryapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListasCategorias {
    public static HashMap<String, List<String>> getData(ArrayList<Libro> listaLibros, ArrayList<Prensa> listaPeriodicos) {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> libro = new ArrayList<String>();

        for (Libro art: listaLibros) {
            libro.add(art.getNombre());
        }

        List<String> periodico = new ArrayList<String>();
        for (Prensa art: listaPeriodicos) {
            periodico.add(art.getNombre());
        }

        List<String> revista = new ArrayList<String>();

        expandableListDetail.put("LIBROS", libro);
        expandableListDetail.put("PERIODICOS", periodico);
        //expandableListDetail.put("REVISTAS", revista);
        return expandableListDetail;
    }
}
