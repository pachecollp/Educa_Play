package com.paquete.educaplay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class registrar_estudiante extends AppCompatActivity {
    EditText nom, ape, correo, cod, contr;
    Button btnregistrarse;
    String pasarusu;
    View img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_estudiante);
        nom = (EditText) findViewById(R.id.nombre_estudiante);
        ape = (EditText) findViewById(R.id.apellido_estudiante);
        correo = (EditText) findViewById(R.id.correo_estudiante);
        cod = (EditText) findViewById(R.id.codigo_estudiante);
        contr = (EditText) findViewById(R.id.contraseña_estudiante);
        btnregistrarse = (Button) findViewById(R.id.btnregistro);
        img = (View)findViewById(R.id.img);
        pasarusu = correo.getText().toString().trim();
        btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //agregarusuario();
                Intent intent = new Intent(registrar_estudiante.this, Iniciar_estudiante.class);
                //intent.putExtra("usu",pasarusu);
                startActivity(intent);
                finish();
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("nombre :", String.valueOf("2"));
            }
        });
    }

    public void registrarse(View view){
        Intent inic = new Intent(this,Iniciar_estudiante.class);
        startActivity(inic);
    }
}