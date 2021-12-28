package com.example.rentapp;

import com.google.gson.annotations.SerializedName;

public class SignInResponse {
    @SerializedName("auth_token")
    String token;

    public SignInResponse(String token) {
        this.token = token;
    }
}
