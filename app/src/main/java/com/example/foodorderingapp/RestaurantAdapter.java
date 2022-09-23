package com.example.foodorderingapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.MyViewHolder> {

    CommonData cd = new CommonData();
    ArrayList<Integer> restaurantImages;
    ArrayList<String> restaurantName;
    ResDBModel resDBModel;
    CommonFragments common;

    public RestaurantAdapter(CommonFragments common)
    {
        this.common = common;
        resDBModel = common.resDBModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.restaurant_row,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view, common);
        restaurantImages = cd.getResImg();
        restaurantName = resDBModel.getResName();

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.resImage.setImageResource(restaurantImages.get(position));
        holder.resName.setText(restaurantName.get(position));

    }

    @Override
    public int getItemCount() {
        String size = Integer.toString(resDBModel.getResName().size());
        Log.d("Recycler", "Value = "  + size);
        return resDBModel.getResName().size();

    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView resImage;
        TextView resName;
        ConstraintLayout foodLayout;
        CommonFragments common;
        public MyViewHolder(@NonNull View itemView, CommonFragments common) {
            super(itemView);
            resImage = itemView.findViewById(R.id.resImage);
            resName = itemView.findViewById(R.id.resName);
            foodLayout = itemView.findViewById(R.id.cartLayout);
            itemView.setOnClickListener(this);
            this.common = common;
        }


        @Override
        public void onClick(View view) {
            //Toast.makeText(view.getContext(), restaurantName.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
            Bundle bundle = new Bundle();
            bundle.putParcelable("CommonFragments", common);
            bundle.putString("RestaurantName", restaurantName.get(getAdapterPosition()));
            AppCompatActivity activity = (AppCompatActivity) itemView.getContext();
            FoodRecycler fr = new FoodRecycler();
            activity.getSupportFragmentManager().beginTransaction().
                    replace(R.id.frameLayout, fr).commit();
            fr.setArguments(bundle);
        }
    }
}
