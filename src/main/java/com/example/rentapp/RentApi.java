package com.example.rentapp;


import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RentApi {

    @POST("/auth-authtoken/token/login/")
    Single<SignInResponse> signIn(@Body SignInRequest body); // возвращает один объект

    @GET("/api/cars/")
    Single<List<Car>> getCars(@Query("car_type") Integer type, @Header("Authorization") String token);
}
