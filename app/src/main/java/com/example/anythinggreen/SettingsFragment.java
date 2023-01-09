package com.example.anythinggreen;

import android.os.Bundle;

import androidx.annotation.NonNull;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SettingsFragment extends Fragment {

    TextView about_us, developers;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        about_us = view.findViewById(R.id.about_us);
        developers = view.findViewById(R.id.developers);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        about_us.setText("We are 4th-year computer engineering students from the Polytechnic University of the Philippines. This application is made in compliance with our project in Computer Engineering Practice and Design 1.");
        developers.setText("Chua, Stephen John P." + "\n" + "Delambaca, Erica O.");
    }
}