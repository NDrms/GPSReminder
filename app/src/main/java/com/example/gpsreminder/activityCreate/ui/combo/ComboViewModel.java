package com.example.gpsreminder.activityCreate.ui.combo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ComboViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ComboViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Это главный фрагмент");
    }

    public LiveData<String> getText() {
        return mText;
    }
}