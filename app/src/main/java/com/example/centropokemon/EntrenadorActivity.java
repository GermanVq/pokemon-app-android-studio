package com.example.centropokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class EntrenadorActivity extends AppCompatActivity implements AdapterEntrenador.OnEntrenadorClickListener{
    private RecyclerView listadoEntrenador;
    private AdapterEntrenador adaptador;
    private LinearLayoutManager llm;
    private ArrayList<Entrenador> entrenador;
    private Context contexto;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenador);

        listadoEntrenador =(RecyclerView) findViewById(R.id.lstEntrenador);

        entrenador = Datos.obtenerEn();

        adaptador = new AdapterEntrenador(entrenador, this);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listadoEntrenador.setLayoutManager(llm);
        listadoEntrenador.setAdapter(adaptador);
    }

    @Override
    public void onEntrenadorClick(Entrenador a) {
        Intent intent;
        Bundle bundle;

        bundle = new Bundle();

        bundle.putInt("foto",a.getFoto());
        bundle.putString("id", a.getId());
        bundle.putString("nombre", a.getNombre());
        bundle.putString("edad", a.getEdad());
        bundle.putString("ciudad", a.getCiudad());
        bundle.putString("sexo", a.getSexo());

        intent = new Intent(EntrenadorActivity.this, DetallePokemon.class);
        intent.putExtra("datos",bundle);
        startActivity(intent);

    }
}