package com.example.foodorderingapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    CommonData cd = new CommonData();
    ArrayList<Integer> foodImages;
    ArrayList<String> foodName;
    ArrayList<String> foodDesc;
    ArrayList<String> foodPrice;
    ResDBModel resDBModel;

    public FoodAdapter(CommonFragments common)
    {
        resDBModel = common.resDBModel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //inflate the xml that u wanna show on fragment
        View view = layoutInflater.inflate(R.layout.food_row,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        foodImages = cd.getKfcImg();

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
        TextView foodPrice, foodDesc, foodName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.foodImage);
            foodPrice = itemView.findViewById(R.id.foodPrice);
            foodDesc = itemView.findViewById(R.id.foodDesc);

        }
    }
}
