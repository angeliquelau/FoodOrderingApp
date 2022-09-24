package com.example.foodorderingapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    //that stores images
    int quantity [];

    CommonData cd = new CommonData();
    ArrayList<Integer> foodImages;
    ArrayList<String> foodName;
    ArrayList<String> foodDesc;
    ArrayList<Integer> foodPrice;
    ResDBModel resDBModel;
    CartDBModel cartDBModel;
    String restaurantName;
    String username;

    public FoodAdapter(CommonFragments common, String restaurantName)
    {
        resDBModel = common.resDBModel;
        cartDBModel = common.cartDBModel;
        username = common.getUsername();
        this.restaurantName = restaurantName;
        quantity = new int [resDBModel.getResName().size()];

        for(int i = 0; i < resDBModel.getResName().size(); i++)
        {
            quantity[i] = 0;
        }
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

        holder.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = 0;
                value = quantity[(holder.getAdapterPosition())];
                value++;
                quantity[(holder.getAdapterPosition())] =  value;
                holder.foodQuantity.setText(String.valueOf(value));

                //food doesn't exist
                if(!cartDBModel.foodExist(foodName.get(holder.getAdapterPosition()))) {

                    Cart cart = new Cart(username, foodName.get(holder.getAdapterPosition()),
                            foodPrice.get(holder.getAdapterPosition()), value);
                    cartDBModel.addToCart(cart);
                    Log.d("AddFood",  "Value = " + value);
                }
                else
                {
                    cartDBModel.updateFoodQuantity(foodName.get(holder.getAdapterPosition()), value);
                    Log.d("AddFood",  "Value = " + value);
                }
                //quantity array






            }
        });

        holder.minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = 0;

                //quantity array
                value = quantity[(holder.getAdapterPosition())];

                if(value > 0) {

                    cartDBModel.updateFoodQuantity(foodName.get(holder.getAdapterPosition()), value);

                    value--;
                    quantity[(holder.getAdapterPosition())] = value;
                    holder.foodQuantity.setText(String.valueOf(value));
                    cartDBModel.updateFoodQuantity(foodName.get(holder.getAdapterPosition()), value);
                    Log.d("AddFood",  "Value = " + value);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return resDBModel.getResFood(restaurantName).size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImage;
        TextView foodPrice, foodDesc, foodName, foodQuantity;
        Button addButton, minusButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            foodName = itemView.findViewById(R.id.username_order);
            foodImage = itemView.findViewById(R.id.foodImage);
            foodPrice = itemView.findViewById(R.id.foodPrice);
            foodQuantity = itemView.findViewById(R.id.foodQuantity);
            foodDesc = itemView.findViewById(R.id.food_order);
            addButton = itemView.findViewById(R.id.addButton);
            minusButton = itemView.findViewById(R.id.minusButton);

        }
    }
}
