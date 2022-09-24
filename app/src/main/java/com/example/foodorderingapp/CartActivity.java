package com.example.foodorderingapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodorderingapp.databinding.ActivityMainBinding;

public class CartActivity extends AppCompatActivity {


    ActivityMainBinding binding;
    CommonFragments common; //has all the fragments
    CartRecycler cf;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(item ->
        {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            switch(item.getItemId()){
                case R.id.menu:
                    intent.putExtra("navigation", "menu");
                    startActivity(intent);
                    break;

                case R.id.cart:
                     //do nothing
                    //startActivity(intent);
                    break;

                case R.id.orderHistory:

                    intent.putExtra("navigation", "orderhistory");
                    startActivity(intent);
                    break;

                case R.id.user:

                    intent.putExtra("navigation", "user");
                    startActivity(intent);
                    break;
            }
            return true;
        });

        RegisterFragment rf = new RegisterFragment();
        //CartRecycler cf = new CartRecycler();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frameLayoutOne, rf);
        ft.commit();
//        FragmentManager fm = getSupportFragmentManager();
//        RegisterFragment rf = (RegisterFragment) fm.findFragmentById(R.id.registerFrag);
//        //FragmentTransaction ft = fm.beginTransaction();
//        if(rf == null)
//        {
//            rf = new RegisterFragment();
//            fm.beginTransaction().add(R.id.frameLayoutOne, rf).commit();
//        }



/*
        bundle = getIntent().getBundleExtra("bundle");
        Log.d("TestActivity", "Value " + bundle);
        common = bundle.getParcelable("frag");
        //cf = common.getCartFragment();
        CartRecycler cf = new CartRecycler();
        Log.d("TestActivity", "Value " + cf);

        //start fragment
*/
    }

    private void replaceFragmentCart(Fragment fragment)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.cartRecycler, fragment);
        ft.commit();
    }

    private void replaceFragmentCheckout(Fragment fragment)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayoutTwo, fragment);
        ft.commit();
    }
}