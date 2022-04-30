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

import com.paquete.educaplay.Connection.ConnectionClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLDataException;
import java.sql.SQLException;

public class registrar_estudiante extends AppCompatActivity {
    EditText nom, ape, correo, cod, contra;
    Button btnregistrarse;
    TextView status;
    String pasarusu;
    View img;

    Connection con;
    PreparedStatement stmt;

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
        status = (TextView)findViewById(R.id.status);
        img = (View)findViewById(R.id.img);
        pasarusu = correo.getText().toString().trim();
        btnregistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*agregarusuario();
                Intent intent = new Intent(registrar_estudiante.this, Iniciar_estudiante.class);
                intent.putExtra("usu",pasarusu);
                startActivity(intent);
                finish();*/
            }
        });
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("nombre :", String.valueOf("2"));
            }
        });
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
    public class  agregarusuario extends AsyncTask<String,String,String>{

        String z = "";
        Boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            status.setText("Enviando datos a la base de datos");
        }

        @Override
        protected void onPostExecute(String s) {
            status.setText("Registro satisfactorio");
            nom.setText("");
            ape.setText("");
            correo.setText("");
            cod.setText("");
            contra.setText("");
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                con = connectionClass(ConnectionClass.un.toString(),ConnectionClass.pass.toString(),ConnectionClass.db.toString(),ConnectionClass.ip.toString());
                if (con == null){
                    z = "Revisa tu conexion a internet";
                }else {
                    String sql = ""
                }

            }catch (Exception e){

            }
            return null;
        }
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

    /*public void agregarusuario(){
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
    }*/



    public void registrarse(View view){
        Intent inic = new Intent(this,Iniciar_estudiante.class);
        startActivity(inic);
    }
}