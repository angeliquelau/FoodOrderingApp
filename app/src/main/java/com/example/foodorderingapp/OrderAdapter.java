package com.example.foodorderingapp;

import android.util.Log;
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
    ResDBModel resDBModel;

    public OrderAdapter(CommonFragments common)
    {
        this.common = common;
        resDBModel = common.resDBModel;
        Log.d("OrderAdapter", "Common Class" + common);
        //username = data.getUsername();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.orderhistory_row,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        foodPrice = resDBModel.getResFoodPrice("KFC");
        username = common.getUsername();
        Log.d("OA", "username " + username);


        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       // holder.totalPrice.setText("RM" + String.valueOf(foodPrice.get(position)));
        holder.username.setText(username);
    }

    @Override
    public int getItemCount() {
        return 2;
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

