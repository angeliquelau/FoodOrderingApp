package com.example.foodorderingapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class UserFragment extends Fragment {

    EditText username, email, password;
    String name;
    TextView outputName;
    Button logout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user, container, false);

        outputName = v.findViewById(R.id.userDisplay);
        logout = v.findViewById(R.id.logoutButton);

        Bundle bundle = this.getArguments();
        name = bundle.getString("username");
        Log.i("User", name);
        outputName.setText(name);

        CommonFragments data = bundle.getParcelable("frag");
        CartDBModel cartDBModel = data.getCartDBModel();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, data.getRegisterFragment());
                ft.commit();
                data.setUsername("none");
                cartDBModel.updateUsername(name, "none");
                data.setLogin(false);

            }
        });

        return v;
    }
}