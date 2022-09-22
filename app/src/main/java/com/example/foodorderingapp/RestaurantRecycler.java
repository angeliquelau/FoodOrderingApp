package com.example.foodorderingapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RestaurantRecycler extends Fragment {


    public RestaurantRecycler() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        CommonFragments data = bundle.getParcelable("frag");
        View v = inflater.inflate(R.layout.fragment_restaurant_recycler, container, false);
        RecyclerView rv = v.findViewById(R.id.restaurantRecycler);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        RestaurantAdapter ra = new RestaurantAdapter(data);
        rv.setAdapter(ra);
        DividerItemDecoration div = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(div);

        return v;
    }

}