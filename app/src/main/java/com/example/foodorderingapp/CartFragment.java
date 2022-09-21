package com.example.foodorderingapp;

/*incomplete*/

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class CartFragment extends Fragment {
    private Cart cart;

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }

    private class CartViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView foodImage;
        private TextView foodName;
        private TextView foodPrice;
        private TextView foodQuantity;
        private Cart cart;

        public CartViewHolder(LayoutInflater li, ViewGroup view) {
            super(li.inflate(R.layout.fragment_cart, view, false));
            foodImage = itemView.findViewById(R.id.iv_foodImage);

        }

        public void bind(Cart cart)
        {
            this.cart = cart;

        }
    }

    //private class CartAdapter extends RecyclerView.Adapter<CartViewHolder>()
}