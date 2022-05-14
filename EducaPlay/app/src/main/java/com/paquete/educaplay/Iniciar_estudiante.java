package com.paquete.educaplay;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Iniciar_estudiante extends AppCompatActivity {
    EditText usuario, contraseña;
    Button iniciar_sesion;
    Connection con;
    private Cursor fila;

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
                login();
                Intent intent = new Intent(Iniciar_estudiante.this, buscar_estudiante.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void login(){
        Connection connection;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:jtds:sqlserver://gutgara.ddns.net;databaseName=EducaPlay;user=gutgara;password=VAuX2v_1xx0_T9w;");
            ps = connection.prepareStatement("SELECT * FROM Usuarios WHERE Correo = '" + usuario.getText() + "' AND Pass = '" + contraseña.getText() + "' ");
            ResultSet result = ps.executeQuery();
            if(fila.moveToFirst()){
                String usua=fila.getString(0);
                String pass=fila.getString(1);
                if (usuario.equals(usua)&&contraseña.equals(pass)){
                    Intent ven=new Intent(this, buscar_estudiante.class);
                    startActivity(ven);
                }
            }
            else {
                Toast toast=Toast.makeText(this,"Datos incorrectos",Toast.LENGTH_LONG);
                toast.show();
            }

        }catch (Exception e) {
            Toast toast=Toast.makeText(this,"Error" + e.getMessage(),Toast.LENGTH_LONG);
            toast.show();
        }
    }

    public void iniciobuscar(View view){
        Intent bus = new Intent(this, buscar_estudiante.class);
        startActivity(bus);
    }
    public void nuevoregistro(View view){
        Intent in = new Intent(this,registrar_estudiante.class);
        startActivity(in);
    }
}