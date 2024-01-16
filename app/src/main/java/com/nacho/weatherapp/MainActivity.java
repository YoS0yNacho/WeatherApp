package com.nacho.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void listarCiudades(View view){
        Intent miIntent = new Intent(this, ListActivity.class);
        startActivity(miIntent);
    }

    public void irDetalle(View view){
        Intent myIntent = new Intent(this, DetailActivity.class);
        //myIntent.putExtra("nombreCiudad", "Tucumán");

        myIntent.putExtra("lat", "-24.8056");
        myIntent.putExtra("lon", "-65.3417");
        startActivity(myIntent);

    }
}