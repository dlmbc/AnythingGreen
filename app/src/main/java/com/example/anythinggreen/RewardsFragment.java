package com.example.anythinggreen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Objects;

public class RewardsFragment extends Fragment {

    TextView total_trash,total_clothes,total_ewaste,total_glass,total_metal,total_paper,total_plastic;
    Integer trash_counter = 0,clothes_counter = 0,ewaste_counter= 0, glass_counter = 0,
            metal_counter = 0,paper_counter = 0, plastic_counter= 0;
    String material;
    // Setting up Locale
    Locale us = Locale.US;
    // Formatting counters to decimal format
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(us);
    DecimalFormat decimalFormat = new DecimalFormat("#,##0", symbols);

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rewards, container, false);

        total_trash = view.findViewById(R.id.total_trash);
        total_clothes = view.findViewById(R.id.total_clothes);
        total_ewaste = view.findViewById(R.id.total_ewaste);
        total_glass = view.findViewById(R.id.total_glass);
        total_metal = view.findViewById(R.id.total_metal);
        total_paper = view.findViewById(R.id.total_paper);
        total_plastic = view.findViewById(R.id.total_plastic);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get a reference to the view model
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        // Observe changes MutableLiveData<String> classification
        viewModel.getClassification().observe(getViewLifecycleOwner(), value -> {
            material = value;
            // If the material value is not equal to "Not Recyclable" update the counters
            if (!Objects.equals(material, "Not Recyclable")){
                trash_counter ++;
                String formattedTrashCounter = decimalFormat.format(trash_counter);
                total_trash.setText(formattedTrashCounter);
            }
            updateRewards();
        });
    }

    private void updateRewards() {
        // If material is plastic
        switch (material) {
            case "Plastic":
                plastic_counter ++;
                String formattedPlasticCounter = decimalFormat.format(plastic_counter);
                total_plastic.setText(formattedPlasticCounter);
                break;

            // If material is e-waste
            case "E-waste":
                ewaste_counter ++;
                String formattedEwasteCounter = decimalFormat.format(ewaste_counter);
                total_ewaste.setText(formattedEwasteCounter);
                break;

            // If material is glass
            case "Glass":
                glass_counter ++;
                String formattedGlassCounter = decimalFormat.format(glass_counter);
                total_glass.setText(formattedGlassCounter);
                break;

            // If material is metal
            case "Metal":
                metal_counter ++;
                String formattedMetalCounter = decimalFormat.format(metal_counter);
                total_metal.setText(formattedMetalCounter);
                break;

            // If material is paper
            case "Paper":
                paper_counter ++;
                String formattedPaperCounter = decimalFormat.format(paper_counter);
                total_paper.setText(formattedPaperCounter);
                break;

            // If material is clothes
            case "Clothes":
                clothes_counter ++;
                String formattedClothesCounter = decimalFormat.format(clothes_counter);
                total_clothes.setText(formattedClothesCounter);
                break;

            // If material is non-recyclable
            default:
                // do something if material is something else
                break;
        }
    }
}