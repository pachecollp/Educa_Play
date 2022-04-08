package com.paquete.educaplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Iniciar_estudiante extends AppCompatActivity {
    EditText usuario, contraseña;
    Button iniciar_sesion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_estudiante);
        usuario = (EditText) findViewById(R.id.usuario_estudiante1);
        contraseña = (EditText) findViewById(R.id.contraseña_estudiante1);
        iniciar_sesion = (Button) findViewById(R.id.btniniciarestudi);
        iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //enviar(nombreusuario);
               // new Iniciar_estudiante.checkLogin().execute("");
                finish();
            }
        });
    }

    public void iniciobuscar(View view){
        Intent bus = new Intent(this, buscar_estudiante.class);
        startActivity(bus);
    }
}