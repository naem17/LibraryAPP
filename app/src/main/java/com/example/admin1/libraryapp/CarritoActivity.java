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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrito);

        nArticulos = (TextView) findViewById(R.id.numero_articulos);

        int total=0;

        for(Object obj : LibraryActivity.articulos){
            Articulos art = (Articulos) obj;
            if(art.isEnListaCompra()){
                total++;
            }
        }

        nArticulos.setText(String.valueOf(total));

    }

}
