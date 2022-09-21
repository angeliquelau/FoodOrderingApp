package com.example.foodorderingapp;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.MyViewHolder> {

    CommonData cd;
    ArrayList<Integer> restaurantImages;
    ArrayList<String> restaurantName;
    public RestaurantAdapter(CommonData cd)
    {
        this.cd = cd;
        restaurantImages = cd.resImg;
        restaurantName = cd.kfcName;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //inflate the xml that u wanna show on fragment
        View view = layoutInflater.inflate(R.layout.restaurant_row,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.resImage.setImageResource(restaurantImages.get(position));
        holder.resName.setText(restaurantName.get(position));


    }

    @Override
    public int getItemCount() {
        return restaurantImages.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView resImage;
        TextView resName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            resImage = itemView.findViewById(R.id.resImage);
            resName = itemView.findViewById(R.id.resName);
        }
    }
}
