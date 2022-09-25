package com.example.foodorderingapp;

/*incomplete*/

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CartRecycler extends Fragment {

    public CartRecycler() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_cart_recycler, container, false);

        Bundle bundle = this.getArguments();
        CommonFragments data = bundle.getParcelable("frag");
        CartDBModel cartDBModel = data.getCartDBModel();
        FoodHistoryDBModel foodHistoryDBModel = data.getFoodHistoryDBModel();
        RecyclerView rv = v.findViewById(R.id.cartRecycler);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        CartAdapter ca = new CartAdapter(data);
        rv.setAdapter(ca);

        DividerItemDecoration div = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(div);

        FloatingActionButton checkoutButton = v.findViewById(R.id.checkoutButton);

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if user is login
                if(data.login) {
                    //put item in food history database

                    int totalPrice;
                    String foodList;
                    String username = data.getUsername();

                    ArrayList<String> foodCart = cartDBModel.getFoodName(username);
                    ArrayList<Integer> foodPrice = cartDBModel.getFoodPrice(username);
                    ArrayList<Integer> foodQuantity = totalFoodQuantity(foodCart, cartDBModel, username);

                    foodList = combineFood(foodCart, foodQuantity);
                    totalPrice = totalFoodPrice(foodPrice, foodCart, foodQuantity);

                    //store the data to food history database
                    FoodHistory foodHistory = new FoodHistory(username, foodList, totalPrice);
                    foodHistoryDBModel.addFoodHistory(foodHistory);
                    //remove item from cart
                    cartDBModel.deleteCartDatabase();


                    //Move to main menu
                    RestaurantRecycler rr = data.getRestaurantFragment();
                    Toast.makeText(getActivity(), "Successfully checkout", Toast.LENGTH_SHORT).show();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout, rr);
                    ft.commit();
                    rr.setArguments(bundle);
                }
                else
                {
                    RegisterFragment rf = data.getRegisterFragment();
                    Toast.makeText(getActivity(), "Please log in first", Toast.LENGTH_SHORT).show();
                    FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.frameLayout, rf);
                    ft.commit();
                    rf.setArguments(bundle);

                }
            }
        });

        return v;
    }

    private String combineFood(ArrayList<String> foodItem, ArrayList<Integer> foodQuantity )
    {

        String food = "";

        for(int i = 0; i < foodItem.size(); i++)
        {
            food += foodItem.get(i) + " * " + foodQuantity.get(i) +"\n";
        }

        return food;
    }

    private int totalFoodPrice(ArrayList<Integer> foodPrice, ArrayList<String> foodList, ArrayList<Integer> foodQuantity)
    {
        int food = 0;
        for(int i = 0; i < foodPrice.size(); i++)
        {
            food += foodPrice.get(i) * foodQuantity.get(i);
        }

        return food;
    }

    private ArrayList<Integer> totalFoodQuantity(ArrayList<String> foodItem, CartDBModel cartDBModel, String username )
    {
        ArrayList<Integer> foodQuantityList = new ArrayList<>();

        //Put all the quantity into a list
        for(int i = 0; i < foodItem.size(); i++)
        {
            foodQuantityList.add(cartDBModel.getFoodQuantity((foodItem.get(i)), username));
        }

        return foodQuantityList;
    }
}