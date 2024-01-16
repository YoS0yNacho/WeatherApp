package com.nacho.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    TextView nameOfCity, tempActual, tempMax, tempMin, description;

    float latitud, longitud;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent myIntent = getIntent();
        latitud = myIntent.getFloatExtra("lat", 0.0f);
        longitud = myIntent.getFloatExtra("lon", 0.0f);

        nameOfCity = findViewById(R.id.tvCiudad);
        tempActual = findViewById((R.id.tvTempActual));
        tempMax = findViewById(R.id.maximaTV);
        tempMin = findViewById(R.id.minimaTV);
        description = findViewById(R.id.descripcionTV);

        getActualWeather();

/*
        String ciudadElegida = myIntent.getStringExtra("nombreCiudad");

        TextView nombreCiudad = findViewById(R.id.tvCiudad);
        nombreCiudad.setText(ciudadElegida);

 */
    }

    private void getActualWeather(){
        Call<Result>call = RetroFitClient.getInstance().getMyApi().getActualWeather(latitud, longitud, Api.Token, Api.UNITS, Api.LANG);
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if(response.isSuccessful()){
                    Result result = response.body();
                    nameOfCity.setText(result.name);
                    tempActual.setText(String.valueOf((result.main.temp.shortValue())));
                    tempMax.setText(String.valueOf(result.main.temp_max.shortValue()));
                    tempMin.setText(String.valueOf(result.main.temp_min.shortValue()));
                    Result.Weather weather = result.weather.get(0);
                    description.setText(weather.description);
                } else {
                    Toast.makeText(DetailActivity.this, "Hubo un error", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }



}