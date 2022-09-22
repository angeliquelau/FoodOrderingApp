package com.example.foodorderingapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    //that stores images
    CommonData cd = new CommonData();
    ArrayList<Integer> foodImages;
    ArrayList<String> foodName;
    ArrayList<String> foodDesc;
    ArrayList<Integer> foodPrice;
    ResDBModel resDBModel;
    String restaurantName;
    public FoodAdapter(CommonFragments common, String restaurantName)
    {
        resDBModel = common.resDBModel;
        this.restaurantName = restaurantName;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.food_row,parent,false);

        MyViewHolder myViewHolder = new MyViewHolder(view);

        if(restaurantName.equals("KFC"))
        {
            foodImages = cd.getKfcImg();
        }
        else if (restaurantName.equals("McDonald's"))
        {
            foodImages = cd.getMcdImg();
        }
        else if (restaurantName.equals("Pizza Hut"))
        {
            foodImages = cd.getPizzaHutImg();
        }
        else if (restaurantName.equals("Subway"))
        {
            foodImages = cd.getSubwayImg();
        }
        else if (restaurantName.equals("Nando's"))
        {
            foodImages = cd.getNandoImg();
        }
        else if (restaurantName.equals("Sushi King"))
        {
            foodImages = cd.getSushiKingImg();
        }
        else if (restaurantName.equals("SugarBun"))
        {
            foodImages = cd.getSugarbunImg();
        }
        else if (restaurantName.equals("Marrybrown"))
        {
            foodImages = cd.getMarrybrownImg();
        }
        else if (restaurantName.equals("Sushi Mentai"))
        {
            foodImages = cd.getSushiMentaiImg();
        }
        else
        {
            foodImages = cd.getDominoImg();
        }

        foodName = resDBModel.getResFood(restaurantName);
        foodDesc = resDBModel.getResFoodDesc(restaurantName);
        foodPrice = resDBModel.getResFoodPrice(restaurantName);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.foodImage.setImageResource(foodImages.get(position));
        holder.foodName.setText(foodName.get(position));
        holder.foodDesc.setText(foodDesc.get(position));
        holder.foodPrice.setText("RM " + String.valueOf(foodPrice.get(position)));
    }

    @Override
    public int getItemCount() {
        return resDBModel.getResFood(restaurantName).size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView foodPrice, foodDesc, foodName;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.foodName);
            foodImage = itemView.findViewById(R.id.foodImage);
            foodPrice = itemView.findViewById(R.id.foodPrice);
            foodDesc = itemView.findViewById(R.id.foodDesc);

        }
    }
}
