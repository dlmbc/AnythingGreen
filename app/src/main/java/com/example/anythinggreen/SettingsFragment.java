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

    TextView user_guide, about_us, developers;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        user_guide = view.findViewById(R.id.user_guide);
        about_us = view.findViewById(R.id.about_us);
        developers = view.findViewById(R.id.developers);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        user_guide.setText("After opening you will see a \"Take Picture\" button and \"Launch Gallery\" button, you can choose take picture to use your phone camera and scan the trash that you want to recycle or upload a photo from the gallery. (If you're using the app for the first time, you might get a prompt asking you to allow the app to use your camera, click yes \"Allow while using the app\"). Below those options are other pages such as the Information page where the app will show some info about the material you captured and how to recycle them.  The third page is the rewards page. You will see the number of trash you have recycled in total and also individually by type. The last page is the settings page, where there is a user guide and some information about the developers.\n" +
                "\n" +
                "Please note that the application is currently in beta, and inaccuracies to some degree are expected. Nevertheless, we do hope that it will be useful to your recycling journey. Don't hesitate to ask us anything about the installation or the app function. Thank you!");
        about_us.setText("We are 4th-year computer engineering students from the Polytechnic University of the Philippines. This application is made in compliance with our project in Computer Engineering Practice and Design.");
        developers.setText("Chua, Stephen John P." + "\n" + "Delambaca, Erica O.");
    }
}