package com.paquete.educaplay.ui.modificaciones;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class modificacionesVM extends ViewModel {

    private final MutableLiveData<String> mText;

    public modificacionesVM() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}