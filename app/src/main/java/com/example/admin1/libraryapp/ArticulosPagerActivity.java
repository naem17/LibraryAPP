package com.example.admin1.libraryapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

public class ArticulosPagerActivity extends AppCompatActivity{

    private static final String EXTRA_ARTICULO_ID="com.example.admin1.libraryapp.articulo_id";
    private ViewPager mViewPager;
    private Button buttonFirst;
    private Button buttonLast;
    private Button buttonMenu;

    public static Intent newIntent(Context packageContect, UUID articuloID){
        Intent intent = new Intent(packageContect, ArticulosPagerActivity.class);
        intent.putExtra(EXTRA_ARTICULO_ID, articuloID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_pager);

        final UUID articulosId = (UUID) getIntent().getSerializableExtra(EXTRA_ARTICULO_ID);

        mViewPager = (ViewPager) findViewById(R.id.articulo_view_pager);
        buttonFirst=(Button) findViewById(R.id.first_button);
        buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(0);
            }
        });
        buttonLast=(Button)findViewById(R.id.last_button);
        buttonLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(LibraryActivity.articulos.size()-1);
            }
        });
        buttonMenu=(Button)findViewById(R.id.menu_button);
        buttonMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = LibraryActivity.newIntent(ArticulosPagerActivity.this,articulosId);
                startActivity(intent);
                finish();
            }
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int i) {
                return ArticulosFragment.newInstance(((Articulos)LibraryActivity.articulos.get(i)).getMyId());
            }

            @Override
            public int getCount() {
                return LibraryActivity.articulos.size();
            }
        });

        //Para posicionar el ViewPager en la posicion del ID que nos han
        //pasado como parametro en el EXTRA del Intent al llamar a la actividad
        for(int i=0; i< LibraryActivity.articulos.size(); i++){
            if(((Articulos)LibraryActivity.articulos.get(i)).getMyId().equals(articulosId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }

}
