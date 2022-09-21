package com.example.foodorderingapp;

import com.example.foodorderingapp.R;

import java.util.ArrayList;

public class CommonData {

        CommonRestaurant cr;
        public CommonData(CommonRestaurant cr)
        {
            this.cr = cr;
        }

        //ResDBModel rdb = new ResDBModel();

        //ArrayList<Restaurant> res = rdb.getAlLRestaurant();
        //All restaurant list
        ArrayList<Restaurant> kfc = cr.getKfc();
        ArrayList<Restaurant> mcd = cr.getMcd();
        ArrayList<Restaurant> pizzaHut = cr.getPizzaHut();
        ArrayList<Restaurant> subway = cr.getSubway();
        ArrayList<Restaurant> nando = cr.getNando();
        ArrayList<Restaurant> sushiKing = cr.getSushiKing();
        ArrayList<Restaurant> sugarbun = cr.getSugarbun();
        ArrayList<Restaurant> marrybrown = cr.getMarrybrown();
        ArrayList<Restaurant> sushiMentai = cr.getSushiMentai();
        ArrayList<Restaurant> domino = cr.getDomino();

        //All images
        ArrayList<Integer> resImg = new ArrayList<>();
        ArrayList<Integer> kfcImg = new ArrayList<>();
        ArrayList<Integer> mcdImg = new ArrayList<>();
        ArrayList<Integer> pizzaHutImg = new ArrayList<>();
        ArrayList<Integer> subwayImg = new ArrayList<>();
        ArrayList<Integer> nandoImg = new ArrayList<>();
        ArrayList<Integer> sushiKingImg = new ArrayList<>();
        ArrayList<Integer> sugarbunImg = new ArrayList<>();
        ArrayList<Integer> marrybrownImg = new ArrayList<>();
        ArrayList<Integer> sushiMentaiImg = new ArrayList<>();
        ArrayList<Integer> dominoImg = new ArrayList<>();

        //ALl food names
        ArrayList<String> resName = new ArrayList<>();
        ArrayList<String> kfcName = new ArrayList<>();
        ArrayList<String> mcdName = new ArrayList<>();
        ArrayList<String> pizzaHutName = new ArrayList<>();
        ArrayList<String> subwayName = new ArrayList<>();
        ArrayList<String> nandoName = new ArrayList<>();
        ArrayList<String> sushiKingName = new ArrayList<>();
        ArrayList<String> sugarbunName = new ArrayList<>();
        ArrayList<String> marrybrownName = new ArrayList<>();
        ArrayList<String> sushiMentaiName = new ArrayList<>();
        ArrayList<String> dominoName = new ArrayList<>();

        //ALl food descriptions
        ArrayList<String> kfcDesc = new ArrayList<>();
        ArrayList<String> mcdDesc = new ArrayList<>();
        ArrayList<String> pizzaHutDesc = new ArrayList<>();
        ArrayList<String> subwayDesc = new ArrayList<>();
        ArrayList<String> nandoDesc = new ArrayList<>();
        ArrayList<String> sushiKingDesc = new ArrayList<>();
        ArrayList<String> sugarbunDesc = new ArrayList<>();
        ArrayList<String> marrybrownDesc = new ArrayList<>();
        ArrayList<String> sushiMentaiDesc = new ArrayList<>();
        ArrayList<String> dominoDesc = new ArrayList<>();

        public ArrayList<Integer> getResImg()
        {
            resImg.add(R.drawable.kfc);
            resImg.add(R.drawable.mcdonald_s_golden_arches_svg);
            resImg.add(R.drawable.pizzahut_logo);
            resImg.add(R.drawable.subway_2016_logo_svg);
            resImg.add(R.drawable.nandos_logo_svg);
            resImg.add(R.drawable.sklogo);
            resImg.add(R.drawable.sugarbun_logo);
            resImg.add(R.drawable.marrybrown_logo);
            resImg.add(R.drawable.sushimentai_logo);
            resImg.add(R.drawable.domino_s_pizza_logo_svg);

            return resImg;
        }

