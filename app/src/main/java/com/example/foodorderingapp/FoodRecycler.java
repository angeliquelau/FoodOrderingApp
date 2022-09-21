package com.example.foodorderingapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FoodRecycler extends Fragment {


    public FoodRecycler() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_food_recycler, container, false);
        Bundle bundle = this.getArguments();
        CommonFragments data = bundle.getParcelable("frag");
        RecyclerView rv = v.findViewById(R.id.foodRecycler);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        FoodAdapter foodAdapter = new FoodAdapter(data);
        rv.setAdapter(foodAdapter);
        return v;
    }
}