package com.paquete.educaplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void estudiante(View view){
        Intent regis = new Intent(this, Iniciar_estudiante.class);
        startActivity(regis);
    }
    public void admins(View view){
        Intent regis = new Intent(this, registrar_admin.class);
        startActivity(regis);
    }


}