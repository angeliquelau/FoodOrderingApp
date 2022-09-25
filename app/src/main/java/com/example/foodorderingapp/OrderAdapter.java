package com.example.foodorderingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder>
{
    ArrayList<Integer> foodPrice;
    ArrayList<String> foodList;
    String username;
    CommonFragments common;
    FoodHistoryDBModel foodHistoryDBModel;

    public OrderAdapter(CommonFragments common)
    {
        this.common = common;
        foodHistoryDBModel = common.getFoodHistoryDBModel();
        username = common.getUsername();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.orderhistory_row,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        username = common.getUsername();
        foodList = foodHistoryDBModel.getFoodList(username);
        foodPrice = foodHistoryDBModel.getFoodPrice(username);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.username.setText(username);
        holder.foodList.setText(foodList.get(holder.getAdapterPosition()));
        holder.totalPrice.setText("RM" + String.valueOf(foodPrice.get(position)));

    }

    @Override
    public int getItemCount() {
        return foodHistoryDBModel.getFoodList(username).size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView username, foodList, totalPrice;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.foodname_cart);
            foodList = itemView.findViewById(R.id.food_order);
            totalPrice = itemView.findViewById(R.id.foodPrice);
        }
    }
}

