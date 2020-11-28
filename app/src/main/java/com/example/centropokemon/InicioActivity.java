package com.example.centropokemon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.github.clans.fab.FloatingActionMenu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class InicioActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

    }

    public void AgregarPokemon(View v){
        intent = new Intent(InicioActivity.this, CrearPokemon.class);
        startActivity(intent);
    }
    public void verPokemones(View v){
        intent = new Intent(InicioActivity.this, PokemonActivity.class);
        startActivity(intent);
    }
    public void verEntrenadores(View v){
        intent = new Intent(InicioActivity.this, PokemonActivity.class);
        startActivity(intent);
    }
    public void AgregarEntrenador(View v){
        intent = new Intent(InicioActivity.this, CrearEntrenador.class);
        startActivity(intent);
    }


}