package com.example.foodorderingapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterFragment extends Fragment {

    EditText username, email, password;
    Button registerButton, haveAccButton;
    UserDBModel userModel;
    String userInput, emailInput, passwordInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_register, container, false);

        username = v.findViewById(R.id.username);
        email = v.findViewById(R.id.email);
        password = v.findViewById(R.id.password);
        registerButton = v.findViewById(R.id.registerButton);
        haveAccButton = v.findViewById(R.id.haveAccButton);
        userModel = new UserDBModel();
        userModel.load(getActivity());

        userInput = username.getText().toString();
        emailInput = email.getText().toString();
        passwordInput = password.getText().toString();

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TextUtils.isEmpty(userInput) || TextUtils.isEmpty(emailInput) || TextUtils.isEmpty(passwordInput))
                {
                    Toast.makeText(getActivity(), "Inputs cannot be blank", Toast.LENGTH_SHORT).show();

                }
                else
                {
                    //there is not user in the database
                    if(!userModel.checkUsername(userInput))
                    {
                        User user = new User(userInput, emailInput, passwordInput);
                        userModel.addUser(user);
                        Toast.makeText(getActivity(), "Registered successfully", Toast.LENGTH_SHORT).show();
                    }
                    else //user exist
                    {
                        Toast.makeText(getActivity(), "User existed", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });

        haveAccButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, new LoginFragment());
                ft.commit();
            }
        });

        return v;
    }


}