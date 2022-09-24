package com.example.foodorderingapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodorderingapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    //initialize fragments and boolean login
    SpecialMenuFragment smf = new SpecialMenuFragment();
    RegisterFragment rf = new RegisterFragment();
    LoginFragment lf = new LoginFragment();
    UserFragment uf = new UserFragment();
    OrderFragment of = new OrderFragment();
    CartRecycler cf = new CartRecycler();
    RestaurantRecycler rr = new RestaurantRecycler();
    boolean login;

    ActivityMainBinding binding;
    ResDBModel resDBModel = new ResDBModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        resDBModel.load(getApplicationContext());
        fillRestaurantData();
        Log.d("On Create: ", "see restaurant data: " + resDBModel.getAlLRestaurant());
        Log.d("see all", "Restaurant debug " + resDBModel.getResName());
        CommonFragments data = new CommonFragments(smf, rf, lf, uf, of, cf, login, resDBModel);
        if(savedInstanceState == null) {
            replaceFragment(data.getMenuFragment());
        }

        Bundle bundle = new Bundle();
        bundle.putParcelable("frag", data);
        binding.bottomNavigationView.setOnItemSelectedListener(item ->
        {
            switch(item.getItemId()){
                case R.id.menu:

                    replaceFragment(rr);
                    rr.setArguments(bundle);
                    break;

                case R.id.cart:

                    Log.d("MainActivity", "Value " + cf);
                    Intent intent = new Intent(this, CartActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    intent.putExtra("bundle", bundle);
                    startActivity(intent);
                    replaceFragment(cf);
                    cf.setArguments(bundle);

                    break;

                case R.id.orderHistory:

                    replaceFragment(of);
                    of.setArguments(bundle);

                    break;

                case R.id.user:

                    if(!data.login) {
                        replaceFragment(rf);
                        rf.setArguments(bundle);
                    }
                    else
                    {
                        replaceFragment(uf);
                        uf.setArguments(bundle);
                    }

                    break;
            }
            return true;
        });
    }


    private void replaceFragment(Fragment fragment)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameLayout, fragment);
        ft.commit();
    }

    /* Image references:
     * KFC:
     * logo: https://en.wikipedia.org/wiki/KFC
     * food menu: https://kfc.com.my/menu.html
     * Mcd:
     * logo: https://en.wikipedia.org/wiki/McDonald%27s
     * food menu: https://www.mcdelivery.com.my/my/browse/menu.html, https://www.mcdonalds.com.my/menu,
     *            https://www.change.org/p/mcdonald-s-malaysia-mcdonald-s-malaysia-to-bring-back-ayam-goreng-mcd-regular
     * Pizza Hut:
     * logo: https://www.facebook.com/pizzahutmalaysia/photos/a.433767574653/10155297967179654/
     * food menu: https://www.pizzahut.com.my/order/pizzas
     * Subway:
     * logo: https://en.wikipedia.org/wiki/Subway_(restaurant)
     * food menu: https://www.subway.com/en-MY/MenuNutrition/Menu/Sandwiches
     * Nando's:
     * logo: https://en.wikipedia.org/wiki/Nando%27s
     * food menu: https://nandos.com.my/nandos-menu/?nandos_delivery=yes
     * sushi king:
     * logo: https://sushi-king.com/
     * food menu: https://sushi-king.com/
     * sugarbun:
     * logo: http://www.sugarbun.com/
     * food menu: http://www.sugarbun.com/menu
     * marrybrown:
     * logo: https://en.wikipedia.org/wiki/Marrybrown
     * food menu: https://food.grab.com/my/en/restaurant/marrybrown-q-avenue-delivery/1-CZKFHBAZRREXCN
     * sushi mentai:
     * logo: https://sushi-mentai.com/EN/home
     * food menu: https://sushi-mentai.com/EN/our-menu
     * domino's pizza:
     * logo: https://en.wikipedia.org/wiki/Domino%27s_Pizza
     * food menu: https://www.dominos.com.my/pages/order/menu#!/menu/category/viewAll/
     * */

    /*if want to get the image of the restaurant, get the image from the first data*/
    private void fillRestaurantData() {
        //KFC
        Restaurant kfc1 = new Restaurant("KFC", "kfc.png",
                "Snacker Box", "snacker_box_kfc.webp",
                12.99, "Includes a cup of drink, a piece of fried chicken, cheesy wedges and fries.");
        Restaurant kfc2 = new Restaurant("KFC", null, "Signature Box - Classic", "signature_box_classic_kfc.webp",
                19.99, "Includes a cup of drink, a piece of fried chicken, a Zinger Classic burger");
        Restaurant kfc3 = new Restaurant("KFC", null, "Cheezy Twister", "cheezy_twister_kfc.webp",
                11.99, " A wrap filled with fried chicken pieces, vegetables and cheesy sauce");
        Restaurant kfc4 = new Restaurant("KFC", null, "6-pc Nuggets", "six_pc_nuggets_kfc.webp",
                9.99, "A box of 6 pieces nuggets.");
        Restaurant kfc5 = new Restaurant("KFC", null, "Crispy Tenders Combo A", "crispy_tenders_combo_a_kfc.webp",
                17.99, "Includes a cup of drink, a piece of fried chicken, 3 pieces of crispy tenders, a sauce, mash potatoes and coleslaw");
        Restaurant kfc6 = new Restaurant("KFC", null, "15-pc Chicken", "fifteen_pc_chicken.webp",
                79.99, "A box of 15 pieces of fried chicken");
        Restaurant kfc7 = new Restaurant("KFC", null, "1-pc Nasi Lemak KFC Combo", "one_pc_nasi_lemak_combo_kfc.webp",
                14.99, "Includes a cup of drink and nasi lemak with KFC's fried chicken and sambal");
        Restaurant kfc8 = new Restaurant("KFC", null, "2-pc Rice Combo", "two_pc_rice_combo_kfc.webp",
                16.99, "Includes a cup of drink, Colonel rice, 2 pieces of fried chicken and coleslaw");
        Restaurant kfc9 = new Restaurant("KFC", null, "Dinner Plate (without drink)", "dinner_plate_butterscotch_kfc.webp",
                18.49, "Includes a bun, 3 pieces of fried chicken, coleslaw and mash potatoes");
        Restaurant kfc10 = new Restaurant("KFC", null, "9-pc Combo", "nine_pc_chicken_combo_kfc.webp",
                59.99, "Includes a bottle of drink, 9 pieces of fried chicken, mash potatoes and coleslaw");

        //add KFC menu into the database
        //this if condition prevent duplicates in the database. it will only these data into the database if there is no related data in it.
        if(!resDBModel.checkDataEntry("KFC"))
        {
            resDBModel.addRestaurant(kfc1);
            resDBModel.addRestaurant(kfc2);
            resDBModel.addRestaurant(kfc3);
            resDBModel.addRestaurant(kfc4);
            resDBModel.addRestaurant(kfc5);
            resDBModel.addRestaurant(kfc6);
            resDBModel.addRestaurant(kfc7);
            resDBModel.addRestaurant(kfc8);
            resDBModel.addRestaurant(kfc9);
            resDBModel.addRestaurant(kfc10);
        }

        //McDonald's
        Restaurant mcd1 = new Restaurant("McDonald's", "mcdonald_s_golden_arches_svg.png",
                "2pcs Ayam Goreng McD Spicy", "two_pc_ayam_goreng_spicy_mcd.png",
                12.59, "2 pieces of spicy McDonald's fried chicken.");
        Restaurant mcd2 = new Restaurant("McDonald's", null, "3pcs Ayam Goreng McD Regular", "three_pc_AG_regular_mcd.png",
                16.60, "3 pieces of regular McDonald's fried chicken.");
        Restaurant mcd3 = new Restaurant("McDonald's", null, "9pcs McNuggets", "nine_pc_nuggets_mcd.png",
                13.11, "A box of 9 pieces of chicken nuggets");
        Restaurant mcd4 = new Restaurant("McDonald's", null, "Nasi Lemak McD Set B", "nasi_lemak_b_mcd.png",
                17.92, "Includes a cup of drink and nasi lemak with 2 pieces of spicy fried chicken");
        Restaurant mcd5 = new Restaurant("McDonald's", null, "Bubur Ayam McD", "bubur_ayam_mcd.png",
                6.98, "McDonald's chicken porridge");
        Restaurant mcd6 = new Restaurant("McDonald's", null, "Quarter Pounder with Chesse", "quarter_pounder_mcd.png",
                13.02, "Includes beef patty, sliced raw onion, cheese, pickles and tomato sauce");
        Restaurant mcd7 = new Restaurant("McDonald's", null, "Double Cheeseburger", "double_cheeseburger_mcd.png",
                7.14, "Includes 2 pieces of beef patty, chopped raw onion, cheese, pickles and tomato sauce");
        Restaurant mcd8 = new Restaurant("McDonald's", null, "Big Mac", "big_mac_mcd.png",
                7.74, "Includes 2 pieces of beef patty, lettuce, cheese, sauce and pickles");
        Restaurant mcd9 = new Restaurant("McDonald's", null, "GCB", "gcb_mcd.png",
                12.92, "Includes a piece of grilled chicken, lettuce and sauce");
        Restaurant mcd10 = new Restaurant("McDonald's", null, "Filet-O-Fish", "filetofish_mcd.png",
                9.34, "Includes a piece of fish fillet, cheese and sauce");

        if(!resDBModel.checkDataEntry("McDonald's"))
        {
            resDBModel.addRestaurant(mcd1);
            resDBModel.addRestaurant(mcd2);
            resDBModel.addRestaurant(mcd3);
            resDBModel.addRestaurant(mcd4);
            resDBModel.addRestaurant(mcd5);
            resDBModel.addRestaurant(mcd6);
            resDBModel.addRestaurant(mcd7);
            resDBModel.addRestaurant(mcd8);
            resDBModel.addRestaurant(mcd9);
            resDBModel.addRestaurant(mcd10);
        }

        //pizza hut
        Restaurant ph1 = new Restaurant("Pizza Hut", "pizzahut_logo.png",
                "Blazing Seafood (Regular size, Pan crust)", "blazing_seafood_ph_jpeg",
                35.30, "Served with spicy sweet sour sauce, vegetables(pineapples, capsicums, onions), seafood(tuna, crabsticks) and mozzarella cheese");
        Restaurant ph2 = new Restaurant("Pizza Hut", null, "Chicken Supreme (Regular size, Pan crust)", "chicken_supreme_ph.jpeg",
                35.30, "Served with tomato sauce, chicken (meat, salami, loaf), mushrooms, capsicums, onions and mozzarella cheese");
        Restaurant ph3 = new Restaurant("Pizza Hut", null, "Hawaiian Supreme (Regular Size, Pan crust)", "hawaiian_supreme_ph.jpeg",
                35.30, "Served with tomato sauce, chicken (meat, loaf), pineapples and mozzarella cheese");
        Restaurant ph4 = new Restaurant("Pizza Hut", null, "Beef Pepperoni (Regular size, Pan crust)", "beef_pep_ph.jpeg",
                31.90, "Served with tomato sauce, beef pepperoni and mozzarella cheese");
        Restaurant ph5 = new Restaurant("Pizza Hut", null, "Veggie Lover", "veggie_lover_ph.jpeg",
                31.90, "Served with tomato sauce, mushrooms, pineapples, tomatoes, capsicums, onions and mozzarella cheese");
        Restaurant ph6 = new Restaurant("Pizza Hut", null, "Chicken Bolognaise Spaghetti", "chicken_bolog_ph.jpeg",
                16.50, "Spaghetti served with tomato bolognaise sauce and chicken meatballs");
        Restaurant ph7 = new Restaurant("Pizza Hut", null, "Creamy Carbonara Spaghetti", "creamy_carbonara_ph.jpeg",
                16.50, "Spaghetti served with creamy carbonara sauce, chicken rolls and mushrooms");
        Restaurant ph8 = new Restaurant("Pizza Hut", null, "Aglio Olio Spaghetti", "aglio_olio_ph.jpeg",
                13.50, "Spaghetti served with olive oil, herbs, mushrooms, capsicums and chili flakes");
        Restaurant ph9 = new Restaurant("Pizza Hut", null, "Krispy Wings Original", "krispy_wings_ph.png",
                12.90, "A box of Pizza Hut's fried chicken");
        Restaurant ph10 = new Restaurant("Pizza Hut", null, "Mushroom Soup", "soup_ph.jpeg",
                4.90, "A bowl of mushroom soup");

        if(!resDBModel.checkDataEntry("Pizza Hut"))
        {
            resDBModel.addRestaurant(ph1);
            resDBModel.addRestaurant(ph2);
            resDBModel.addRestaurant(ph3);
            resDBModel.addRestaurant(ph4);
            resDBModel.addRestaurant(ph5);
            resDBModel.addRestaurant(ph6);
            resDBModel.addRestaurant(ph7);
            resDBModel.addRestaurant(ph8);
            resDBModel.addRestaurant(ph9);
            resDBModel.addRestaurant(ph10);
        }

        //subway
        Restaurant sb1 = new Restaurant("Subway", "Subway_2016_logo.svg.png",
                "Chicken Slice Sandwich (6 inch)", "sandwich-slicedchicken_sub.jpg",
                12.60, "Served with sliced chicken, your choice of bread, condiments and fresh vegetables");
        Restaurant sb2 = new Restaurant("Subway", null, "Chicken Teriyaki Sandwich (6 inch)", "sandwich-chicken-teriyaki_sub.jpg",
                12.20, "Served with teriyaki chicken pieces, your choice of bread, condiments and fresh vegetables");
        Restaurant sb3 = new Restaurant("Subway", null, "Roasted Chicken Sandwich (6 inch)", "sandwich-roasted-chicken_sub.jpg",
                12.95, "Served with a piece of roasted chicken, your choice of bread, condiments and fresh vegetables");
        Restaurant sb4 = new Restaurant("Subway", null, "Steak and Cheese Sandwich (6 inch)", "sandwich-steakandcheese_sub.jpg",
                12.60, "Served with tender steak, cheese, your choice of bread, condiments and fresh vegetables");
        Restaurant sb5 = new Restaurant("Subway", null, "Subway Club Sandwich (6 inch)", "sandwich-subway-club_sub.jpg",
                13.25, "Served with sliced turkey breast, sliced roast beef, sliced chicken, your choice of bread, condiments and fresh vegetables");
        Restaurant sb6 = new Restaurant("Subway", null, "Veggie Delite", "sandwich-veggie-delite_sub.jpg",
                7.55, "Served with lettuce, tomatoes, green peppers, onions, your choice of bread and condiments");
        Restaurant sb7 = new Restaurant("Subway", null, "Chicken Slice Salad", "salads-spiral-chicken-slice_sub.jpg",
                14.70, "A bowl of salad with sliced chicken, your choice of vegetables and condiments");
        Restaurant sb8 = new Restaurant("Subway", null, "Tuna Salad", "salads-spiral-tuna_sub.jpg",
                13.50, "A bowl of salad with tuna, your choice of vegetables and condiments");
        Restaurant sb9 = new Restaurant("Subway", null, "Roast Beef Salad", "salads-roast-beef_sub.jpg",
                15.05, "A bowl of salad with slices of roasted beef, your choice of vegetables and condiments");
        Restaurant sb10 = new Restaurant("Subway", null, "Cookies (3 pieces)", "sides-drinks-cookies_sub.jpg",
                5.50, "3 pieces of cookies of your choice");

        if(!resDBModel.checkDataEntry("Subway"))
        {
            resDBModel.addRestaurant(sb1);
            resDBModel.addRestaurant(sb2);
            resDBModel.addRestaurant(sb3);
            resDBModel.addRestaurant(sb4);
            resDBModel.addRestaurant(sb5);
            resDBModel.addRestaurant(sb6);
            resDBModel.addRestaurant(sb7);
            resDBModel.addRestaurant(sb8);
            resDBModel.addRestaurant(sb9);
            resDBModel.addRestaurant(sb10);
        }

        //Nando's
        Restaurant nandos1 = new Restaurant("Nando's", "Nandos_logo.svg.png",
                "Saucy Chicken Bowl", "Saucy-Chicken-Bowl_nandos.png",
                17.90, "Includes saucy chicken and Mediterranean or Port Roll");
        Restaurant nandos2 = new Restaurant("Nando's", null, "1/4 Chicken (with 1 side)", "Quad-Chicken-wt-2-Sides-nandos.jpg",
                22.90, "Includes a piece of 1/4 chicken, fries and coleslaw");
        Restaurant nandos3 = new Restaurant("Nando's", null, "16 Wingettes and Drummetes", "sixteen-Wingettes-and-Drummetes-nandos.jpg",
                46.90, "Includes 16 wingettes and drummettes");
        Restaurant nandos4 = new Restaurant("Nando's", null, "Veggie Carnival Bowl", "Veggie-Carnival-Bowl-in-Spicy-Rice-nandos.jpg",
                22.90, "Includes grilled portobello mushrooms with spicy rice, spinach, corn and red pepper");
        Restaurant nandos5 = new Restaurant("Nando's", null, "Dino Chicken Tenders", "Dino-Tenders-nandos.jpg",
                15.90, "Includes 4 chicken tenders, 1 side of your choice and a cup of drink of your choice");
        Restaurant nandos6 = new Restaurant("Nando's", null, "Portobello Mushroom with Tofu Burger", "Portobello-Mushroom-wt-Tofu-Patty-Burger-wt-1-Sides-v2-To-Green-nandos.jpg",
                21.90, "Includes grilled portobello mushrooms, tofu patty, fresh lettuce, tomatoes and condiments (creamy mayo and chilli jam)");
        Restaurant nandos7 = new Restaurant("Nando's", null, "Portobello Mushroom with Tofu Wrap", "Portobello-Mushroom-wt-Tofu-Patty-Wrap-1-Sides-v2_Green-nandos.jpg",
                21.90, "Includes grilled portobello mushrooms, tofu patty, fresh lettuce, tomatoes and condiments (creamy mayo and chilli jam)");
        Restaurant nandos8 = new Restaurant("Nando's", null, "Jumbo Platter (For 4 - 6 Person)", "Jumbo-Platter-5-Large-Sides-nandos.jpg",
                168.90, "Includes 2 whole chickens and 5 large sides");
        Restaurant nandos9 = new Restaurant("Nando's", null, "Sweet Po-Tri-To Chips with PERinaise", "Po-Tri-To-01-nandos.jpg",
                18.90, "Includes tri-colour sweet potato chips and dipping sauce");
        Restaurant nandos10 = new Restaurant("Nando's", null, "PERi-PERi Soup", "Soup-Only-v2_Light-Blue-nandos.jpg",
                7.90, "Includes PERi-PERi soup only");

        if(!resDBModel.checkDataEntry("Nando's"))
        {
            resDBModel.addRestaurant(nandos1);
            resDBModel.addRestaurant(nandos2);
            resDBModel.addRestaurant(nandos3);
            resDBModel.addRestaurant(nandos4);
            resDBModel.addRestaurant(nandos5);
            resDBModel.addRestaurant(nandos6);
            resDBModel.addRestaurant(nandos7);
            resDBModel.addRestaurant(nandos8);
            resDBModel.addRestaurant(nandos9);
            resDBModel.addRestaurant(nandos10);
        }

        //Sushi King
        Restaurant sk1 = new Restaurant("Sushi King", "SKLogo.png",
                "Unagi Set", "Unagi-Set_sk.jpg",
                27.90, "Includes a bowl of rice, grilled eel (unagi) and miso soup");
        Restaurant sk2 = new Restaurant("Sushi King", null, "Grand Tenpure Yaki Sakana Set", "Tenpura-Saba-Set_sk.jpg",
                20.50, "Includes grilled mackerel, prawns, chicken and vegetable tenpura, rice, miso soup");
        Restaurant sk3 = new Restaurant("Sushi King", null, "California Temaki", "california-temaki_sk.jpg",
                6.00, "Includes crabstick, omelette, cucumber and tsubukko mayonnaise");
        Restaurant sk4 = new Restaurant("Sushi King", null, "Soft Shell Crab Temaki", "soft-shell-crab-temaki_sk.jpg",
                6.00, "Includes deep-fried soft shell crab, cucumber and tsubukko mayonnaise");
        Restaurant sk5 = new Restaurant("Sushi King", null, "Norwegian Salmon Sashimi", "Norwegian-Salmon-Sashimi_sk.jpg",
                15.40, "Includes Raw Norwegian Salmon");
        Restaurant sk6 = new Restaurant("Sushi King", null, "Karaage Egg Salad", "Karaage-Egg-Salad_sk.jpg",
                6.90, "Includes deep-fried chicken, egg mayonnaise, hard boiled egg and vegetables with dressing");
        Restaurant sk7 = new Restaurant("Sushi King", null, "Chicken Gyoza", "Chicken-Gyoza_sk.jpg",
                5.90, "Includes deep-fried chicken dumpling and in-house gyoza sauce");
        Restaurant sk8 = new Restaurant("Sushi King", null, "Oyako Don", "Oyako-Don_sk.jpg",
                14.30, "Includes rice with chicken, egg and onions");
        Restaurant sk9 = new Restaurant("Sushi King", null, "Yakiniku Ebi Fry Bento", "Yakiniku-Ebi-Fry-Bento_sk.jpg",
                19.90, "Includes rice with pan-fried beef and vegetables, deep-fried prawns and long beans with spicy sauce and mayonnaise served, edamame salad, crabstick, omelette");
        Restaurant sk10 = new Restaurant("Sushi King", null, "Salmon Belly Nanban Bento", "Salmon-Belly-Nanban-Bento_sk.jpg",
                19.90, "Includes rice with deep-fried salmon belly and long beans with Japanese-style tartar sauce, deep fried salmon patty with spicy sauce, edamame salad, crabstick and omelette");

        if(!resDBModel.checkDataEntry("Sushi King"))
        {
            resDBModel.addRestaurant(sk1);
            resDBModel.addRestaurant(sk2);
            resDBModel.addRestaurant(sk3);
            resDBModel.addRestaurant(sk4);
            resDBModel.addRestaurant(sk5);
            resDBModel.addRestaurant(sk6);
            resDBModel.addRestaurant(sk7);
            resDBModel.addRestaurant(sk8);
            resDBModel.addRestaurant(sk9);
            resDBModel.addRestaurant(sk10);
        }

        //SugarBun
        Restaurant sbun1 = new Restaurant("SugarBun", "sugarbun-logo.png",
                "Broasted Chicken (12pcs)", "broasted chicken_2_sb.png",
                55.10, "Includes 12 pieces of broasted chicken");
        Restaurant sbun2 = new Restaurant("SugarBun", null, "Chicken Mushroom Claypot Meal", "chic_mushroom_sb.png",
                16.50, "Served with rice");
        Restaurant sbun3 = new Restaurant("SugarBun", null, "Eco Assam Fish Claypot Meal", "asam fish head_1_sb.png",
                16.50, "Served with rice");
        Restaurant sbun4 = new Restaurant("SugarBun", null, "1 piece chicken and rice", "one_pc_chicken_rice_sub.png",
                10.90, "Includes 1 piece of chicken, savoury rice and fresh pickles");
        Restaurant sbun5 = new Restaurant("SugarBun", null, "Fish and rice", "fish_rice_sb.png",
                13.90, "Includes a piece of fish fillet, savoury rice and fresh pickles");
        Restaurant sbun6 = new Restaurant("SugarBun", null, "Chicken and fish rice", "chicken_fish_rice_sb.png",
                16.90, "Includes a piece of fish fillet, a piece of broasted chicken, savoury rice and fresh pickles");
        Restaurant sbun7 = new Restaurant("SugarBun", null, "Borneo eco fish meal", "sambal_eco_fish_2_sb.png",
                21.90, "Includes tilapia fish, rice and fresh pickles");
        Restaurant sbun8 = new Restaurant("SugarBun", null, "Cheese burger (beef) Combo", "cheese-burger_sb.png",
                11.90, "Served with a cup of drink and fries");
        Restaurant sbun9 = new Restaurant("SugarBun", null, "Chicken Sandwich Combo", "chicken-sandwich_sub.png",
                12.90, "Served with a cup of drink and fries");
        Restaurant sbun10 = new Restaurant("SugarBun", null, "Fish Burger Combo", "fish-burger_sub.png",
                15.90, "Served with a cup of drink and fries");

        if(!resDBModel.checkDataEntry("SugarBun"))
        {
            resDBModel.addRestaurant(sbun1);
            resDBModel.addRestaurant(sbun2);
            resDBModel.addRestaurant(sbun3);
            resDBModel.addRestaurant(sbun4);
            resDBModel.addRestaurant(sbun5);
            resDBModel.addRestaurant(sbun6);
            resDBModel.addRestaurant(sbun7);
            resDBModel.addRestaurant(sbun8);
            resDBModel.addRestaurant(sbun9);
            resDBModel.addRestaurant(sbun10);
        }

        //Marrybrown
        Restaurant mb1 = new Restaurant("Marrybrown", "Marrybrown_Logo.png",
                "Cheesy Chicken Mashed Bowl", "cheesy-chicken-mashed-bowl-mb.webp",
                6.50, "Includes mashed potato, cheese cause, breaded chicken fillet and mayonnaise");
        Restaurant mb2 = new Restaurant("Marrybrown", null, "Seafood bowl", "seafood-bowl-mb.webp",
                6.50, "Includes fries, prawn finger, fish nugget and dill tartar sauce");
        Restaurant mb3 = new Restaurant("Marrybrown", null, "Chicken Burger - Combo", "chicken-burger-combo-mb.webp",
                12.90, "Includes 1 chicken burger, 6 pieces of potato wedges and a cup of drink of your choice");
        Restaurant mb4 = new Restaurant("Marrybrown", null, "Hotouch Burger - Combo", "hotouch-burger-mb.webp",
                16.90, "Includes 1 hotouch burger, 6 pieces of potato wedges and a cup of drink of your choice");
        Restaurant mb5 = new Restaurant("Marrybrown", null, "Cheesy Burger - Combo", "cheesy-burger-combo.webp",
                14.70, "Includes 1 cheesy burger, 6 pieces of potato wedges and a cup of drink of your choice");
        Restaurant mb6 = new Restaurant("Marrybrown", null, "Lucky Plate - Combo", "lucky-plate-mb.webp",
                18.90, "Includes 2 pieces of MB Crispy Chicken, 1 mashed potato, 1 vegetable salad, a piece of roti goreng and a cup of drink of your choice");
        Restaurant mb7 = new Restaurant("Marrybrown", null, "Cheesy Chicken - Combo", "cheesy-chicken-mb.webp",
                21.80, "Includes 2 pieces of MB Crispy Chicken with cheese sauce, 6 pieces of potato wedges and a cup of drink of your choice");
        Restaurant mb8 = new Restaurant("Marrybrown", null, "Jumbo Meal", "jumbo-meal-mb.webp",
                26.80, "Includes 1 chicken burger, 1 piece of MB Crispy Chicken, fries, 1 vegetable salad, 4 pieces of onion ring and a cup of drink of your choice");
        Restaurant mb9 = new Restaurant("Marrybrown", null, "Bubur Ayam MB - Combo", "bubur-ayam-mb.webp",
                11.80, "Includes 1 MB chicken porridge, sliced chicken fillets, fried onions and a cup of drink of your choice");
        Restaurant mb10 = new Restaurant("Marrybrown", null, "5-pcs MB Crispy Chicken", "five-pcs-chicken-mb.webp",
                32.20, "Includes 5 pieces of MB signature crispy chicken");

        if(!resDBModel.checkDataEntry("Marrybrown"))
        {
            resDBModel.addRestaurant(mb1);
            resDBModel.addRestaurant(mb2);
            resDBModel.addRestaurant(mb3);
            resDBModel.addRestaurant(mb4);
            resDBModel.addRestaurant(mb5);
            resDBModel.addRestaurant(mb6);
            resDBModel.addRestaurant(mb7);
            resDBModel.addRestaurant(mb8);
            resDBModel.addRestaurant(mb9);
            resDBModel.addRestaurant(mb10);
        }

        //Sushi Mentai
        Restaurant sm1 = new Restaurant("Sushi Mentai", "sushimentai_logo.png",
                "Salmon Skin Maki", "salmon-skin-maki-sm.jpg",
                6.80, "Includes 4 pieces of salmon skin maki");
        Restaurant sm2 = new Restaurant("Sushi Mentai", null, "Salmon Mentai Dragon maki", "salmon-mentai-dragon-maki-sm.jpg",
                12.80, "Includes 4 pieces of salmon mentai dragon maki");
        Restaurant sm3 = new Restaurant("Sushi Mentai", null, "Inari Wrap", "inari-wrap-sm.jpg",
                7.80, "Includes 6 pieces of inari wrap");
        Restaurant sm4 = new Restaurant("Sushi Mentai", null, "Kitsune Udon", "kitsune-udon-sm.jpg",
                10.80, "A bowl of udon with kitsune, seaweed and kamaboko (japanese fish cake)");
        Restaurant sm5 = new Restaurant("Sushi Mentai", null, "Curry Udon", "curry-udon-sm.jpg",
                11.80, "A bowl of udon with curry and ebi fry");
        Restaurant sm6 = new Restaurant("Sushi Mentai", null, "Zaru Soba", "zaru-soba-sm.jpg",
                8.80, "This is cold soba noodles made from buckwheat flour and includes soy sauce based dipping sauce");
        Restaurant sm7 = new Restaurant("Sushi Mentai", null, "Tori Katsu Don", "tori-katsu-don-sm.jpg",
                12.80, "A bowl of deep fried chicken cutlet rice");
        Restaurant sm8 = new Restaurant("Sushi Mentai", null, "Hotate Toji Don", "hotate-toji-don-sm.jpg",
                12.80, "A bowl of scallop and egg rice");
        Restaurant sm9 = new Restaurant("Sushi Mentai", null, "Tempura Moriawase", "tempura-moriawase-sm.jpg",
                13.80, "Includes pieces of lightly battered and deep fried seafood and vegetables");
        Restaurant sm10 = new Restaurant("Sushi Mentai", null, "Shiro Maguro", "shiro-maguro-sm.jpg",
                10.80, "Includes 5 pieces of shiro maguro (albacore tuna)");

        if(!resDBModel.checkDataEntry("Sushi Mentai"))
        {
            resDBModel.addRestaurant(sm1);
            resDBModel.addRestaurant(sm2);
            resDBModel.addRestaurant(sm3);
            resDBModel.addRestaurant(sm4);
            resDBModel.addRestaurant(sm5);
            resDBModel.addRestaurant(sm6);
            resDBModel.addRestaurant(sm7);
            resDBModel.addRestaurant(sm8);
            resDBModel.addRestaurant(sm9);
            resDBModel.addRestaurant(sm10);
        }

        //Domino's Pizza
        Restaurant dm1 = new Restaurant("Domino's Pizza", "Domino's_pizza_logo.svg.png",
                "Chicken Confidential Pizza", "chicken-confidential-pizza-dm.jpg",
                37.80, "Includes onions, cherry tomatoes, pineapple, chicken potpourri, roasted chicken and shredded chicken with Domino's top secret sauce");
        Restaurant dm2 = new Restaurant("Domino's Pizza", null, "Prawn Sensation Pizza", "prawn-sensation-pizza-dm.jpg",
                37.80, "Includes prawn marinated in Italian herbs and spices, spinach, cherry tomatoes, onion and Domino's new pizza sauce");
        Restaurant dm3 = new Restaurant("Domino's Pizza", null, "Ultimate Hawaiian Pizza", "ultimate-hawaiian-pizza-dm.jpg",
                37.80, "Includes roasted chicken, shredded chicken, pineapples and mushrooms");
        Restaurant dm4 = new Restaurant("Domino's Pizza", null, "Classic Chicken Pizza", "classic-chicken-pizza-dm.jpg",
                35.80, "Includes shredded onions, green pepper and ripe olives");
        Restaurant dm5 = new Restaurant("Domino's Pizza", null, "Meat Mania Pizza", "meat-mania-pizza-dm.jpg",
                35.80, "Includes beef pepperoni, beef sausages, ground beef, chicken potpourri sausages and ripe olives");
        Restaurant dm6 = new Restaurant("Domino's Pizza", null, "Flaming Tuna Pizza", "flaming-tuna-pizza-dm.jpg",
                31.90, "Includes tuna chunks, fresh onions, chilies");
        Restaurant dm7 = new Restaurant("Domino's Pizza", null, "Chicken Wings Hot & Spicy", "wings-hot-and-spicy-dm.jpg",
                15.90, "Chicken wings covered in hot & spicy sauce");
        Restaurant dm8 = new Restaurant("Domino's Pizza", null, "Roasted Chicken Drummets", "roasted-chicken-drummets-dm.jpg",
                15.90, "Chicken drummet marinated in dried oregano, black pepper and garlic");
        Restaurant dm9 = new Restaurant("Domino's Pizza", null, "Chicken Lasagna", "chicken-lasagna-dm.jpg",
                15.50, "This is a hot & saucy lasagna stuffed with layers of meat sauce and mozzarella cheese");
        Restaurant dm10 = new Restaurant("Domino's Pizza", null, "Spaghetti Bolognese Chicken", "spaghetti-bolog-dm.jpg",
                15.50, "Spaghetti cooked with Bolognese chicken sauce");

        if(!resDBModel.checkDataEntry("Domino's Pizza"))
        {
            resDBModel.addRestaurant(dm1);
            resDBModel.addRestaurant(dm2);
            resDBModel.addRestaurant(dm3);
            resDBModel.addRestaurant(dm4);
            resDBModel.addRestaurant(dm5);
            resDBModel.addRestaurant(dm6);
            resDBModel.addRestaurant(dm7);
            resDBModel.addRestaurant(dm8);
            resDBModel.addRestaurant(dm9);
            resDBModel.addRestaurant(dm10);
        }
    }
}