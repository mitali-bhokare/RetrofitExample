package com.example.tmg1.retrofitlibraryexample;

import com.example.tmg1.retrofitlibraryexample.model.CountryPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by MitaliBhokare on 9/30/2017.
 */

public interface CountryToState {

    @GET("master/CountriesToCities.json")
    Call<List<CountryPOJO>> getCountryNames();


}
