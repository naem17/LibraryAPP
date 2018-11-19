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
import android.widget.TextView;
import android.widget.Toast;

public class CarritoActivity extends AppCompatActivity{

    private TextView nArticulos;
    private TextView mPrecio;
    private Button mbtnComprar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrito);

        nArticulos = (TextView) findViewById(R.id.numero_articulos);
        mPrecio = (TextView) findViewById(R.id.carrito_precio_total);
        mbtnComprar = (Button) findViewById(R.id.carrito_comprar);

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
