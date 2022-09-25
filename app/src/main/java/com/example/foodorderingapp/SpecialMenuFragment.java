package com.example.foodorderingapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;


public class SpecialMenuFragment extends Fragment {

    private TextView resName, resFood;
    private ImageView resImage;
    private CommonData cd = new CommonData();

    public SpecialMenuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_special_menu, container, false);

        ResDBModel resDBModel = new ResDBModel();

        resDBModel.load(this.getContext());
        ArrayList<String> resNameList = resDBModel.getResName();
        //find the random number for restaurant and food item
        int res_FoodMin = 0, resMax = (resNameList.size() - 1);
        int resRandNum = (int)(Math.random() * (resMax - res_FoodMin + 1) + res_FoodMin);
        int foodMax = resDBModel.getResFood(resNameList.get(resRandNum)).size() - 1;
        int foodRandNum = (int)(Math.random() * (foodMax - res_FoodMin + 1) + res_FoodMin);

        resImage = v.findViewById(R.id.resImage);
        resName = v.findViewById(R.id.resName);
        resFood = v.findViewById(R.id.resFood);

        resImage.setImageResource(findImage(resRandNum).get(foodRandNum));
        resName.setText(resNameList.get(resRandNum));
        //set text to the randomised restaurant's randomised food item
        resFood.setText(resDBModel.getResFood(resNameList.get(resRandNum)).get(foodRandNum));
        return v;
    }

    private ArrayList<Integer> findImage(int resRandNum)
    {
        ArrayList<Integer> foodImage = new ArrayList<>();

        switch (resRandNum)
        {
            case 0:
                foodImage = cd.getKfcImg();
               break;

            case 1:
                foodImage = cd.getMcdImg();
                break;

            case 2:
                foodImage = cd.getPizzaHutImg();
                break;

            case 3:
                foodImage = cd.getSubwayImg();
                break;

            case 4:
                foodImage = cd.getNandoImg();
                break;

            case 5:
                foodImage = cd.getSushiKingImg();
                break;

            case 6:
                foodImage = cd.getSugarbunImg();
                break;

            case 7:
                foodImage = cd.getMarrybrownImg();
                break;

            case 8:
                foodImage = cd.getSushiMentaiImg();
                break;

            case 9:
                foodImage = cd.getDominoImg();
                break;
        }
        return foodImage;
    }
}