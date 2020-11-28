package com.example.centropokemon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import java.util.ArrayList;

public class PokemonActivity extends AppCompatActivity implements AdapterPokemon.OnPokemonClickListener {
    private RecyclerView listadoPokemon;
    private AdapterPokemon adaptador;
    private LinearLayoutManager llm;
    private ArrayList<Pokemon> pokemon;
    private Context contexto;
    private Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);


        listadoPokemon =(RecyclerView) findViewById(R.id.lstPokemon);

        pokemon = Datos.obtenerPo();

        adaptador = new AdapterPokemon(pokemon, this);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);

        listadoPokemon.setLayoutManager(llm);
        listadoPokemon.setAdapter(adaptador);

    }

    @Override
    public void onPokemonClick(Pokemon a) {
        Intent intent;
        Bundle bundle;

        bundle = new Bundle();

        bundle.putInt("foto",a.getFoto());
        bundle.putString("id", a.getId());
        bundle.putString("nombre", a.getNombre());
        bundle.putString("entrenador", a.getEntrenador());
        bundle.putString("elemento", a.getElemento());
        bundle.putString("nivel", a.getNivel());

        intent = new Intent(PokemonActivity.this, DetallePokemon.class);
        intent.putExtra("datos",bundle);
        startActivity(intent);

    }
}