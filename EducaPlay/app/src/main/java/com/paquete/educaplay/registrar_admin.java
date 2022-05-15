package com.paquete.educaplay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class registrar_admin extends Fragment {
    EditText nom, ape, correo, cod, contra;
    Button btnregistrarse;
    String pasarusu, rol;
    View img;

    public registrar_admin() {

    }

    // TODO: Rename and change types and number of parameters
    public static registrar_admin newInstance(String param1, String param2) {
        registrar_admin fragment = new registrar_admin();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_estudiante);
        nom = (EditText) nom.findViewById(R.id.nombre_docente);
        ape = (EditText) ape.findViewById(R.id.apellido_docente);
        correo = (EditText) correo.findViewById(R.id.correo_docente);
        cod = (EditText) cod.findViewById(R.id.codigo_docente);
        contra = (EditText) contra.findViewById(R.id.contraseña_docente);
        btnregistrarse = (Button) btnregistrarse.findViewById(R.id.btnregistroadmin);
        img = (View) img.findViewById(R.id.img);
        pasarusu = correo.getText().toString().trim();
        rol = "3";
        btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                agregaradmin();
                Intent intent = new Intent(registrar_admin.this, MainActivity2.class);
                intent.putExtra("usu", pasarusu);
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

    private void setContentView(int activity_registrar_estudiante) {
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
    public void agregaradmin(){
        try{
            PreparedStatement pst = conexionBD().prepareStatement("insert into Usuarios values(?,?,?,?,?,?)");
            pst.setString(1,rol);
            pst.setString(2,nom.getText().toString());
            pst.setString(3,ape.getText().toString());
            pst.setString(4,cod.getText().toString());
            pst.setString(5,correo.getText().toString());
            pst.setString(6,contra.getText().toString());
            pst.executeUpdate();
            Toast.makeText(getApplicationContext(),"REGISTRO AGREGADO CORRECTAMENTE",Toast.LENGTH_SHORT).show();
        }catch (SQLDataException e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registrar_admin, container, false);
    }

}