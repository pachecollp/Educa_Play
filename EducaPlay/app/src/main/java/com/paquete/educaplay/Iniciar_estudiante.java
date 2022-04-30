package com.paquete.educaplay;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.paquete.educaplay.Connection.ConnectionClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

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

   /* public class checkLogin extends AsyncTask<String, String, String> {

        String z = null;
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute(){ }

        @Override
        protected void onPostExecute(String s){ }

        @Override
        protected String doInBackground(String... strings){
            con = connectionClass(ConnectionClass.un.toString(), ConnectionClass.pass.toString(), ConnectionClass.db.toString(), ConnectionClass.ip.toString());
            if(con == null){
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(Iniciar_estudiante.this, "Revisa tu conexion", Toast.LENGTH_LONG).show();
                    }
                });
                z = "On Internet Connection";
            }
            else {
                try {

                    String sql = "SELECT * FROM Usuarios WHERE usuario_estudiate = '" + usuario.getText() + "' AND contraseña_estudiante = '" + contraseña.getText() + "' ";
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
    public  Connection connectionClass(String user, String password,String database, String server){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection connection = null;
        String connectionURL = null;
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            connectionURL = "jdbc:jtds:sqlserver://" + server+"/" + database + ";user" + user + ";password=" + password + ";";
            connection = DriverManager.getConnection(connectionURL);
        }catch (Exception e){
            Log.e("SQL Connection Error ; ", e.getMessage());
        }
        return connection;
    }

    /*public Connection conexionBD(){
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
    }*/
    public void iniciobuscar(View view){
        Intent bus = new Intent(this, buscar_estudiante.class);
        startActivity(bus);
    }
    public void nuevoregistro(View view){
        Intent in = new Intent(this,registrar_estudiante.class);
        startActivity(in);
    }
}