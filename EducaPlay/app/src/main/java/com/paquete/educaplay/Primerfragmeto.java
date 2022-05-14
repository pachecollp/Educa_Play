package com.paquete.educaplay;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Primerfragmeto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Primerfragmeto extends Fragment {

    public Primerfragmeto() {
        // Required empty public constructor
    }

    public static Primerfragmeto newInstance() {

        Bundle args = new Bundle();

        Primerfragmeto fragment = new Primerfragmeto();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_primerfragmeto, container, false);
    }
}