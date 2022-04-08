package com.paquete.educaplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Iniciar_estudiante extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_estudiante);
    }

    public void iniciobuscar(View view){
        Intent bus = new Intent(this, buscar_estudiante.class);
        startActivity(bus);
    }
}