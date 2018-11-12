package com.example.admin1.libraryapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ListasCategorias {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> libro = new ArrayList<String>();
        libro.add("India");
        libro.add("Pakistan");
        libro.add("Australia");
        libro.add("England");
        libro.add("South Africa");

        List<String> periodico = new ArrayList<String>();
        periodico.add("Brazil");
        periodico.add("Spain");
        periodico.add("Germany");
        periodico.add("Netherlands");
        periodico.add("Italy");

        List<String> revista = new ArrayList<String>();
        revista.add("United States");
        revista.add("Spain");
        revista.add("Argentina");
        revista.add("France");
        revista.add("Russia");

        expandableListDetail.put("LIBROS", libro);
        expandableListDetail.put("PERIODICOS", periodico);
        expandableListDetail.put("REVISTAS", revista);
        return expandableListDetail;
    }
}
