package com.example.tmg1.retrofitlibraryexample.model;

/**
 * Created by MitaliBhokare on 9/30/2017.
 */
public class CountryPOJO {

    private String Country;

    private String States;

    public CountryPOJO(String states) {
        States = states;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getStates() {
        return States;
    }

    public void setStates(String states) {
        States = states;
    }
}
