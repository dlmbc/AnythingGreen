package com.example.anythinggreen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

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
}
