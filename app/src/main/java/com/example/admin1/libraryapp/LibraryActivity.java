package com.example.admin1.libraryapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, List<String>> expandableListDetail;

    ArrayList<Libro> libros = new ArrayList<Libro>();
    ArrayList<Prensa> periodicos = new ArrayList<Prensa>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadProducts();

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ListasCategorias.getData(libros,periodicos);
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new AdaptadorLista(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }


        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {



                Log.d("CARRITO CLICK EVENT", String.valueOf(id)+" --- "+String.valueOf(groupPosition)+" --- "+String.valueOf(childPosition));
                expandableListAdapter.getChild(groupPosition,childPosition);
                Toast.makeText(
                        getApplicationContext(),
                        expandableListTitle.get(groupPosition)
                                + " -> "
                                + expandableListDetail.get(
                                expandableListTitle.get(groupPosition)).get(
                                childPosition)+ "  "+id, Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });

    }

    private void loadProducts(){

        libros.add(new Libro(10.0, "Primer Libro", "12/11/18", "Pruebas", "Español","Terror", "Alguien", true, "De pruebas"));
        libros.add(new Libro(10.0, "Segundo Libro", "12/11/18", "Pruebas", "Español","Terror", "Alguien", true, "De pruebas"));
        libros.add(new Libro(10.0, "Tercer Libro", "12/11/18", "Pruebas", "Español","Terror", "Alguien", true, "De pruebas"));

        periodicos.add(new Prensa(10.0, "Primer Periodico", "12/11/18", "Pruebas", "Español","Terror", "Mucho", "Diario", true, "De pruebas"));
        periodicos.add(new Prensa(10.0, "Primer Periodico", "12/11/18", "Pruebas", "Español","Terror", "Mucho", "Diario",true, "De pruebas"));
        periodicos.add(new Prensa(10.0, "Primer Periodico", "12/11/18", "Pruebas", "Español","Terror", "Mucho", "Diario",true, "De pruebas"));
    }


}
