package com.example.admin1.libraryapp;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CarritoActivity extends AppCompatActivity{

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    List<String> expandableListTitle;
    HashMap<String, ArrayList<Object>> expandableListDetail;

    public static int total=0;
    public static double precio=0;
    public static TextView nArticulos;
    public static  TextView mPrecio;
    private Button mbtnComprar;


    public static void actualizarCompra()
    {

        for(Object obj : LibraryActivity.articulos){
            Articulos art = (Articulos) obj;
            if(art.isEnListaCompra()){
                total++;
                precio+=art.getPrecio();
            }
        }
        nArticulos.setText(String.valueOf(total));
        mPrecio.setText(String.valueOf(precio));
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrito);

        nArticulos = (TextView) findViewById(R.id.numero_articulos);
        mPrecio = (TextView) findViewById(R.id.carrito_precio_total);
        mbtnComprar = (Button) findViewById(R.id.carrito_comprar);

        actualizarCompra();

        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView2);
        expandableListDetail = ListasCategorias.getDataCarrito(LibraryActivity.articulos);
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
        expandableListAdapter = new AdaptadorLista(this, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        mbtnComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(CarritoActivity.this);
                builder.setTitle(R.string.comprar_dialog_title);
                builder.setMessage(R.string.comprar_dialog_message);
                builder.setCancelable(false);

                builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), R.string.compra_realizada, Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(), R.string.compra_no_realizada, Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
            }
        });



    }

}
