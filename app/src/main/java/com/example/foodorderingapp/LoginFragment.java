package com.example.foodorderingapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class LoginFragment extends Fragment {

    EditText username, password;
    Button login;
    UserDBModel userModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        username = v.findViewById(R.id.username2);
        password = v.findViewById(R.id.password2);
        login = v. findViewById(R.id.loginButton);
        userModel = new UserDBModel();
        userModel.load(getActivity());
        Bundle bundle = this.getArguments();
        CommonFragments data =  bundle.getParcelable("frag");;

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String userInput = username.getText().toString();
                String passwordInput = password.getText().toString();

                if(TextUtils.isEmpty(userInput) || TextUtils.isEmpty(passwordInput))
                {
                    Toast.makeText(getActivity(), "Inputs cannot be blank", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    //if user not in the database
                    if(!userModel.checkUsername(userInput))
                    {
                       Toast.makeText(getActivity(), "Invalid Account", Toast.LENGTH_SHORT).show();
                       username.getText().clear();
                       password.getText().clear();
                    }
                    else //user exist
                    {
                        username.getText().clear();
                        password.getText().clear();

                        //if username and password is correct
                        if(userModel.checkUsernamePassword(userInput, passwordInput)) {

                            Toast.makeText(getActivity(), "Welcome " + userInput, Toast.LENGTH_SHORT).show();
                            data.setUsername(userInput);
                            bundle.putString("username", userInput);
                            UserFragment uf = data.getUserFragment();
                            uf.setArguments(bundle);
                            FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                            ft.replace(R.id.frameLayout, uf);
                            ft.commit();
                            data.setLogin(true);
                        }
                        else
                        {
                            Toast.makeText(getActivity(), "Wrong password for " + userInput, Toast.LENGTH_SHORT).show();
                        }

                    }
                }
            }
        });


        return v;
    }
}