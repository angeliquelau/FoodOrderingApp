package com.example.foodorderingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    ArrayList<String> foodName;
    ArrayList<Integer> foodPrice;
    CommonFragments common;
    CartDBModel cartDBModel;

    public CartAdapter(CommonFragments common)
    {
        this.common = common;
        this.cartDBModel = common.cartDBModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cart_row,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView foodPrice, foodName, foodQuantity;
        Button addButton, minusButton, deleteButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.username_order);
            foodImage = itemView.findViewById(R.id.foodImage);
            foodPrice = itemView.findViewById(R.id.foodPrice);
            foodQuantity = itemView.findViewById(R.id.foodQuantity);
            addButton = itemView.findViewById(R.id.addButton);
            minusButton = itemView.findViewById(R.id.minusButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}
