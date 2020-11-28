package com.example.centropokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Random;

public class CrearEntrenador extends AppCompatActivity {
    private EditText id, nombre, ciudad, edad;
    private RadioButton rbHombre, rbMujer;
    private int fotos[];
    private String resSex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_entrenador);



        id= findViewById(R.id.txtId);
        nombre = findViewById(R.id.txtNombre);
        ciudad = findViewById(R.id.txtCiudad);
        edad = findViewById(R.id.txtEdad);
        rbHombre = (RadioButton) findViewById(R.id.rbHombre);
        rbMujer = (RadioButton) findViewById(R.id.rbMujer);



        fotos = new int[4];
        fotos[0] = R.drawable.entrenador;
        fotos[1] = R.drawable.entrenador2;


    }
    public void guardar(View v) {
        if (rbHombre.isChecked() == true) {
            resSex = getString(R.string.hombre);;
        }
        if (rbMujer.isChecked() == true) {
            resSex = getString(R.string.mujer);
        } else {
            resSex = getString(R.string.incierto);
        }
        if(validar()){
            String ide, nomb, ciu, eda, sex;
            Pokemon p;
            ide = id.getText().toString();
            nomb = nombre.getText().toString();
            ciu = ciudad.getText().toString();
            eda = edad.getText().toString();
            sex =  resSex;

            p = new Pokemon(fotoAleatoria(fotos), ide, nomb, ciu, eda, sex );
            p.guardarPo();
            borrar(v);

            Toast.makeText(this, getText(R.string.guardado_entrenador), Toast.LENGTH_LONG).show();
        }
    }
    public Boolean validar(){

        if (nombre.getText().toString().isEmpty()){
            nombre.setError("Error");
            nombre.requestFocus();
            return false;
        }
        if (ciudad.getText().toString().isEmpty()){
            ciudad.setError(getString(R.string.mensaje_error));
            ciudad.requestFocus();
            return false;
        }
        if (edad.getText().toString().isEmpty()){
            edad.setError(getString(R.string.mensaje_error));
            edad.requestFocus();
            return false;
        }
        if (id.getText().toString().isEmpty()){
            id.setError(getString(R.string.mensaje_error));
            id.requestFocus();
            return false;
        }


        return true;
    }
    public int fotoAleatoria(int fotos[]){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.length);
        return fotos[fotoSeleccionada];
    }
    public void onBackPressed(){
        finish();
        Intent i = new Intent(CrearEntrenador.this, InicioActivity.class);
        startActivity(i);
    }
    public void borrar(View v){
        nombre.setText("");
        id.setText("");
        ciudad.setText("");
        edad.setText("");
        nombre.requestFocus();

    }

    }