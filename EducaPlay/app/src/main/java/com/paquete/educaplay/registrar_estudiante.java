package com.paquete.educaplay;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class registrar_estudiante extends AppCompatActivity {
    EditText nom, ape, correo, cod, contra;
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
        contra = (EditText) findViewById(R.id.contraseña_estudiante);
        btnregistrarse = (Button) findViewById(R.id.btnregistro);
        img = (View)findViewById(R.id.img);
        pasarusu = correo.getText().toString().trim();
        btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregarusuario();
                Intent intent = new Intent(registrar_estudiante.this, Iniciar_estudiante.class);
                intent.putExtra("usu",pasarusu);
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
    public Connection conexionBD(){
        Connection conexion = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://gutgara.ddns.net;databaseName=EducaPlay;user=gutgara;password=VAuX2v_1xx0_T9w;");

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return conexion;
    }
    public void agregarusuario(){
        try{
            PreparedStatement pst = conexionBD().prepareStatement("insert into Usuarios values(?,?,?,?,?)");
            pst.setString(1,nom.getText().toString());
            pst.setString(2,ape.getText().toString());
            pst.setString(3,correo.getText().toString());
            pst.setString(4,cod.getText().toString());
            pst.setString(5,contra.getText().toString());
            pst.executeUpdate();
            Toast.makeText(getApplicationContext(),"REGISTRO AGREGADO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
        }catch (SQLDataException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }



    public void registrarse(View view){
        Intent inic = new Intent(this,Iniciar_estudiante.class);
        startActivity(inic);
    }
}