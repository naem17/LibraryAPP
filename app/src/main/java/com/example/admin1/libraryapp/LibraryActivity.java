package com.example.admin1.libraryapp;

import android.support.v4.app.Fragment;
import android.os.Bundle;

public class LibraryActivity extends SingleFragmentActivity {

    //TODO: Arreglar LibraryActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library_pager);
        System.out.println("Hola");
    }

    @Override
    protected Fragment createFragment() {
        return null;
    }
}
