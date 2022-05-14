package com.paquete.educaplay.ui.prueba;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.paquete.educaplay.databinding.FragmentModificacionesBinding;
import com.paquete.educaplay.databinding.FragmentPruebaBinding;

public class pruebaFragment extends Fragment {

    private FragmentPruebaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pruebaVM PruebaVM =
                new ViewModelProvider(this).get(pruebaVM.class);

        binding = FragmentPruebaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPrueba;
        PruebaVM.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}