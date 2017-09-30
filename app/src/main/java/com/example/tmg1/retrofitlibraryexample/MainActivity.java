package com.example.tmg1.retrofitlibraryexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tmg1.retrofitlibraryexample.adapter.CountryAdapter;
import com.example.tmg1.retrofitlibraryexample.model.CountryPOJO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by MitaliBhokare on 9/30/2017.
 */

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;
    private List<CountryPOJO> list;
    private CountryToState countryToState;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Country Names");
        }


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_country);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/mitali-bhokare/CodeFights_Solutions/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        countryToState = retrofit.create(CountryToState.class);
        Call<List<CountryPOJO>> call = countryToState.getCountryNames();

        call.enqueue(new Callback<List<CountryPOJO>>() {
            @Override
            public void onResponse(Call<List<CountryPOJO>> call, Response<List<CountryPOJO>> response) {
                List<CountryPOJO> countries = response.body();

                countryAdapter = new CountryAdapter(mContext, countries);
                recyclerView.setAdapter(countryAdapter);
            }

            @Override
            public void onFailure(Call<List<CountryPOJO>> call, Throwable t) {

            }
        });

    }
}
