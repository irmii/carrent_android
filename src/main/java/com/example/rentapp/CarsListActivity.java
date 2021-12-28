package com.example.rentapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.rentapp.databinding.ActivityCarsListBinding;


import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CarsListActivity extends AppCompatActivity {

    private final Repository repository = Repository.INSTANCE;

    private Disposable carsDisposable;

    private ActivityCarsListBinding binding;
    private MyAdapter adapter;
    private Integer type = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCarsListBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.filtersBtn.setOnClickListener(view1 -> startActivityForResult(new Intent(CarsListActivity.this, FiltersActivity.class), 1234));
        adapter = new MyAdapter();
        binding.carsRv.setAdapter(adapter);

        if (carsDisposable != null && !carsDisposable.isDisposed()) {
            carsDisposable.dispose();
        }
        getCars();
    }

    private void getCars() {
        carsDisposable = repository.getCars(type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(cars -> {
                    adapter.updateData(cars);
                }, throwable -> {
                    Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode) {
            case FiltersActivity.RESULT_CODE:
                type = data.getIntExtra(FiltersActivity.TYPE_DATA, 1);
                getCars();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        carsDisposable.dispose();
    }
}
