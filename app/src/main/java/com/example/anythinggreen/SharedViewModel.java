package com.example.anythinggreen;

import android.graphics.Bitmap;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    // Setting fields such as classification and imageClassified to final prevent the data to be updated when user picks another image

    // Create a MutableLiveData<String> classification to be observe in fragments
    private MutableLiveData<String> classification = new MutableLiveData<>();

    // Method to set Classification on ViewModel SharedViewModel to be used after classifying image
    public void setClassification(String value){
        classification.setValue(value);
    }

    // Retrieves classification value from ViewModel SharedViewModel
    public LiveData<String> getClassification(){
        return classification;
    }

    // Create a MutableLiveData<Bitmap> imageClassified to be observe in fragments
    private MutableLiveData<Bitmap> imageClassified = new MutableLiveData<>();

    // Method to set imageClassified on ViewModel SharedViewModel to be used after classifying image
    public void setImageClassified(Bitmap bitmap) {
        imageClassified.setValue(bitmap);
    }

    // Retrieves imageClassified value from ViewModel SharedViewModel
    public LiveData<Bitmap> getImageClassified() {
        return imageClassified;
    }
}
