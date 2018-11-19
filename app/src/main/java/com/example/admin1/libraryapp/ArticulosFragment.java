package com.example.admin1.libraryapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;
import java.util.UUID;

public class ArticulosFragment extends Fragment {

    private TextView mTitle;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;
    private Articulos mArticulo;

    private static final String ARG_ARTICULO_ID="articulo_id";

    //funcion que devuelve un CrimeFragment, con el Bundle relleno con el
    //Id del crimen
    public static ArticulosFragment newInstance(UUID crimeId){
        Bundle argumentos = new Bundle();
        argumentos.putSerializable(ARG_ARTICULO_ID,crimeId);

        ArticulosFragment fragment = new ArticulosFragment();
        fragment.setArguments(argumentos);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mCrime = new Crime();

        //Recuperamos el intent de la actividad que contienen el fragment,
        //y del intent recuperamos el EXTRA, que en este caso es el
        // ID del crimen a mostrar
        //UUID crimeId = (UUID) getActivity().getIntent().getSerializableExtra(
        //        CrimeActivity.EXTRA_CRIME_ID);
        UUID articuloID = (UUID) getArguments().getSerializable(ARG_ARTICULO_ID);
        //mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
        mArticulo = (Articulos)LibraryActivity.articulos.get(0);
    }

    //el metodo para los fragments para visualizar el Layout,
    //asociar las variables locales a los widgets, y crear los evatos
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.articulo_fragment_grande, container, false);

        mTitle = (TextView) v.findViewById(R.id.articulo_title);
        mTitle.setText(mArticulo.getNombre());

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Miro si todo ha ido bien y el resultCode es Ok
        if(resultCode!= Activity.RESULT_OK){
            return;
        }

    }
}
