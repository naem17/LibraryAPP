package com.example.admin1.libraryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LibraryActivity extends SingleFra {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        System.out.println("Hola");
    }
}
