package com.nacho.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private ListView listView;

    private ArrayList ciudades;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setUpListview();
    }

    void setUpListview() {
        listView = (ListView) findViewById(R.id.miListView);
        ciudades = new ArrayList<String>();
        ciudades.add("Salta");
        ciudades.add("Cordoba");
        ciudades.add("Mendoza");
        ciudades.add("Tierra del Fuego");
        ciudades.add("Formosa");


        CustomAdapter adapter = new CustomAdapter(this, ciudades);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                irDetalle((String) ciudades.get(position));
            }
        });
    }

    private void irDetalle(String ciudad){
        Intent myIntent = new Intent(this, DetailActivity.class);
        myIntent.putExtra("nombreCiudad", ciudad);
        startActivity(myIntent);
    }
}