package com.example.tmg1.retrofitlibraryexample;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tmg1.retrofitlibraryexample.adapter.CountryAdapter;
import com.example.tmg1.retrofitlibraryexample.model.CountryPOJO;

import java.util.ArrayList;
import java.util.List;

public class StatesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CountryAdapter countryAdapter;
    private List<CountryPOJO> list = new ArrayList<CountryPOJO>();
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_states);

        Bundle bundle = getIntent().getExtras();
        String countryName = bundle.getString("country");
        String states = bundle.getString("states");

        //Show the back arrow on the toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle("States of "+countryName);
        }

        mContext = this;

        CountryPOJO p ;
        String[] words = states.split(",");
        for (int i = 0; i < words.length; i++) {
            p = new CountryPOJO(words[i]);
            list.add(i, p);

        }


        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_states);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        countryAdapter = new CountryAdapter(mContext, list);
        recyclerView.setAdapter(countryAdapter);


    }

    //When the arrow on the toolbar is clicked
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
