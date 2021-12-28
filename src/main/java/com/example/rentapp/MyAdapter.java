package com.example.rentapp;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentapp.databinding.CarItemBinding;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.CarHolder> {

    private List<Car> cars = new ArrayList<>();


    void updateData(List<Car> newCars) {
        cars = newCars;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CarHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CarItemBinding itemBinding = CarItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CarHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull CarHolder holder, int position) {
        holder.bind(cars.get(position));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }

    class CarHolder extends RecyclerView.ViewHolder {

        CarItemBinding itemBinding;

        public CarHolder(CarItemBinding binding) {
            super(binding.getRoot());
            itemBinding = binding;
        }

        void bind(Car car) {
            itemBinding.brandTv.setText(car.brand);
            itemBinding.modelTv.setText(car.model);
            itemBinding.typeTv.setText("Тип: " + car.carType);
            itemBinding.dailyCostTv.setText(car.dailyCost + " руб.");
            itemBinding.rentalServiceTv.setText(car.rentalService);
        }
    }

}

