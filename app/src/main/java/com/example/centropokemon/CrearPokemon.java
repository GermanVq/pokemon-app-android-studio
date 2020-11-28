package com.example.centropokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CrearPokemon extends AppCompatActivity {
    private EditText id, nombre, nivel;
    private Spinner entrenador;
    private String[] opcionEntrenador;
    private int fotos[];
    private CheckBox e1, e2, e3, e4;
    private String rElem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_pokemon);

        nombre = findViewById(R.id.txtNombre);
        id= findViewById(R.id.txtId);
        nivel = findViewById(R.id.txtNivel);
        e1 = (CheckBox) findViewById(R.id.cbNormal);
        e2 = (CheckBox) findViewById(R.id.cbFuego);
        e3 = (CheckBox) findViewById(R.id.cbAgua);
        e4 = (CheckBox) findViewById(R.id.cbElectrico);
        entrenador = (Spinner) findViewById(R.id.cmbEntrenador);


        fotos = new int[4];
        fotos[0] = R.drawable.pokemon1;
        fotos[1] = R.drawable.pokemon2;
        fotos[2] = R.drawable.pokemon3;
        fotos[3] = R.drawable.pokemon4;


        opcionEntrenador = getResources().getStringArray(R.array.spEntrenamor);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, opcionEntrenador);
        entrenador.setAdapter(adapter);

    }
    public String SintomasEnf(){
        String sin = rElem;
        if(e1.isChecked()){
            sin = sin + e1.getText().toString()+", ";
        }
        if(e2.isChecked()){
            sin = sin + e2.getText().toString()+", ";
        }
        if(e3.isChecked()){
            sin = sin + e3.getText().toString()+", ";
        }
        if(e4.isChecked()){
            sin = sin + e4.getText().toString()+", ";
        }
        if(e1.isChecked() == false && e2.isChecked() == false && e3.isChecked() == false && e4.isChecked() == false){
            sin = "No Element";
        }
        return sin;
    }

    public void guardar(View v){
        if(validar()){
            String ide, nomb, niv, entr, elm;
            Pokemon p;
            ide = id.getText().toString();
            nomb = nombre.getText().toString();
            entr = entrenador.getSelectedItem().toString();
            niv = nivel.getText().toString();
            elm =  SintomasEnf();

            p = new Pokemon(fotoAleatoria(fotos), ide, nomb, entr, niv, elm );
            p.guardarPo();
            borrar(v);

            Toast.makeText(this, "pokemon guardado", Toast.LENGTH_LONG).show();
        }
    }

    public Boolean validar(){

        if (nombre.getText().toString().isEmpty()){
            nombre.setError("Error");
            nombre.requestFocus();
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
        Intent i = new Intent(CrearPokemon.this, InicioActivity.class);
        startActivity(i);
    }
    public void borrar(View v){

        nombre.setText("");
        nivel.setText("");
        id.setText("");
        id.requestFocus();
    }
}