        public ArrayList<Integer> getKfcImg()
        {
            kfcImg.add(R.drawable.snacker_box_kfc);
            kfcImg.add(R.drawable.signature_box_classic_kfc);
            kfcImg.add(R.drawable.cheezy_twister_kfc);
            kfcImg.add(R.drawable.six_pc_nuggets_kfc);
            kfcImg.add(R.drawable.crispy_tenders_combo_a_kfc);
            kfcImg.add(R.drawable.fifteen_pc_chicken_kfc);
            kfcImg.add(R.drawable.one_pc_chicken_rice_sub);
            kfcImg.add(R.drawable.two_pc_rice_combo_kfc);
            kfcImg.add(R.drawable.dinner_plate_butterscotch_kfc);
            kfcImg.add(R.drawable.nine_pc_chicken_combo_kfc);

            return kfcImg;
        }

        public ArrayList<Integer> getMcdImg()
        {
            mcdImg.add(R.drawable.two_pc_ayam_goreng_spicy_mcd);
            mcdImg.add(R.drawable.three_pc_ag_regular_mcd);
            mcdImg.add(R.drawable.nine_pc_nuggets_mcd);
            mcdImg.add(R.drawable.nasi_lemak_b_mcd);
            mcdImg.add(R.drawable.bubur_ayam_mcd);
            mcdImg.add(R.drawable.quarter_pounder_mcd);
            mcdImg.add(R.drawable.double_cheeseburger_mcd);
            mcdImg.add(R.drawable.big_mac_mcd);
            mcdImg.add(R.drawable.gcb_mcd);
            mcdImg.add(R.drawable.filetofish_mcd);

            return mcdImg;
        }

        public ArrayList<Integer> getPizzaHutImg()
        {
            pizzaHutImg.add(R.drawable.blazing_seafood_ph);
            pizzaHutImg.add(R.drawable.chicken_supreme_ph);
            pizzaHutImg.add(R.drawable.hawaiian_supreme_ph);
            pizzaHutImg.add(R.drawable.beef_pep_ph);
            pizzaHutImg.add(R.drawable.veggie_lover_ph);
            pizzaHutImg.add(R.drawable.chicken_bolog_ph);
            pizzaHutImg.add(R.drawable.creamy_carbonara_ph);
            pizzaHutImg.add(R.drawable.aglio_olio_ph);
            pizzaHutImg.add(R.drawable.krispy_wings_ph);
            pizzaHutImg.add(R.drawable.soup_ph);

            return pizzaHutImg;
        }

        public ArrayList<Integer> getSubwayImg()
        {
            subwayImg.add(R.drawable.sandwich_slicedchicken_sub);
            subwayImg.add(R.drawable.sandwich_chicken_teriyaki_sub);
            subwayImg.add(R.drawable.sandwich_roasted_chicken_sub);
            subwayImg.add(R.drawable.sandwich_steakandcheese_sub);
            subwayImg.add(R.drawable.sandwich_subway_club_sub);
            subwayImg.add(R.drawable.sandwich_veggie_delite_sub);
            subwayImg.add(R.drawable.salads_spiral_chicken_slice_sub);
            subwayImg.add(R.drawable.salads_spiral_tuna_sub);
            subwayImg.add(R.drawable.salads_roast_beef_sub);
            subwayImg.add(R.drawable.sides_drinks_cookies_sub);


            return subwayImg;
        }

        public ArrayList<Integer> getNandoImg()
        {
            nandoImg.add(R.drawable.saucy_chicken_bowl_nandos);
            nandoImg.add(R.drawable.quad_chicken_wt_2_sides_nandos);
            nandoImg.add(R.drawable.sixteen_wingettes_and_drumettes_nandos);
            nandoImg.add(R.drawable.veggie_carnival_bowl_in_spicy_rice_nandos);
            nandoImg.add(R.drawable.dino_tenders_nandos);
            nandoImg.add(R.drawable.portobello_mushroom_wt_tofu_patty_burger_wt_1_sides_v2_to_green_nandos);
            nandoImg.add(R.drawable.portobello_mushroom_wt_tofu_patty_wrap_1_sides_v2_green_nandos);
            nandoImg.add(R.drawable.jumbo_platter_5_large_sides_nandos);
            nandoImg.add(R.drawable.po_tri_to_01_nandos);
            nandoImg.add(R.drawable.soup_only_v2_light_blue_nandos);

            return nandoImg;
        }

