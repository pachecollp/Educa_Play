package com.paquete.educaplay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.paquete.educaplay.databinding.ActivityMainBinding;

public class prueba1 extends AppCompatActivity {

    ActivityMainBinding binding;

    private BottomNavigationView bnvMenu;
    private Fragment fragment;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.

    }

    private void initView(){
        bnvMenu = findViewById(R.id.bnvMenu);
    }

    private void initValues(){
        manager = getSupportFragmentManager();
    }

    private void initListener(){
        bnvMenu.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                int idMenu = item.getItemId();
                switch (idMenu){
                    case R.id.menu_home:
                        return true;
                    case R.id.menu_pruebas:
                        return true;
                    case R.id.menu_notas:
                        return true;

                }
                return false;

            }
        });
    }


}