package com.example.anythinggreen;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoFragment extends Fragment {

    ImageView material_img;
    TextView material_type, years, made_of, recycle_ways, mat_desc;
    String material;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        material_img = view.findViewById(R.id.material_img);
        material_type = view.findViewById(R.id.material_type);
        years = view.findViewById(R.id.years);
        made_of = view.findViewById(R.id.made_of);
        recycle_ways = view.findViewById(R.id.recycle_ways);
        mat_desc = view.findViewById(R.id.mat_desc);

        return view;
    }

    // Use the onViewCreated method to initialize the TextView and observe the value of the TextView as it is ran after view is created
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Get a reference to the view model
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        viewModel.getClassification().observe(getViewLifecycleOwner(), value -> {
            // Store value to String material
            material = value;
            // Set String material as text to material_type TextView
            material_type.setText(material);
        });
    }
}