        public ArrayList<Integer> getSushiKingImg()
        {
            sushiKingImg.add(R.drawable.unagi_set_sk);
            sushiKingImg.add(R.drawable.tenpura_saba_set_sk);
            sushiKingImg.add(R.drawable.california_temaki_sk);
            sushiKingImg.add(R.drawable.soft_shell_crab_temaki_sk);
            sushiKingImg.add(R.drawable.norwegian_salmon_sashimi_sk);
            sushiKingImg.add(R.drawable.karaage_egg_salad_sk);
            sushiKingImg.add(R.drawable.chicken_gyoza_sk);
            sushiKingImg.add(R.drawable.oyako_don_sk);
            sushiKingImg.add(R.drawable.yakiniku_ebi_fry_bento_sk);
            sushiKingImg.add(R.drawable.salmon_belly_nanban_bento_sk);

            return sushiKingImg;
        }

        public ArrayList<Integer> getSugarbunImg()
        {
            sugarbunImg.add(R.drawable.broasted_chicken_2_sb);
            sugarbunImg.add(R.drawable.chic_mushroom_sb);
            sugarbunImg.add(R.drawable.asam_fish_head_1_sb);
            sugarbunImg.add(R.drawable.one_pc_chicken_rice_sub);
            sugarbunImg.add(R.drawable.fish_rice_sb);
            sugarbunImg.add(R.drawable.chicken_fish_rice_sb);
            sugarbunImg.add(R.drawable.sambal_eco_fish_2_sb);
            sugarbunImg.add(R.drawable.cheese_burger_sb);
            sugarbunImg.add(R.drawable.chicken_sandwich_sub);
            sugarbunImg.add(R.drawable.fish_burger_sub);

            return sugarbunImg;
        }

        public ArrayList<Integer> getMarrybrownImg()
        {
            marrybrownImg.add(R.drawable.cheesy_chicken_mashed_bowl_mb);
            marrybrownImg.add(R.drawable.seafood_bowl_mb);
            marrybrownImg.add(R.drawable.chicken_burger_combo_mb);
            marrybrownImg.add(R.drawable.hotouch_burger_mb);
            marrybrownImg.add(R.drawable.cheesy_burger_combo);
            marrybrownImg.add(R.drawable.lucky_plate_mb);
            marrybrownImg.add(R.drawable.cheesy_chicken_mb);
            marrybrownImg.add(R.drawable.jumbo_meal_mb);
            marrybrownImg.add(R.drawable.bubur_ayam_mcd);
            marrybrownImg.add(R.drawable.five_pcs_chicken_mb);

            return marrybrownImg;
        }

        public ArrayList<Integer> getSushiMentaiImg()
        {
            sushiMentaiImg.add(R.drawable.salmon_skin_maki_sm);
            sushiMentaiImg.add(R.drawable.salmon_mentai_dragon_maki_sm);
            sushiMentaiImg.add(R.drawable.inari_wrap_sm);
            sushiMentaiImg.add(R.drawable.kitsune_udon_sm);
            sushiMentaiImg.add(R.drawable.curry_udon_sm);
            sushiMentaiImg.add(R.drawable.zaru_soba_sm);
            sushiMentaiImg.add(R.drawable.tori_katsu_don_sm);
            sushiMentaiImg.add(R.drawable.hotate_toji_don_sm);
            sushiMentaiImg.add(R.drawable.tempura_moriawase_sm);
            sushiMentaiImg.add(R.drawable.shiro_maguro_sm);

            return sushiMentaiImg;
        }

