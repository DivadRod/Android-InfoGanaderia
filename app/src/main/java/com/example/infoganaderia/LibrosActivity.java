package com.example.infoganaderia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class LibrosActivity extends AppCompatActivity {

    private ListView listView;

    private ArrayList <String> libros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);

        listView = findViewById(R.id.listViewBooks);

        libros = new ArrayList<>();

        libros.add("Libros 1");
        libros.add("Libros 2");
        libros.add("Libros 3");
        libros.add("Libros 4");
        libros.add("Libros 5");

        ArrayAdapter <String> adapater = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, libros);

        listView.setAdapter(adapater);
    }
}