package com.example.admin1.libraryapp;

import android.app.Fragment;
import android.app.FragmentManager;
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
import android.widget.Toast;

import java.util.List;
import java.util.UUID;

public class ArticulosPagerActivity extends AppCompatActivity{

    private static final String EXTRA_ARTICULO_ID="com.example.admin1.libraryapp.articulo_id";
    private ViewPager mViewPager;

    public static Intent newIntent(Context packageContect, UUID articuloID){
        Intent intent = new Intent(packageContect, ArticulosPagerActivity.class);
        intent.putExtra(EXTRA_ARTICULO_ID, articuloID);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_pager);

        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_ARTICULO_ID);

        mViewPager = (ViewPager) findViewById(R.id.articulo_view_pager);

        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int i) {
                LibraryActivity.articulos.get(i);
                //return CrimeFragment.newInstance(crime.getMyId());
                return null;
            }

            @Override
            public int getCount() {
                return LibraryActivity.articulos.size();
            }
        });

        //Para posicionar el ViewPager en la posicion del ID que nos han
        //pasado como parametro en el EXTRA del Intent al llamar a la actividad
        /*for(int i=0; i< LibraryActivity.articulos.size(); i++){
            if(LibraryActivity.articulos.get(i).getMyId().equals(crimeId)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }*/
    }
}
