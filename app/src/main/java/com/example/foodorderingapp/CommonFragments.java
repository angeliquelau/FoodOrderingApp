package com.example.foodorderingapp;

import android.os.Parcel;
import android.os.Parcelable;

public class CommonFragments implements Parcelable {

    SpecialMenuBaseFragment smf;
    RestaurantRecycler rr;
    RegisterFragment rf;
    LoginFragment lf;
    UserFragment uf;
    OrderFragment of;
    CartRecycler cf;
    boolean login;
    String username;
    ResDBModel resDBModel;
    CartDBModel cartDBModel;
    FoodHistoryDBModel foodHistoryDBModel;

    public CommonFragments(SpecialMenuBaseFragment smf, RestaurantRecycler rr, RegisterFragment rf, LoginFragment lf, UserFragment uf,
                           OrderFragment of, CartRecycler cf, boolean login, ResDBModel resDBModel,
                           CartDBModel cartDBModel, FoodHistoryDBModel foodHistoryDBModel)

    {
        this.smf = smf;
        this.rr = rr;
        this.rf = rf;
        this.lf = lf;
        this.uf = uf;
        this.of = of;
        this.cf = cf;
        this.login = login;
        this.resDBModel = resDBModel;
        this.cartDBModel = cartDBModel;
        this.foodHistoryDBModel = foodHistoryDBModel;
        username = "none";
    }

    protected CommonFragments(Parcel in) {
        login = in.readByte() != 0;
    }

    public static final Creator<CommonFragments> CREATOR = new Creator<CommonFragments>() {
        @Override
        public CommonFragments createFromParcel(Parcel in) {
            return new CommonFragments(in);
        }

        @Override
        public CommonFragments[] newArray(int size) {
            return new CommonFragments[size];
        }
    };

    public SpecialMenuBaseFragment getMenuFragment()
    {
        return smf;
    }

    public RestaurantRecycler getRestaurantFragment() {return rr;}

    public CartRecycler getCartFragment()
    {
        return cf;
    }

    public RegisterFragment getRegisterFragment()
    {
        return rf;
    }

    public LoginFragment getLoginFragment()
    {
        return lf;
    }

    public UserFragment getUserFragment()
    {
        return uf;
    }

    public OrderFragment getOrderFragment(){return of; }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public ResDBModel getResDBModel() {return resDBModel;}

    public CartDBModel getCartDBModel() {return cartDBModel;}

    public FoodHistoryDBModel getFoodHistoryDBModel() {return foodHistoryDBModel;}

    public void setLogin(boolean status)
    {
        login = status;

    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (login ? 1 : 0));
    }
}
