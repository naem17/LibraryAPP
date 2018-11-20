package com.example.admin1.libraryapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class LibraryActivity extends AppCompatActivity {

    private static final String EXTRA_ARTICULO_ID="com.example.admin1.libraryapp.articulo_id";
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, ArrayList<Object>> expandableListDetail;
    private Button btnCarrito;

    public static ArrayList<Object> articulos = new ArrayList<Object>();


    public static Intent newIntent(Context packageContect, UUID articuloID){
        Intent intent = new Intent(packageContect, LibraryActivity.class);
        intent.putExtra(EXTRA_ARTICULO_ID, articuloID);
        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(articulos.isEmpty()) {
            loadProducts();
        }
        btnCarrito = (Button) findViewById(R.id.abrir_carrito);
        btnCarrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LibraryActivity.this, CarritoActivity.class);
                startActivity(intent);
            }
        });

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ListasCategorias.getData(articulos);
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new AdaptadorLista(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                /*Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();*/
            }


        });



        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                /*Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();*/

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {



                Log.d("CARRITO CLICK EVENT", String.valueOf(id)+" --- "+String.valueOf(groupPosition)+" --- "+String.valueOf(childPosition));
                UUID mId=((Articulos)expandableListAdapter.getChild(groupPosition,childPosition)).getMyId();
                Intent intent=ArticulosPagerActivity.newIntent(LibraryActivity.this,mId);
                startActivity(intent);
                return false;
            }

        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        expandableListDetail.clear();
        expandableListDetail = ListasCategorias.getData(articulos);
        expandableListAdapter = new AdaptadorLista(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                /*Toast.makeText(getApplicationContext(),
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();*/
            }


        });
    }

    private static void loadProducts(){

        articulos.add(new Libro(10.0, "Primer Libro", "12/11/18", "Nova", "Español","Terror", "James Garcia", true, "De pruebas"));
        articulos.add(new Libro(12.0, "Segundo Libro", "2/04/16", "Gears", "Ingles","Comedia", "Katherine Nothinghill", true, "De pruebas"));
        articulos.add(new Libro(24.0, "Tercer Libro", "22/12/17", "Planeta", "Español","Romance", "Orlando Perez", true, "De pruebas"));

        articulos.add(new Prensa(3.0, "Primer Periodico", "1/1/10", "ABC", "Español","Noticas", "Nacional", "Diario", true, "De pruebas"));
        articulos.add(new Prensa(2.5, "Segundo Periodico", "13/05/14", "El Pais", "Español","Noticias", "Nacional", "Diario",true, "De pruebas"));
        articulos.add(new Prensa(2.0, "Tercer Periodico", "12/10/15", "NAIZ", "Euskera","Noticias", "Regional", "Diario",true, "De pruebas"));


    }


}
