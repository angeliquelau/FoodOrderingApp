package com.example.foodorderingapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class OrderFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_order, container, false);

        Bundle bundle = this.getArguments();
        CommonFragments data = bundle.getParcelable("frag");
        RecyclerView rv = v.findViewById(R.id.orderRecycler);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        OrderAdapter orderAdapter = new OrderAdapter(data);
        Log.d("OrderAdapter", "Class" + orderAdapter);
        rv.setAdapter(orderAdapter);

        return v;
    }
}