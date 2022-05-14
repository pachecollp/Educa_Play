package com.paquete.educaplay.ui.prueba;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class pruebaVM extends ViewModel {

    private final MutableLiveData<String> mText;

    public pruebaVM() {
        mText = new MutableLiveData<>();
        mText.setValue("This is prueba fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}