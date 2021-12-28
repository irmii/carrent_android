package com.example.rentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.rentapp.databinding.ActivityMainBinding;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    //
    private final Repository repository = Repository.INSTANCE;
    private Disposable signInDisposable;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.loginBtn.setOnClickListener( click  -> {
            signIn();
        });
    }

    void signIn() {
        if (signInDisposable != null && !signInDisposable.isDisposed()) {
            signInDisposable.dispose();
        }
        signInDisposable = repository.signIn(binding.loginEt.getText().toString(), binding.passwordEt.getText().toString())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(signInResponse -> {
                    startActivity(new Intent(this, ProfileActivity.class));
                }, throwable -> {
                    Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        signInDisposable.dispose();
    }
}
