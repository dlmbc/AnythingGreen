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

        // Observe changes MutableLiveData<String> classification
        viewModel.getClassification().observe(getViewLifecycleOwner(), value -> {
            // Store value to String material
            material = value;
            // Set String material as text to material_type TextView
            material_type.setText(material);
            // Provide information about material type
            provideInformation();
        });

        // Observe changes MutableLiveData<Bitmap> imageClassified
        viewModel.getImageClassified().observe(getViewLifecycleOwner(), bitmap -> {
            // Set Bitmap bitmap as material_img ImageView
            material_img.setImageBitmap(bitmap);
        });
    }

    private void provideInformation() {
        // If material is plastic
        switch (material) {
            case "Plastic":
                years.setText("450 years");
                made_of.setText("polythylene terephthalat");
                recycle_ways.setText("1. Leave the caps on" + "\n" +
                        "2. Crush your bottle" + "\n" +
                        "3. No need to rinse" + "\n" +
                        "4. Don't bag 'em");
                mat_desc.setText("Billions of water bottles are used every year throughout the world.");
                break;

            // If material is e-waste
            case "E-waste":
                years.setText("450 years");
                made_of.setText("polythylene terephthalat");
                recycle_ways.setText("1. Leave the caps on" + "\n" +
                        "2. Crush your bottle" + "\n" +
                        "3. No need to rinse" + "\n" +
                        "4. Don't bag 'em");
                mat_desc.setText("Billions of water bottles are used every year throughout the world.");
                break;

            // If material is glass
            case "Glass":
                years.setText("450 years");
                made_of.setText("polythylene terephthalat");
                recycle_ways.setText("1. Leave the caps on" + "\n" +
                        "2. Crush your bottle" + "\n" +
                        "3. No need to rinse" + "\n" +
                        "4. Don't bag 'em");
                mat_desc.setText("Billions of water bottles are used every year throughout the world.");
                break;

            // If material is metal
            case "Metal":
                years.setText("450 years");
                made_of.setText("polythylene terephthalat");
                recycle_ways.setText("1. Leave the caps on" + "\n" +
                        "2. Crush your bottle" + "\n" +
                        "3. No need to rinse" + "\n" +
                        "4. Don't bag 'em");
                mat_desc.setText("Billions of water bottles are used every year throughout the world.");
                break;

            // If material is paper
            case "Paper":
                years.setText("450 years");
                made_of.setText("polythylene terephthalat");
                recycle_ways.setText("1. Leave the caps on" + "\n" +
                        "2. Crush your bottle" + "\n" +
                        "3. No need to rinse" + "\n" +
                        "4. Don't bag 'em");
                mat_desc.setText("Billions of water bottles are used every year throughout the world.");
                break;

            // If material is clothes
            case "Clothes":
                years.setText("450 years");
                made_of.setText("polythylene terephthalat");
                recycle_ways.setText("1. Leave the caps on" + "\n" +
                        "2. Crush your bottle" + "\n" +
                        "3. No need to rinse" + "\n" +
                        "4. Don't bag 'em");
                mat_desc.setText("Billions of water bottles are used every year throughout the world.");
                break;

            // If material is non-recyclable
            default:
                // do something if material is something else
                break;
        }
    }
}