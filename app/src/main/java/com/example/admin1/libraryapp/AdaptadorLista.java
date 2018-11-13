package com.example.admin1.libraryapp;

import java.util.HashMap;
import java.util.List;

import android.nfc.Tag;
import android.util.Log;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

public class AdaptadorLista extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandableListTitle;
    private HashMap<String, List<String>> expandableListDetail;

    public AdaptadorLista(Context context, List<String> expandableListTitle,
                                       HashMap<String, List<String>> expandableListDetail) {
        this.context = context;
        this.expandableListTitle = expandableListTitle;
        this.expandableListDetail = expandableListDetail;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        String expandedListText = (String) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.articulo_fragment, null);
        }
        TextView expandedListTextView = (TextView) convertView.findViewById(R.id.nombre_articulo);
        expandedListTextView.setText(expandedListText);

        final ImageView carrito = (ImageView) convertView.findViewById(R.id.icono_carrito);
        carrito.setTag(android.R.drawable.ic_input_add);

        carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Integer integer = (Integer) carrito.getTag();
                integer = integer == null ? 0 : integer;

                switch(integer) {
                    case android.R.drawable.ic_delete:
                        carrito.setImageResource(android.R.drawable.ic_input_add);
                        carrito.setTag(android.R.drawable.ic_input_add);
                        break;
                    case android.R.drawable.ic_input_add:
                        carrito.setImageResource(android.R.drawable.ic_delete);
                        carrito.setTag(android.R.drawable.ic_delete);
                        break;
                }
            }
        });

        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListDetail.get(this.expandableListTitle.get(listPosition))
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListTitle.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListTitle.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.grupo_categoria, null);
        }
        TextView listTitleTextView = (TextView) convertView
                .findViewById(R.id.titulo_grupo);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }

}
