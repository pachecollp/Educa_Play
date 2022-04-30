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
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

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

    public class checkLogin extends AsyncTask<String, String, String> {

        String z = null;
        Boolean isSuccess = false;
        private registrar_estudiante ConnectionClass;

        @Override
        protected void onPreExecute(){

        }

        @Override
        protected void onPostExecute(String s){
            super.onPostExecute(s);
        }

        @Override
        protected String doInBackground(String... strings){
            Connection con = connexionBD(ConnectionClass.nom.toString(), ConnectionClass.ape.toString(), ConnectionClass.correo.toString(), ConnectionClass.cod.toString(), ConnectionClass.contra.toString());
            if(con == null){
                Toast.makeText(Iniciar_estudiante.this, "Revisa tu conexion", Toast.LENGTH_LONG).show();
            }
            else {
                try {

                    String sql = "SELECT * FROM Usuarios WHERE usuario_estudiate = '" + usuario.getText() + "' AND contraseña_estudiante = '" + contraseña.getText() + "' ";
                    String nombreusuario = usuario.getText().toString();
                    String nom = "" + nombreusuario;
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(sql);

                    if (rs.next()) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(Iniciar_estudiante.this, "Inicio de sesión exitoso", Toast.LENGTH_LONG).show();

                            }
                        });
                        z = "Success";
                        Intent intent = new Intent(Iniciar_estudiante.this, buscar_estudiante.class);
                        startActivity(intent);
                        finish();
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(Iniciar_estudiante.this, "Revisa tu usuario o contraseña", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(Iniciar_estudiante.this, Iniciar_estudiante.class);
                                startActivity(intent);
                            }
                        });
                        usuario.setText("");
                        contraseña.setText("");
                    }

                } catch (Exception e) {
                    isSuccess = false;
                    Log.e("SQL Error :", e.getMessage());
                }
            }
            return z;
        }
    }

    @SuppressLint("NewApi")
    public Connection connexionBD(String nom, String ape, String corr, String cod, String cotra){
        Connection conexion = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion = DriverManager.getConnection("jdbc:jtds:sqlserver://gutgara.ddns.net;databaseName=EducaPlay;user=gutgara;password=VAuX2v_1xx0_T9w");

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();

        }
        return conexion;
    }
    public void iniciobuscar(View view){
        Intent bus = new Intent(this, buscar_estudiante.class);
        startActivity(bus);
    }
}