package com.example.rentapp;

import androidx.annotation.Nullable;

import java.util.List;

import io.reactivex.rxjava3.core.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Repository {
    // Отвечает за сетевое взаимодействие
    private static final String BASE_URL = "http://petme.petme.company/";
    public static final Repository INSTANCE = new Repository(); // статическое поле, получаем данный инстанс при каждой обработке страницы

    private final RentApi api; // методы вызова апи
    private String token;

    Repository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(RentApi.class);
    } // класс, чтобы ходить в сеть, билдер для запросов

    Single<SignInResponse> signIn(String userName, String password) {
        return api.signIn(new SignInRequest(userName, password)).doOnSuccess(signInResponse -> {
            token = signInResponse.token;
        });
    } // возвращает поток с ответом

    Single<List<Car>> getCars(Integer type) {
        return api.getCars(type, "Token " + token);
    }
}
