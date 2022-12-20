package com.example.anythinggreen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoFragment extends Fragment {

    ImageView material_img;
    TextView material_type, years, made_of, recycle_ways, mat_desc;

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
}