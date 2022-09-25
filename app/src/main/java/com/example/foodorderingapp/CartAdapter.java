package com.example.foodorderingapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

    ArrayList<String> foodName = new ArrayList<>();
    ArrayList<Integer> foodPrice = new ArrayList<>();
    CartDBModel cartDBModel;
    String username;
    int foodQuantity;

    public CartAdapter(CommonFragments common)
    {
        cartDBModel = common.cartDBModel;
        username = common.getUsername();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.cart_row,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        foodName = cartDBModel.getFoodName(username);
        foodPrice = cartDBModel.getFoodPrice(username);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        foodQuantity = cartDBModel.getFoodQuantity(foodName.get(position), username);
        Log.d("CartAdapter", "FoodQuantity " + foodQuantity);
        holder.foodName.setText(foodName.get(position));
        holder.foodPrice.setText("RM " + String.valueOf(foodPrice.get(position)));
        holder.foodQuantity.setText(foodQuantity);

    }

    @Override
    public int getItemCount() {
        return cartDBModel.getFoodName(username).size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView foodPrice, foodName, foodQuantity;
        Button addButton, minusButton, deleteButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodname_cart);
            foodPrice = itemView.findViewById(R.id.foodPrice);
            foodQuantity = itemView.findViewById(R.id.foodQuantity);
            addButton = itemView.findViewById(R.id.addButton);
            minusButton = itemView.findViewById(R.id.minusButton);
            deleteButton = itemView.findViewById(R.id.deleteButton);
        }
    }
}
