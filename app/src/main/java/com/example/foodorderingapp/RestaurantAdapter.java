package com.example.foodorderingapp;

import android.content.Context;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.MyViewHolder> {

    CommonData cd = new CommonData();
    ArrayList<Integer> restaurantImages;
    ArrayList<String> restaurantName;
    ResDBModel resDBModel;


    public RestaurantAdapter(CommonFragments common)
    {
        resDBModel = common.resDBModel;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //inflate the xml that u wanna show on fragment
        View view = layoutInflater.inflate(R.layout.restaurant_row,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        restaurantImages = cd.getResImg();
        restaurantName = resDBModel.getResName();

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.resImage.setImageResource(restaurantImages.get(position));
        holder.resName.setText(restaurantName.get(position));
/*
        holder.foodLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                FoodRecycler foodRecycler = new FoodRecycler();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, foodRecycler);

            }
        });
*/

    }

    @Override
    public int getItemCount() {
        String size = Integer.toString(resDBModel.getResName().size());
        Log.d("Recycler", "Value = "  + size);
        return resDBModel.getResName().size();

    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView resImage;
        TextView resName;
        ConstraintLayout foodLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            resImage = itemView.findViewById(R.id.resImage);
            resName = itemView.findViewById(R.id.resName);
            foodLayout = itemView.findViewById(R.id.foodLayout);
        }
    }
}
