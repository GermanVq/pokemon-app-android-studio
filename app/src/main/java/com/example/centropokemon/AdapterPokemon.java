package com.example.centropokemon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.BreakIterator;
import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterPokemon extends RecyclerView.Adapter<AdapterPokemon.PokemonViewHolder> {
    private ArrayList<Pokemon> pokemon;
    private OnPokemonClickListener clickListener;

    public AdapterPokemon(ArrayList<Pokemon> pokemon, OnPokemonClickListener clickListener) {
        this.pokemon = pokemon;
        this.clickListener=clickListener;
    }

    @NonNull
    @Override
    public AdapterPokemon.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pokemon,parent,false);
        return new PokemonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPokemon.PokemonViewHolder holder, int position) {
        final Pokemon p = pokemon.get(position);

        holder.foto.setImageResource(p.getFoto());
        holder.nombre.setText(p.getNombre());
        holder.entrenador.setText(p.getEntrenador());
        holder.elemento.setText(p.getElemento());


        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onPokemonClick(p);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder{

        public CircleImageView foto;
        private TextView nombre;
        private TextView entrenador;
        private TextView elemento;
        public View v;


        public PokemonViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            nombre = v.findViewById(R.id.lblNombrePokemon);
            entrenador = v.findViewById(R.id.lblEntrenadorPokemon);
            elemento = v.findViewById(R.id.lblElemento);

        }
    }

    public interface OnPokemonClickListener{
        void onPokemonClick(Pokemon a);
    }

}
