package com.example.rentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rentapp.databinding.ActivityMainBinding;
import com.example.rentapp.databinding.ActivityProfileBinding;

import io.reactivex.rxjava3.disposables.Disposable;

public class ProfileActivity extends AppCompatActivity {

    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.myRequestsBtn.setOnClickListener( click  -> {
        });
        binding.chooseCarBtn.setOnClickListener( click  -> {
            startActivity(new Intent(this, CarsListActivity.class));
        });
    }
}
