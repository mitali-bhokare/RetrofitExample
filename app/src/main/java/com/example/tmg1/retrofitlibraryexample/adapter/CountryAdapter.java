package com.example.tmg1.retrofitlibraryexample.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tmg1.retrofitlibraryexample.MainActivity;
import com.example.tmg1.retrofitlibraryexample.R;
import com.example.tmg1.retrofitlibraryexample.StatesActivity;
import com.example.tmg1.retrofitlibraryexample.model.CountryPOJO;

import java.util.List;

/**
 * Created by MitaliBhokare on 9/30/2017.
 */

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {

    private Context context;
    private List<CountryPOJO> list;

    public CountryAdapter(Context context, List<CountryPOJO> list) {
        this.list = list;
        this.context = context;
    }


    @Override
    public CountryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_recycler_item, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CountryViewHolder holder, final int position) {
        String value = null;
        if (context instanceof MainActivity) {
            value = list.get(position).getCountry();
            holder.countryName.setText(value);

            holder.countryName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, StatesActivity.class);
                    i.putExtra("country",list.get(position).getCountry());
                    i.putExtra("states", list.get(position).getStates());
                    v.getContext().startActivity(i);
                }
            });

        } else {
            value = list.get(position).getStates();
            holder.countryName.setText(value);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {

        public TextView countryName;

        public CountryViewHolder(View itemView) {
            super(itemView);

            countryName = (TextView) itemView.findViewById(R.id.textView_countryName);
        }
    }
}
