package com.example.foodorderingapp;

/*incomplete*/

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class CartRecycler extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        CommonFragments data = bundle.getParcelable("frag");
        View v = inflater.inflate(R.layout.fragment_cart_recycler, container, false);
        RecyclerView rv = v.findViewById(R.id.cartRecycler);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        CartAdapter ca = new CartAdapter(data);
        rv.setAdapter(ca);
        DividerItemDecoration div = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(div);

        return v;
    }


}