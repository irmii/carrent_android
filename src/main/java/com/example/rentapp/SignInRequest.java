package com.example.rentapp;


import com.google.gson.annotations.SerializedName;

public class SignInRequest {
    @SerializedName("username")
    private String userName;
    private String password;

    SignInRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
