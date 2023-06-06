package com.example.anythinggreen;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;

public class RewardsFragment extends Fragment {

    TextView total_trash;
    Integer clothes_counter, trash_counter, ewaste_counter, glass_counter,
            metal_counter, paper_counter, plastic_counter;
    String material;

    PieChart pieChart;

    // Setting up Locale
    Locale us = Locale.US;
    // Formatting counters to decimal format
    DecimalFormatSymbols symbols = new DecimalFormatSymbols(us);
    DecimalFormat decimalFormat = new DecimalFormat("#,##0", symbols);


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Load the previous count of the trash
        trash_counter = PrefConfig.loadTotalTrashFromPref(getActivity().getApplicationContext());
        clothes_counter = PrefConfig.loadTotalClothesFromPref(getActivity().getApplicationContext());
        ewaste_counter = PrefConfig.loadTotalEwasteFromPref(getActivity().getApplicationContext());
        paper_counter = PrefConfig.loadTotalPaperFromPref(getActivity().getApplicationContext());
        plastic_counter = PrefConfig.loadTotalPlasticFromPref(getActivity().getApplicationContext());
        glass_counter = PrefConfig.loadTotalGlassFromPref(getActivity().getApplicationContext());
        metal_counter = PrefConfig.loadTotalMetalFromPref(getActivity().getApplicationContext());
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_rewards, container, false);

        total_trash = view.findViewById(R.id.total_trash);
        pieChart = view.findViewById(R.id.pieChart);

        showPieChart();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);
        // Get a reference to the view model
        SharedViewModel viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        // Format the counters and set the textview to the formatted counters
        String formattedTrashCounter = decimalFormat.format(trash_counter);
        total_trash.setText(formattedTrashCounter);
        // Observe changes MutableLiveData<String> classification
        viewModel.getClassification().observe(getViewLifecycleOwner(), value -> {
            material = value;
            // If the material value is not equal to "Not Recyclable" update the counters
            if (!Objects.equals(material, "Not Recyclable")){
                trash_counter ++;
                // Save the counter after incrementing by one
                PrefConfig.saveTotalTrashInPref(getActivity().getApplicationContext(), trash_counter);
                String formattedTrashCounter2 = decimalFormat.format(trash_counter);
                total_trash.setText(formattedTrashCounter2);
            }
            updateRewards();
        });
    }

    private void showPieChart() {
        List<PieEntry> pieEntries = new ArrayList<>();
        // Add only non-zero entries to the pieEntries list
        if (clothes_counter != 0f) {
            pieEntries.add(new PieEntry(clothes_counter, "Clothes"));
        }
        if (ewaste_counter != 0f) {
            pieEntries.add(new PieEntry(ewaste_counter, "E-waste"));
        }
        if (glass_counter != 0f) {
            pieEntries.add(new PieEntry(glass_counter, "Glass"));
        }
        if (metal_counter != 0f) {
            pieEntries.add(new PieEntry(metal_counter, "Metal"));
        }
        if (paper_counter != 0f) {
            pieEntries.add(new PieEntry(paper_counter, "Paper"));
        }
        if (plastic_counter != 0f) {
            pieEntries.add(new PieEntry(plastic_counter, "Plastic"));
        }

        // Create the dataset for the pie chart
        PieDataSet dataSet = new PieDataSet(pieEntries, "");
        dataSet.setSliceSpace(2);

        // Modify center text
        pieChart.setCenterText("CONGRATS ON MAKING THE WORLD A BETTER PLACE");
        pieChart.setCenterTextSize(20f);
        pieChart.setCenterTextColor(getResources().getColor(R.color.neon_green));

        //Get colors from xml resource
        int[] colors = new int[] {getResources().getColor(R.color.one),
                getResources().getColor(R.color.two),
                getResources().getColor(R.color.three),
                getResources().getColor(R.color.four),
                getResources().getColor(R.color.five),
                getResources().getColor(R.color.six)};

        // Set the custom colors for the dataset
        dataSet.setColors(colors);
        dataSet.setValueTextSize(20f);
        dataSet.setValueFormatter(new ValueFormatter() {
            @SuppressLint("DefaultLocale")
            @Override
            public String getFormattedValue(float value) {
                return String.format("%.0f", value);
            }
        });

        // Description and legend
        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawEntryLabels(false);

        Legend legend = pieChart.getLegend();
        legend.setEnabled(true);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setTextColor(getResources().getColor(R.color.primary));
        legend.setTextSize(12);

        // Adjusting Pie chart radius and transparent circle
        pieChart.setHoleColor(Color.TRANSPARENT);
        pieChart.setTransparentCircleRadius(0f);

        // Stop dragging the chart
        pieChart.setRotationEnabled(false);

        // Create the pie data
        PieData pieData = new PieData(dataSet);

        // Set the data to the pie chart
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

    private void updateRewards() {

        // If material is plastic
        switch (material) {
            case "Plastic":
                plastic_counter ++;
                PrefConfig.saveTotalPlasticInPref(getActivity().getApplicationContext(), plastic_counter);
                showPieChart();
                break;

            // If material is e-waste
            case "E-waste":
                ewaste_counter ++;
                PrefConfig.saveTotalEwasteInPref(getActivity().getApplicationContext(), ewaste_counter);
                showPieChart();
                break;

            // If material is glass
            case "Glass":
                glass_counter ++;
                PrefConfig.saveTotalGlassInPref(getActivity().getApplicationContext(), glass_counter);
                showPieChart();
                break;

            // If material is metal
            case "Metal":
                metal_counter ++;
                PrefConfig.saveTotalMetalInPref(getActivity().getApplicationContext(), metal_counter);
                showPieChart();
                break;

            // If material is paper
            case "Paper":
                paper_counter ++;
                PrefConfig.saveTotalPaperInPref(getActivity().getApplicationContext(), paper_counter);
                showPieChart();
                break;

            // If material is clothes
            case "Clothes":
                clothes_counter ++;
                PrefConfig.saveTotalClothesInPref(getActivity().getApplicationContext(), clothes_counter);
                showPieChart();
                break;

            // If material is non-recyclable
            default:
                // do something if material is something else
                break;
        }
    }
}