        public ArrayList<Integer> getDominoImg()
        {
            dominoImg.add(R.drawable.chicken_confidential_pizza_dm);
            dominoImg.add(R.drawable.prawn_sensation_pizza_dm);
            dominoImg.add(R.drawable.ultimate_hawaiian_pizza_dm);
            dominoImg.add(R.drawable.classic_chicken_pizza_dm);
            dominoImg.add(R.drawable.meat_mania_pizza_dm);
            dominoImg.add(R.drawable.flaming_tuna_pizza_dm);
            dominoImg.add(R.drawable.wings_hot_and_spicy_dm);
            dominoImg.add(R.drawable.roasted_chicken_drummets_dm);
            dominoImg.add(R.drawable.chicken_lasagna_dm);
            dominoImg.add(R.drawable.spaghetti_bolog_dm);

            return dominoImg;
        }
/*
    public ArrayList<String> getResName()
    {
        for(int i = 0; i < 10; i++)
        {
            resName.add(res.get(i).getResName());
        }


        return resName;
    }
*/
    //Get restaurant food list
    public ArrayList<String> getKfcName()
    {
        for(int i = 0; i < 10; i++)
        {
            kfcName.add(kfc.get(i).getResFoodName());
        }
        return kfcName;
    }
/*
    public ArrayList<String> getMcdName()
    {
        for(int i = 0; i < res.size(); i++)
        {
            mcdName.add(mcd.get(i).getResFoodName());
        }
        return mcdName;
    }

    public ArrayList<String> getPizzaHutName()
    {
        for(int i = 0; i < res.size(); i++)
        {
            pizzaHutName.add(pizzaHut.get(i).getResFoodName());
        }
        return pizzaHutName;
    }

    public ArrayList<String> getSubwayName()
    {
        for(int i = 0; i < res.size(); i++)
        {
            subwayName.add(subway.get(i).getResFoodName());
        }
        return subwayName;
    }

    public ArrayList<String> getNandoName()
    {
        for(int i = 0; i < res.size(); i++)
        {
            nandoName.add(nando.get(i).getResFoodName());
        }
        return nandoName;

    }

    public ArrayList<String> getSushiKingName()
    {
        for(int i = 0; i < res.size(); i++)
        {
            sushiKingName.add(sushiKing.get(i).getResFoodName());
        }
        return sushiKingName;
    }

    public ArrayList<String> getSugarbunName()
    {
        for(int i = 0; i < res.size(); i++)
        {
            sugarbunName.add(sugarbun.get(i).getResFoodName());
        }
        return sugarbunName;
    }

    public ArrayList<String> getMarrybrownName()
    {
        for(int i = 0; i < res.size(); i++)
        {
            marrybrownName.add(marrybrown.get(i).getResFoodName());
        }
        return marrybrownName;
    }

    public ArrayList<String> getSushiMentaiName()
    {
        for(int i = 0; i < res.size(); i++)
        {
            sushiMentaiName.add(sushiMentai.get(i).getResFoodName());
        }
        return sushiMentaiName;
    }

    public ArrayList<String> getDominoName()
    {
        for(int i = 0; i < res.size(); i++)
        {
            dominoName.add(domino.get(i).getResFoodName());
        }
        return dominoName;
    }

    //restaurant food list ends

    //get restaurant food descriptions

    public ArrayList<String> getKfcDesc()
    {
        for(int i = 0; i < res.size(); i++)
        {
            kfcName.add(kfc.get(i).getResFoodDesc());
        }
        return kfcName;
    }

    public ArrayList<String> getMcdDesc()
    {
        for(int i = 0; i < res.size(); i++)
        {
            mcdName.add(mcd.get(i).getResFoodDesc());
        }
        return mcdName;
    }

    public ArrayList<String> getPizzaHutDesc()
    {
        for(int i = 0; i < res.size(); i++)
        {
            pizzaHutName.add(pizzaHut.get(i).getResFoodDesc());
        }
        return pizzaHutName;
    }

    public ArrayList<String> getSubwayDesc()
    {
        for(int i = 0; i < res.size(); i++)
        {
            subwayName.add(subway.get(i).getResFoodDesc());
        }
        return subwayName;
    }

    public ArrayList<String> getNandoDesc()
    {
        for(int i = 0; i < res.size(); i++)
        {
            nandoName.add(nando.get(i).getResFoodDesc());
        }
        return nandoName;

    }

    public ArrayList<String> getSushiKingDesc()
    {
        for(int i = 0; i < res.size(); i++)
        {
            sushiKingName.add(sushiKing.get(i).getResFoodDesc());
        }
        return sushiKingName;
    }

    public ArrayList<String> getSugarbunDesc()
    {
        for(int i = 0; i < res.size(); i++)
        {
            sugarbunName.add(sugarbun.get(i).getResFoodDesc());
        }
        return sugarbunName;
    }

    public ArrayList<String> getMarrybrownDesc()
    {
        for(int i = 0; i < res.size(); i++)
        {
            marrybrownName.add(marrybrown.get(i).getResFoodDesc());
        }
        return marrybrownName;
    }

    public ArrayList<String> getSushiMentaiDesc()
    {
        for(int i = 0; i < res.size(); i++)
        {
            sushiMentaiName.add(sushiMentai.get(i).getResFoodDesc());
        }
        return sushiMentaiName;
    }

    public ArrayList<String> getDominoDesc()
    {
        for(int i = 0; i < res.size(); i++)
        {
            dominoName.add(domino.get(i).getResFoodDesc());
        }
        return dominoName;
    }

*/


}
