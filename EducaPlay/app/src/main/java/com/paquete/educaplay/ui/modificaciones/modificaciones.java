package com.paquete.educaplay.ui.modificaciones;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.paquete.educaplay.databinding.FragmentHomeBinding;
import com.paquete.educaplay.databinding.FragmentModificacionesBinding;

public class modificaciones extends Fragment {

    private FragmentModificacionesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        modificacionesVM ModificacionesVM =
                new ViewModelProvider(this).get(modificacionesVM.class);

        binding = FragmentModificacionesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textModificaciones;
        ModificacionesVM.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}