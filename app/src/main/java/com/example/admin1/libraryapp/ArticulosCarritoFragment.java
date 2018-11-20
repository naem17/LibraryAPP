package com.example.admin1.libraryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ArticulosCarritoFragment extends Fragment {

    /*private RecyclerView mArticulosView;
    private CarritoAdapter mCarritoAdapter;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.articulo_fragment, container, false);

        mArticulosView  = (RecyclerView) v.findViewById(R.id.lista_articulos_carrito);
        mArticulosView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return v;
    }

    private void updateUI(){

        if(mCarritoAdapter==null){
            mCarritoAdapter = new CarritoAdapter();
            mArticulosView.setAdapter(mCarritoAdapter);
        }
    }

    private class CarritoHolder extends RecyclerView.ViewHolder{

        private TextView mTitle;
        private Articulos mArticulo;
        public CarritoHolder(LayoutInflater inflater, ViewGroup parent, int ViewType) {
            super(inflater.inflate(ViewType, parent, false));

            mTitle = (TextView) itemView.findViewById(R.id.articulo_title);
        }

        public void bind(Articulos articulo){
            mArticulo = articulo;

            if(articulo.isEnListaCompra()){
                mTitle.setText(mArticulo.getNombre());
            }
        }


    }

    private class CarritoAdapter extends RecyclerView.Adapter<CarritoHolder>{

        public CarritoAdapter() {


        }

        @NonNull
        @Override
        public CarritoHolder onCreateViewHolder(@NonNull ViewGroup parent, int ViewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new CarritoHolder(layoutInflater, parent, ViewType);
        }

        @Override
        public void onBindViewHolder(@NonNull CarritoHolder carritoHolder, int i) {
            Articulos art = (Articulos) LibraryActivity.articulos.get(i);
            carritoHolder.bind(art);
        }

        @Override
        public int getItemCount() {
            return LibraryActivity.articulos.size();
        }

        @Override
        public int getItemViewType(int position) {
            if(((Articulos)LibraryActivity.articulos.get(position)).isEnListaCompra()){
                return R.layout.articulo_fragment;
            }
            return 0;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }*/
}
