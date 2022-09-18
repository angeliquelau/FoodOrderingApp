package com.example.foodorderingapp;

import android.os.Parcel;
import android.os.Parcelable;

public class CommonFragments implements Parcelable {

    MenuFragment mf;
    RegisterFragment rf;
    LoginFragment lf;
    UserFragment uf;
    OrderFragment of;
    CartFragment cf;
    boolean login;

    public CommonFragments(MenuFragment mf, RegisterFragment rf, LoginFragment lf, UserFragment uf,
                           OrderFragment of, CartFragment cf, boolean login)

    {
        this.mf = mf;
        this.rf = rf;
        this.lf = lf;
        this.uf = uf;
        this.of = of;
        this.cf = cf;
        this.login = login;
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

    public MenuFragment getMenuFragment()
    {
        return mf;
    }

    public CartFragment getCartFragment()
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
