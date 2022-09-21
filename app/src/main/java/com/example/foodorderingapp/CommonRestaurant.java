package com.example.foodorderingapp;

import java.util.ArrayList;

public class CommonRestaurant {

    ArrayList<Restaurant> kfc;
    ArrayList<Restaurant> mcd;
    ArrayList<Restaurant> pizzaHut;
    ArrayList<Restaurant> subway;
    ArrayList<Restaurant> nando;
    ArrayList<Restaurant> sushiKing;
    ArrayList<Restaurant> sugarbun;
    ArrayList<Restaurant> marrybrown;
    ArrayList<Restaurant> sushiMentai;
    ArrayList<Restaurant> domino;

    public CommonRestaurant(ArrayList<Restaurant> kfc, ArrayList<Restaurant> mcd,
                            ArrayList<Restaurant> pizzaHut, ArrayList<Restaurant> subway,
                            ArrayList<Restaurant> nando, ArrayList<Restaurant> sushiKing,
                            ArrayList<Restaurant> sugarbun, ArrayList<Restaurant> marrybrown,
                            ArrayList<Restaurant> sushiMentai, ArrayList<Restaurant> domino)
    {
        this.kfc = kfc;
        this.mcd = mcd;
        this.pizzaHut = pizzaHut;
        this.subway = subway;
        this.nando = nando;
        this.sushiKing = sushiKing;
        this.sugarbun = sugarbun;
        this.marrybrown = marrybrown;
        this.sushiMentai = sushiMentai;
        this.domino = domino;
    }

    public ArrayList<Restaurant> getKfc()
    {
        return kfc;
    }

    public ArrayList<Restaurant> getMcd()
    {
        return mcd;
    }

    public ArrayList<Restaurant> getPizzaHut()
    {
        return pizzaHut;
    }

    public ArrayList<Restaurant> getSubway()
    {
        return subway;
    }

    public ArrayList<Restaurant> getNando()
    {
        return nando;
    }

    public ArrayList<Restaurant> getSushiKing()
    {
        return sushiKing;
    }

    public ArrayList<Restaurant> getSugarbun()
    {
        return sugarbun;
    }

    public ArrayList<Restaurant> getMarrybrown()
    {
        return marrybrown;
    }

    public ArrayList<Restaurant> getSushiMentai()
    {
        return sushiMentai;
    }

    public ArrayList<Restaurant> getDomino()
    {
        return domino;
    }
}
