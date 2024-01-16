package com.nacho.weatherapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    String Base_URL = "https://api.openweathermap.org/data/2.5/";
    String Token = "dec1006f9545d88c3ab45707fd0785fe";

    String UNITS = "metric";

    String LANG = "es";

    @GET("weather")
    Call<Result> getActualWeather(@Query("lat") Float latitud, @Query("lan") Float longitud, @Query("appid") String token, @Query("units") String units, @Query("lang") String lang );
}
