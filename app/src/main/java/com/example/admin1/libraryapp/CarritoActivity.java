package com.example.admin1.libraryapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

public class CarritoActivity extends AppCompatActivity{

    private TextView nArticulos;
    private TextView mPrecio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrito);

        nArticulos = (TextView) findViewById(R.id.numero_articulos);
        mPrecio = (TextView) findViewById(R.id.carrito_precio_total);

        int total=0;
        double precio=0;
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

}
