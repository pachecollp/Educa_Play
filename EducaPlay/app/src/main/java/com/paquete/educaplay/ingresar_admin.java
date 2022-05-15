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

public class ingresar_admin extends AppCompatActivity {
    EditText usuario, contraseña;
    Button iniciar_sesion;
    Connection con;
    private Cursor fila;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_ingresar_admin);
        usuario = (EditText) findViewById(R.id.admin_ingresar1);
        contraseña = (EditText) findViewById(R.id.admin_ingresar2);
        iniciar_sesion = (Button) findViewById(R.id.btniniciaradmin);
        iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
                //Intent intent = new Intent(ingresar_admin.this, buscar_estudiante.class);
                //startActivity(intent);
                finish();
            }
        });

}

    public void login(){
        Connection connection;
        PreparedStatement ps;
        try {
            connection = DriverManager.getConnection("jdbc:jtds:sqlserver://gutgara.ddns.net;databaseName=EducaPlay;user=gutgara;password=VAuX2v_1xx0_T9w;");
            ps = connection.prepareStatement("SELECT * FROM admins WHERE Cedula = '" + usuario.getText() + "' AND Pass = '" + contraseña.getText() + "' ");
            ResultSet result = ps.executeQuery();
            if(fila.moveToFirst()){
                String usua=fila.getString(0);
                String pass=fila.getString(1);
                if (usuario.equals(usua)&&contraseña.equals(pass)){
                    //Intent ven=new Intent(this, buscar_estudiante.class);
                    //startActivity(ven);
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
        //Intent bus = new Intent(this, buscar_estudiante.class);
        //startActivity(bus);
    }
    public void nuevoregistroadmin(View view){
        Intent in = new Intent(this,registrar_admin.class);
        startActivity(in);
    }
}