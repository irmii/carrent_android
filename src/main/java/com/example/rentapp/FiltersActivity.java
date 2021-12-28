package com.example.rentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.rentapp.databinding.ActivityFiltersBinding;
import com.example.rentapp.databinding.ActivityMainBinding;
import com.example.rentapp.databinding.ActivityProfileBinding;

import java.util.Arrays;
import java.util.List;


public class FiltersActivity extends AppCompatActivity {

    static final int RESULT_CODE = 228;
    static final String TYPE_DATA = "type_data";

    private ActivityFiltersBinding binding;

    private int type = 1;
    private List<String> types = Arrays.asList("Легковая", "Лимузин", "Грузовой", "Мотоцикл", "Мопед", "Спортивня");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFiltersBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.confirmBtn.setOnClickListener(view1 -> {
            setResult(RESULT_CODE, new Intent().putExtra(TYPE_DATA, type));
            finish();
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, types);
        binding.typeSr.setAdapter(adapter);
        binding.typeSr.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position) {
                    case 0:
                        type = 1;
                        break;
                    case 1:
                        type = 2;
                        break;
                    case 2:
                        type = 3;
                        break;
                    case 3:
                        type = 4;
                        break;
                    case 4:
                        type = 5;
                        break;
                    case 5:
                        type = 6;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


}
