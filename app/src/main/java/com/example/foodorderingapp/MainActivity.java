package com.example.foodorderingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;

import com.example.foodorderingapp.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ResDBModel resDBModel = new ResDBModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        resDBModel.load(getApplicationContext());
        fillRestaurantData();

        if(savedInstanceState == null) {
            replaceFragment(new MenuFragment());
        }

        binding.bottomNavigationView.setOnItemSelectedListener(item ->
        {
            switch(item.getItemId()){
                case R.id.menu:
                    replaceFragment(new MenuFragment());
                    break;

                case R.id.cart:
                    replaceFragment(new CartFragment());
                    break;

                case R.id.orderHistory:
                    replaceFragment(new OrderFragment());
                    break;

                case R.id.user:
                    replaceFragment(new RegisterFragment());
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
    * food menu: https://www.mcdelivery.com.my/my/browse/menu.html, https://www.mcdonalds.com.my/menu
    * Pizza Hut:
    * logo: https://en.wikipedia.org/wiki/Pizza_Hut
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
        Restaurant kfc1 = new Restaurant("KFC", "https://upload.wikimedia.org/wikipedia/en/thumb/b/bf/KFC_logo.svg/220px-KFC_logo.svg.png",
                "Snacker Box", "https://kfc.com.my/media/catalog/product/s/n/snacker-box_1.jpg?quality=80&bg-color=255%2C255%2C255&fit=cover&height=1200&width=960&auto=webp&format=pjpg",
                12.99, "Includes a cup of drink, a piece of fried chicken, cheesy wedges and fries.");
        Restaurant kfc2 = new Restaurant("KFC", null, "Signature Box - Classic", "https://kfc.com.my/media/catalog/product/s/i/signature-box-classic_1.jpg?quality=80&bg-color=255%2C255%2C255&fit=cover&height=1200&width=960&auto=webp&format=pjpg",
                19.99, "Includes a cup of drink, a piece of fried chicken, a Zinger Classic burger");
        Restaurant kfc3 = new Restaurant("KFC", null, "Cheezy Twister", "https://kfc.com.my/media/catalog/product/c/h/cheezy-twister_2.jpg?quality=80&bg-color=255%2C255%2C255&fit=cover&height=1200&width=960&auto=webp&format=pjpg",
                11.99, " A wrap filled with fried chicken pieces, vegetables and cheesy sauce");
        Restaurant kfc4 = new Restaurant("KFC", null, "6-pc Nuggets", "https://kfc.com.my/media/catalog/product/6/-/6-pc-nuggets_1.jpg?quality=80&bg-color=255%2C255%2C255&fit=cover&height=1200&width=960&auto=webp&format=pjpg",
                9.99, "A box of 6 pieces nuggets.");
        Restaurant kfc5 = new Restaurant("KFC", null, "Crispy Tenders Combo A", "https://kfc.com.my/media/catalog/product/c/r/crispy-tenders-combo-a_1.jpg?quality=80&bg-color=255%2C255%2C255&fit=cover&height=1200&width=960&auto=webp&format=pjpg",
                17.99, "Includes a cup of drink, a piece of fried chicken, 3 pieces of crispy tenders, a sauce, mash potatoes and coleslaw");
        Restaurant kfc6 = new Restaurant("KFC", null, "15-pc Chicken", "https://kfc.com.my/media/catalog/product/1/5/15-pc-chicken.jpg?quality=80&bg-color=255%2C255%2C255&fit=cover&height=1200&width=960&auto=webp&format=pjpg",
                79.99, "A box of 15 pieces of fried chicken");
        Restaurant kfc7 = new Restaurant("KFC", null, "1-pc Nasi Lemak KFC Combo", "https://kfc.com.my/media/catalog/product/1/-/1-pc-nasi-lemak-combo_1.jpg?quality=80&bg-color=255%2C255%2C255&fit=cover&height=1200&width=960&auto=webp&format=pjpg",
                14.99, "Includes a cup of drink and nasi lemak with KFC's fried chicken and sambal");
        Restaurant kfc8 = new Restaurant("KFC", null, "2-pc Rice Combo", "https://kfc.com.my/media/catalog/product/2/-/2-pc-rice-combo_1.jpg?quality=80&bg-color=255%2C255%2C255&fit=cover&height=1200&width=960&auto=webp&format=pjpg",
                16.99, "Includes a cup of drink, Colonel rice, 2 pieces of fried chicken and coleslaw");
        Restaurant kfc9 = new Restaurant("KFC", null, "Dinner Plate (without drink)", "https://kfc.com.my/media/catalog/product/d/i/dinner-plate-butterscotch.jpg?quality=80&bg-color=255%2C255%2C255&fit=cover&height=1200&width=960&auto=webp&format=pjpg",
                18.49, "Includes a bun, 3 pieces of fried chicken, coleslaw and mash potatoes");
        Restaurant kfc10 = new Restaurant("KFC", null, "9-pc Combo", "https://kfc.com.my/media/catalog/product/9/-/9-pc-chicken-combo_1.jpg?quality=80&bg-color=255%2C255%2C255&fit=cover&height=1200&width=960&auto=webp&format=pjpg",
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
        Restaurant mcd1 = new Restaurant("McDonald's", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/36/McDonald%27s_Golden_Arches.svg/180px-McDonald%27s_Golden_Arches.svg.png",
                "2pcs Ayam Goreng McD Spicy", "https://www.mcdelivery.com.my/my/static/1663260896445/assets/60/products/1208.png?",
                12.59, "2 pieces of spicy McDonald's fried chicken.");
        Restaurant mcd2 = new Restaurant("McDonald's", null, "3pcs Ayam Goreng McD Regular", "https://www.mcdelivery.com.my/my/static/1663260896445/assets/60/products/1220.png?",
                16.60, "3 pieces of regular McDonald's fried chicken.");
        Restaurant mcd3 = new Restaurant("McDonald's", null, "9pcs McNuggets", "https://www.mcdelivery.com.my/my/static/1663260896445/assets/60/products/1010.png?",
                13.11, "A box of 9 pieces of chicken nuggets");
        Restaurant mcd4 = new Restaurant("McDonald's", null, "Nasi Lemak McD Set B", "https://www.mcdelivery.com.my/my/static/1663260896445/assets/60/products/8064.png?",
                17.92, "Includes a cup of drink and nasi lemak with 2 pieces of spicy fried chicken");
        Restaurant mcd5 = new Restaurant("McDonald's", null, "Bubur Ayam McD", "https://www.mcdelivery.com.my/my/static/1663260896445/assets/60/products/4201.png?",
                6.98, "McDonald's chicken porridge");
        Restaurant mcd6 = new Restaurant("McDonald's", null, "Quarter Pounder with Chesse", "https://www.mcdelivery.com.my/my/static/1663260896445/assets/60/products/1009.png?",
                13.02, "Includes beef patty, sliced raw onion, cheese, pickles and tomato sauce");
        Restaurant mcd7 = new Restaurant("McDonald's", null, "Double Cheeseburger", "https://www.mcdonalds.com.my/storage/foods/September2019/rsEVZNlajmultZkYkKrH.png",
                7.14, "Includes 2 pieces of beef patty, chopped raw onion, cheese, pickles and tomato sauce");
        Restaurant mcd8 = new Restaurant("McDonald's", null, "Big Mac", "https://www.mcdonalds.com.my/storage/foods/September2019/zXCw3DU1o1DM0crWjAWB.png",
                7.74, "Includes 2 pieces of beef patty, lettuce, cheese, sauce and pickles");
        Restaurant mcd9 = new Restaurant("McDonald's", null, "GCB", "https://www.mcdelivery.com.my/my/static/1663260896445/assets/60/products/1094.png?",
                12.92, "Includes a piece of grilled chicken, lettuce and sauce");
        Restaurant mcd10 = new Restaurant("McDonald's", null, "Filet-O-Fish", "https://www.mcdelivery.com.my/my/static/1663260896445/assets/60/products/1002.png?",
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
        Restaurant ph1 = new Restaurant("Pizza Hut", "https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Pizza_Hut_1967-1999_logo.svg/170px-Pizza_Hut_1967-1999_logo.svg.png",
                "Blazing Seafood (Regular size, Pan crust)", "https://static.phdvasia.com/sg1/menu/single/desktop_thumbnail_3b6db636-1ae3-40ef-8d74-af77207e671a.jpeg",
                35.30, "Served with spicy sweet sour sauce, vegetables(pineapples, capsicums, onions), seafood(tuna, crabsticks) and mozzarella cheese");
        Restaurant ph2 = new Restaurant("Pizza Hut", null, "Chicken Supreme (Regular size, Pan crust)", "https://static.phdvasia.com/sg1/menu/single/desktop_thumbnail_7dc93124-119c-478c-a6b7-f5180f1696cb.jpeg",
                35.30, "Served with tomato sauce, chicken (meat, salami, loaf), mushrooms, capsicums, onions and mozzarella cheese");
        Restaurant ph3 = new Restaurant("Pizza Hut", null, "Haiwaiian Supreme (Regular Size, Pan crust)", "https://static.phdvasia.com/sg1/menu/single/desktop_thumbnail_96441904-e6b6-46b8-9d62-c989c57299d4.jpeg",
                35.30, "Served with tomato sauce, chicken (meat, loaf), pineapples and mozzarella cheese");
        Restaurant ph4 = new Restaurant("Pizza Hut", null, "Beef Pepperoni (Regular size, Pan crust)", "https://static.phdvasia.com/sg1/menu/single/desktop_thumbnail_e410044f-7fc1-4f44-ae36-6d6cc3cab2d7.jpeg",
                31.90, "Served with tomato sauce, beef pepperoni and mozzarella cheese");
        Restaurant ph5 = new Restaurant("Pizza Hut", null, "Veggie Lover", "https://static.phdvasia.com/sg1/menu/single/desktop_thumbnail_bf260f62-32e8-48bd-8c6c-88552b2d72bd.jpeg",
                31.90, "Served with tomato sauce, mushrooms, pineapples, tomatoes, capsicums, onions and mozzarella cheese");
        Restaurant ph6 = new Restaurant("Pizza Hut", null, "Chicken Bolognaise Spaghetti", "https://static.phdvasia.com/sg1/menu/single/desktop_thumbnail_a8900a10-c2b6-4dfb-b363-30491de399b3.jpeg",
                16.50, "Spaghetti served with tomato bolognaise sauce and chicken meatballs");
        Restaurant ph7 = new Restaurant("Pizza Hut", null, "Creamy Carbonara Spaghetti", "https://static.phdvasia.com/sg1/menu/single/desktop_thumbnail_d32e2d6c-5b09-4a52-96d9-19e716d370d2.jpeg",
                16.50, "Spaghetti served with creamy carbonara sauce, chicken rolls and mushrooms");
        Restaurant ph8 = new Restaurant("Pizza Hut", null, "Aglio Olio Spaghetti", "https://static.phdvasia.com/sg1/menu/single/desktop_thumbnail_6d340ad6-fb6b-4ddf-a07f-ebeb6f26d1af.jpeg",
                13.50, "Spaghetti served with olive oil, herbs, mushrooms, capsicums and chili flakes");
        Restaurant ph9 = new Restaurant("Pizza Hut", null, "Krispy Wings Original", "https://static.phdvasia.com/sg1/menu/single/desktop_thumbnail_7f09b62c-680b-418c-8f05-063c832c7b0d.png",
                12.90, "A box of Pizza Hut's fried chicken");
        Restaurant ph10 = new Restaurant("Pizza Hut", null, "Mushroom Soup", "https://static.phdvasia.com/sg1/menu/single/desktop_thumbnail_4092d620-b5ad-4c58-9d8a-5d4b0c05cf1d.jpeg",
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
        Restaurant sb1 = new Restaurant("Subway", "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Subway_2016_logo.svg/220px-Subway_2016_logo.svg.png",
                "Chicken Slice Sandwich (6 inch)", "https://www.subway.com/ns/images/menu/MAL/ENG/menu-category-sandwich-slicedchicken_MY.jpg",
                12.60, "Served with sliced chicken, your choice of bread, condiments and fresh vegetables");
        Restaurant sb2 = new Restaurant("Subway", null, "Chicken Teriyaki Sandwich (6 inch)", "https://www.subway.com/ns/images/menu/MAL/ENG/menu-category-all-sandwiches-chicken-teriyaki-PH-308x140.jpg",
                12.20, "Served with teriyaki chicken pieces, your choice of bread, condiments and fresh vegetables");
        Restaurant sb3 = new Restaurant("Subway", null, "Roasted Chicken Sandwich (6 inch)", "https://www.subway.com/ns/images/menu/MAL/ENG/menu-category-all-sandwiches-roasted-chicken-PH-308x140.jpg",
                12.95, "Served with a piece of roasted chicken, your choice of bread, condiments and fresh vegetables");
        Restaurant sb4 = new Restaurant("Subway", null, "Steak and Cheese Sandwich (6 inch)", "https://www.subway.com/ns/images/menu/MAL/ENG/menu-category-sandwich-steakandcheese_MY.jpg",
                12.60, "Served with tender steak, cheese, your choice of bread, condiments and fresh vegetables");
        Restaurant sb5 = new Restaurant("Subway", null, "Subway Club Sandwich (6 inch)", "https://www.subway.com/ns/images/menu/MAL/ENG/menu-category-all-sandwiches-subway-club-MY-308x140.jpg",
                13.25, "Served with sliced turkey breast, sliced roast beef, sliced chicken, your choice of bread, condiments and fresh vegetables");
        Restaurant sb6 = new Restaurant("Subway", null, "Veggie Delite", "https://www.subway.com/ns/images/menu/MAL/ENG/menu-category-all-sandwiches-veggie-delite-PH-308x140.jpg",
                7.55, "Served with lettuce, tomatoes, green peppers, onions, your choice of bread and condiments");
        Restaurant sb7 = new Restaurant("Subway", null, "Chicken Slice Salad", "https://www.subway.com/ns/images/menu/MAL/ENG/menu-category-salads-spiral-chicken-slice-MY-308x140.jpg",
                14.70, "A bowl of salad with sliced chicken, your choice of vegetables and condiments");
        Restaurant sb8 = new Restaurant("Subway", null, "Tuna Salad", "https://www.subway.com/ns/images/menu/MAL/ENG/menu-category-salads-spiral-tuna-MY-308x140.jpg",
                13.50, "A bowl of salad with tuna, your choice of vegetables and condiments");
        Restaurant sb9 = new Restaurant("Subway", null, "Roast Beef Salad", "https://www.subway.com/ns/images/menu/MAL/ENG/RPLC-salads-spiral-veggie-delite-MY-594x334.jpg",
                15.05, "A bowl of salad with slices of roasted beef, your choice of vegetables and condiments");
        Restaurant sb10 = new Restaurant("Subway", null, "Cookies (3 pieces)", "https://www.subway.com/ns/images/menu/MAL/ENG/menu-category-sides-drinks-cookies-MY-308x140.jpg",
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
        Restaurant nandos1 = new Restaurant("Nando's", "https://upload.wikimedia.org/wikipedia/en/thumb/c/c5/Nandos_logo.svg/220px-Nandos_logo.svg.png",
                "Saucy Chicken Bowl", "https://nandos.com.my/wp-content/uploads/2018/06/Saucy-Chicken-Bowl.png",
                17.90, "Includes saucy chicken and Mediterranean or Port Roll");
        Restaurant nandos2 = new Restaurant("Nando's", null, "1/4 Chicken (with 1 side)", "https://nandos.com.my/wp-content/uploads/2018/06/Quad-Chicken-wt-2-Sides-NEW.jpg",
                22.90, "Includes a piece of 1/4 chicken, fries and coleslaw");
        Restaurant nandos3 = new Restaurant("Nando's", null, "16 Wingettes and Drummetes", "https://nandos.com.my/wp-content/uploads/2018/06/16-Wingettes-and-Drumettes-v2.jpg",
                46.90, "Includes 16 wingettes and drummettes");
        Restaurant nandos4 = new Restaurant("Nando's", null, "Veggie Carnival Bowl", "https://nandos.com.my/wp-content/uploads/2021/03/Veggie-Carnival-Bowl-in-Spicy-Rice-v3.jpg",
                22.90, "Includes grilled portobello mushrooms with spicy rice, spinach, corn and red pepper");
        Restaurant nandos5 = new Restaurant("Nando's", null, "Dino Chicken Tenders", "https://nandos.com.my/wp-content/uploads/2021/11/Dino-Tenders-500px.jpg",
                15.90, "Includes 4 chicken tenders, 1 side of your choice and a cup of drink of your choice");
        Restaurant nandos6 = new Restaurant("Nando's", null, "Portobello Mushroom with Tofu Burger", "https://nandos.com.my/wp-content/uploads/2021/03/Portobello-Mushroom-wt-Tofu-Patty-Burger-wt-1-Sides-v2-To-Green.jpg",
                21.90, "Includes grilled portobello mushrooms, tofu patty, fresh lettuce, tomatoes and condiments (creamy mayo and chilli jam)");
        Restaurant nandos7 = new Restaurant("Nando's", null, "Portobello Mushroom with Tofu Wrap", "https://nandos.com.my/wp-content/uploads/2021/03/Portobello-Mushroom-wt-Tofu-Patty-Wrap-1-Sides-v2_Green.jpg",
                21.90, "Includes grilled portobello mushrooms, tofu patty, fresh lettuce, tomatoes and condiments (creamy mayo and chilli jam)");
        Restaurant nandos8 = new Restaurant("Nando's", null, "Jumbo Platter (For 4 - 6 Person)", "https://nandos.com.my/wp-content/uploads/2018/06/Jumbo-Platter-5-Large-Sides-v2.jpg",
                168.90, "Includes 2 whole chickens and 5 large sides");
        Restaurant nandos9 = new Restaurant("Nando's", null, "Sweet Po-Tri-To Chips with PERinaise", "https://nandos.com.my/wp-content/uploads/2022/05/Po-Tri-To-01-scaled.jpg",
                18.90, "Includes tri-colour sweet potato chips and dipping sauce");
        Restaurant nandos10 = new Restaurant("Nando's", null, "PERi-PERi Soup", "https://nandos.com.my/wp-content/uploads/2018/11/Soup-Only-v2_Light-Blue.jpg",
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
        Restaurant sk1 = new Restaurant("Sushi King", "https://sushi-king.com/wp-content/themes/sushi-king/assets/imgv2/SKLogo.png",
                "Unagi Set", "https://sushi-king.com/wp-content/uploads/2021/07/Unagi-Set.jpg",
                27.90, "Includes a bowl of rice, grilled eel (unagi) and miso soup");
        Restaurant sk2 = new Restaurant("Sushi King", null, "Grand Tenpure Yaki Sakana Set", "https://sushi-king.com/wp-content/uploads/2017/01/Tenpura-Saba-Set.jpg",
                20.50, "Includes grilled mackerel, prawns, chicken and vegetable tenpura, rice, miso soup");
        Restaurant sk3 = new Restaurant("Sushi King", null, "California Temaki", "https://sushi-king.com/wp-content/uploads/2017/01/13.jpg",
                6.00, "Includes crabstick, omelette, cucumber and tsubukko mayonnaise");
        Restaurant sk4 = new Restaurant("Sushi King", null, "Soft Shell Crab Temaki", "https://sushi-king.com/wp-content/uploads/2017/01/11.jpg",
                6.00, "Includes deep-fried soft shell crab, cucumber and tsubukko mayonnaise");
        Restaurant sk5 = new Restaurant("Sushi King", null, "Norwegian Salmon Sashimi", "https://sushi-king.com/wp-content/uploads/2017/01/Norwegian-Salmon-Sashimi-BM-Website.jpg",
                15.40, "Includes Raw Norwegian Salmon");
        Restaurant sk6 = new Restaurant("Sushi King", null, "Karaage Egg Salad", "https://sushi-king.com/wp-content/uploads/2020/07/Karaage-Egg-Salad_s-A-copy.jpg",
                6.90, "Includes deep-fried chicken, egg mayonnaise, hard boiled egg and vegetables with dressing");
        Restaurant sk7 = new Restaurant("Sushi King", null, "Chicken Gyoza", "https://sushi-king.com/wp-content/uploads/2017/08/Chicken-Gyoza-A-copy.jpg",
                5.90, "Includes deep-fried chicken dumpling and in-house gyoza sauce");
        Restaurant sk8 = new Restaurant("Sushi King", null, "Oyako Don", "https://sushi-king.com/wp-content/uploads/2017/01/Oyako-Don-copy.jpg",
                14.30, "Includes rice with chicken, egg and onions");
        Restaurant sk9 = new Restaurant("Sushi King", null, "Yakiniku Ebi Fry Bento", "https://sushi-king.com/wp-content/uploads/2019/02/Yakiniku-Ebi-Fry-Bento-copy.jpg",
                19.90, "Includes rice with pan-fried beef and vegetables, deep-fried prawns and long beans with spicy sauce and mayonnaise served, edamame salad, crabstick, omelette");
        Restaurant sk10 = new Restaurant("Sushi King", null, "Salmon Belly Nanban Bento", "https://sushi-king.com/wp-content/uploads/2021/07/Salmon-Belly-Nanban-Bento.jpg",
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
        Restaurant sbun1 = new Restaurant("SugarBun", "http://www.sugarbun.com/public/themes/sugarbun/images/sugarbun-logo.png",
                "Broasted Chicken (12pcs)", "http://www.sugarbun.com/public/menu/images/4/broasted%20chicken_2.png",
                55.10, "Includes 12 pieces of broasted chicken");
        Restaurant sbun2 = new Restaurant("SugarBun", null, "Chicken Mushroom Claypot Meal", "http://www.sugarbun.com/public/menu/images/3/chic_mushroom.png",
                16.50, "Served with rice");
        Restaurant sbun3 = new Restaurant("SugarBun", null, "Eco Assam Fish Claypot Meal", "http://www.sugarbun.com/public/menu/images/3/asam%20fish%20head_1.png",
                16.50, "Served with rice");
        Restaurant sbun4 = new Restaurant("SugarBun", null, "1 piece chicken and rice", "http://www.sugarbun.com/public/menu/images/13/w1_3.png",
                10.90, "Includes 1 piece of chicken, savoury rice and fresh pickles");
        Restaurant sbun5 = new Restaurant("SugarBun", null, "Fish and rice", "http://www.sugarbun.com/public/menu/images/13/w4_2.png",
                13.90, "Includes a piece of fish fillet, savoury rice and fresh pickles");
        Restaurant sbun6 = new Restaurant("SugarBun", null, "Chicken and fish rice", "http://www.sugarbun.com/public/menu/images/13/w6_2.png",
                16.90, "Includes a piece of fish fillet, a piece of broasted chicken, savoury rice and fresh pickles");
        Restaurant sbun7 = new Restaurant("SugarBun", null, "Borneo eco fish meal", "http://www.sugarbun.com/public/menu/images/3/sambal_eco_fish_2.png",
                21.90, "Includes tilapia fish, rice and fresh pickles");
        Restaurant sbun8 = new Restaurant("SugarBun", null, "Cheese burger (beef) Combo", "http://www.sugarbun.com/public/menu/images/9/cheese%20burger.png",
                11.90, "Served with a cup of drink and fries");
        Restaurant sbun9 = new Restaurant("SugarBun", null, "Chicken Sandwich Combo", "http://www.sugarbun.com/public/menu/images/9/chicken%20sandwich.png",
                12.90, "Served with a cup of drink and fries");
        Restaurant sbun10 = new Restaurant("SugarBun", null, "Fish Burger Combo", "http://www.sugarbun.com/public/menu/images/9/fish%20burger.png",
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
        Restaurant mb1 = new Restaurant("Marrybrown", "https://upload.wikimedia.org/wikipedia/en/thumb/4/43/Marrybrown_Logo.png/220px-Marrybrown_Logo.png",
                "Cheesy Chicken Mashed Bowl", "https://d1sag4ddilekf6.azureedge.net/compressed_webp/items/MYITE20220309064358012943/detail/5af7cd049115453c8a4318bfe9c386ee_1646808238232792613.webp",
                6.50, "Includes mashed potato, cheese cause, breaded chicken fillet and mayonnaise");
        Restaurant mb2 = new Restaurant("Marrybrown", null, "Seafood bowl", "https://d1sag4ddilekf6.azureedge.net/compressed_webp/items/MYITE20220309064355010041/detail/cd8663f4c8f244cd990a8070ce1a9885_1646808235582511778.webp",
                6.50, "Includes fries, prawn finger, fish nugget and dill tartar sauce");
        Restaurant mb3 = new Restaurant("Marrybrown", null, "Chicken Burger - Combo", "https://d1sag4ddilekf6.azureedge.net/compressed_webp/items/MYITE202005280427081037346/detail/793173bf160147d9ba3926eda84c2a4a_1639369317788788675.webp",
                12.90, "Includes 1 chicken burger, 6 pieces of potato wedges and a cup of drink of your choice");
        Restaurant mb4 = new Restaurant("Marrybrown", null, "Hotouch Burger - Combo", "https://d1sag4ddilekf6.azureedge.net/compressed_webp/items/MYITE202005280427081006851/detail/64a804798a104163a92777293d3e1f76_1639369318271425827.webp",
                16.90, "Includes 1 hotouch burger, 6 pieces of potato wedges and a cup of drink of your choice");
        Restaurant mb5 = new Restaurant("Marrybrown", null, "Cheesy Burger - Combo", "https://d1sag4ddilekf6.azureedge.net/compressed_webp/items/MYITE20200528042708202498/detail/db048ec1b729468b8c4e30640653ac37_1639369318054054261.webp",
                14.70, "Includes 1 cheesy burger, 6 pieces of potato wedges and a cup of drink of your choice");
        Restaurant mb6 = new Restaurant("Marrybrown", null, "Lucky Plate - Combo", "https://d1sag4ddilekf6.azureedge.net/compressed_webp/items/MYITE20200528042708179853/detail/aaebfeb23e944c0eb82c254887e89657_1639369319200972969.webp",
                18.90, "Includes 2 pieces of MB Crispy Chicken, 1 mashed potato, 1 vegetable salad, a piece of roti goreng and a cup of drink of your choice");
        Restaurant mb7 = new Restaurant("Marrybrown", null, "Cheey Chicken - Combo", "https://d1sag4ddilekf6.azureedge.net/compressed_webp/items/MYITE20211004105325012583/detail/c3146eb06a31498cb56ee3d1ed37e8d3_1639369319702304674.webp",
                21.80, "Includes 2 pieces of MB Crispy Chicken with cheese sauce, 6 pieces of potato wedges and a cup of drink of your choice");
        Restaurant mb8 = new Restaurant("Marrybrown", null, "Jumbo Meal", "https://d1sag4ddilekf6.azureedge.net/compressed_webp/items/MYITE20211004105413014667/detail/6cef3b07731747cfafd9e15b6df732f1_1639369319978405842.webp",
                26.80, "Includes 1 chicken burger, 1 piece of MB Crispy Chicken, fries, 1 vegetable salad, 4 pieces of onion ring and a cup of drink of your choice");
        Restaurant mb9 = new Restaurant("Marrybrown", null, "Bubur Ayam MB - Combo", "https://d1sag4ddilekf6.azureedge.net/compressed_webp/items/MYITE20200528042707248283/detail/b6d1124e05514d368c95fc3013dd4b3a_1639369321118170244.webp",
                11.80, "Includes 1 MB chicken porridge, sliced chicken fillets, fried onions and a cup of drink of your choice");
        Restaurant mb10 = new Restaurant("Marrybrown", null, "5-pcs MB Crispy Chicken", "https://d1sag4ddilekf6.azureedge.net/compressed_webp/items/MYITE20201202040904017433/detail/78180ced67c840929a899daba40891d0_1639369322663794656.webp",
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
        Restaurant sm1 = new Restaurant("Sushi Mentai", "https://sushi-mentai.com/zata_da/src/cp/200531.933m4q0eb8c.png",
                "Salmon Skin Maki", "https://sushi-mentai.com/zata_da/src/img/5d37ff3cbb50e0.72113307.jpg",
                6.80, "Includes 4 pieces of salmon skin maki");
        Restaurant sm2 = new Restaurant("Sushi Mentai", null, "Salmon Mentai Dragon maki", "https://sushi-mentai.com/zata_da/src/img/5d3e75e83676e7.56274570.jpg",
                12.80, "Includes 4 pieces of salmon mentai dragon maki");
        Restaurant sm3 = new Restaurant("Sushi Mentai", null, "Inari Wrap", "https://sushi-mentai.com/zata_da/src/img/5d3e77679c3e70.93921125.jpg",
                7.80, "Includes 6 pieces of inari wrap");
        Restaurant sm4 = new Restaurant("Sushi Mentai", null, "Kitsune Udon", "https://sushi-mentai.com/zata_da/src/img/5d380848c75b13.08117496.jpg",
                10.80, "A bowl of udon with kitsune, seaweed and kamaboko (japanese fish cake)");
        Restaurant sm5 = new Restaurant("Sushi Mentai", null, "Curry Udon", "https://sushi-mentai.com/zata_da/src/img/5d3e7aceeeb719.50820447.jpg",
                11.80, "A bowl of udon with curry and ebi fry");
        Restaurant sm6 = new Restaurant("Sushi Mentai", null, "Zaru Soba", "https://sushi-mentai.com/zata_da/src/img/5d3e7c1b6a8224.09409425.jpg",
                8.80, "This is cold soba noodles made from buckwheat flour and includes soy sauce based dipping sauce");
        Restaurant sm7 = new Restaurant("Sushi Mentai", null, "Tori Katsu Don", "https://sushi-mentai.com/zata_da/src/img/5d3e7895eb5e77.32204001.jpg",
                12.80, "A bowl of deep fried chicken cutlet rice");
        Restaurant sm8 = new Restaurant("Sushi Mentai", null, "Hotate Toji Don", "https://sushi-mentai.com/zata_da/src/img/5d3e7946853625.50483770.jpg",
                12.80, "A bowl of scallop and egg rice");
        Restaurant sm9 = new Restaurant("Sushi Mentai", null, "Tempura Moriawase", "https://sushi-mentai.com/zata_da/src/img/5d381310c0edf6.66057610.jpg",
                13.80, "Includes pieces of lightly battered and deep fried seafood and vegetables");
        Restaurant sm10 = new Restaurant("Sushi Mentai", null, "Shiro Maguro", "https://sushi-mentai.com/zata_da/src/img/5d3e9336710272.23065637.jpg",
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
        Restaurant dm1 = new Restaurant("Domino's Pizza", "https://upload.wikimedia.org/wikipedia/commons/thumb/3/3e/Domino%27s_pizza_logo.svg/120px-Domino%27s_pizza_logo.svg.png",
                "Chicken Confidential Pizza", "https://cache.dominos.com/wam/prod/market/MY/_en/images/promo/2fa33079-fa12-46a6-9a8b-327a296ba38e.jpg",
                37.80, "Includes onions, cherry tomatoes, pineapple, chicken potpourri, roasted chicken and shredded chicken with Domino's top secret sauce");
        Restaurant dm2 = new Restaurant("Domino's Pizza", null, "Prawn Sensation Pizza", "https://cache.dominos.com/wam/prod/market/MY/_en/images/promo/e1e2ba74-7920-4d87-8d9a-4ba13390f68e.jpg",
                37.80, "Includes prawn marinated in Italian herbs and spices, spinach, cherry tomatoes, onion and Domino's new pizza sauce");
        Restaurant dm3 = new Restaurant("Domino's Pizza", null, "Ultimate Hawaiian Pizza", "https://cache.dominos.com/wam/prod/market/MY/_en/images/promo/e9986b7f-f9d8-4127-bd23-fd17885e6bf3.jpg",
                37.80, "Includes roasted chicken, shredded chicken, pineapples and mushrooms");
        Restaurant dm4 = new Restaurant("Domino's Pizza", null, "Classic Chicken Pizza", "https://cache.dominos.com/wam/prod/market/MY/_en/images/promo/ba2c294c-4c3b-4769-a5c6-ce6d8ddc6a21.jpg",
                35.80, "Includes shredded onions, green pepper and ripe olives");
        Restaurant dm5 = new Restaurant("Domino's Pizza", null, "Meat Mania Pizza", "https://cache.dominos.com/wam/prod/market/MY/_en/images/promo/47859463-69a8-4797-993b-2f0b6d1d2915.jpg",
                35.80, "Includes beef pepperoni, beef sausages, ground beef, chicken potpourri sausages and ripe olives");
        Restaurant dm6 = new Restaurant("Domino's Pizza", null, "Flaming Tuna Pizza", "https://cache.dominos.com/wam/prod/market/MY/_en/images/promo/bbedf623-cb51-4fb8-95c3-5410ee0de31f.jpg",
                31.90, "Includes tuna chunks, fresh onions, chilies");
        Restaurant dm7 = new Restaurant("Domino's Pizza", null, "Chicken Wings Hot & Spicy", "https://cache.dominos.com/wam/prod/market/MY/_en/images/promo/6a9c8ebb-53f0-4000-a867-ea889d8f09c4.jpg",
                15.90, "Chicken wings covered in hot & spicy sauce");
        Restaurant dm8 = new Restaurant("Domino's Pizza", null, "Roasted Chicken Drummets", "https://cache.dominos.com/olo/6_93_4/assets/build/market/MY/_en/images/img/products/thumbnails/S_RCD.jpg",
                15.90, "Chicken drummet marinated in dried oregano, black pepper and garlic");
        Restaurant dm9 = new Restaurant("Domino's Pizza", null, "Chicken Lasagna", "https://cache.dominos.com/wam/prod/market/MY/_en/images/promo/a83f2490-1f7c-424b-a3c3-3041297c374f.jpg",
                15.50, "This is a hot & saucy lasagna stuffed with layers of meat sauce and mozzarella cheese");
        Restaurant dm10 = new Restaurant("Domino's Pizza", null, "Spaghetti Bolognese Chicken", "https://cache.dominos.com/wam/prod/market/MY/_en/images/promo/f1ccfbea-2855-4bfb-bc7c-5701a17d76eb.jpg",
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