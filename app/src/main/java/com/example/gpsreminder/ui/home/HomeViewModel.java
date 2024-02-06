package com.example.gpsreminder.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("🔔Здесь появятся ваши напоминания🔔");
    }

    public LiveData<String> getText() {
        return mText;
    }
}