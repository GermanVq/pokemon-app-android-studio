package com.example.centropokemon;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterEntrenador extends RecyclerView.Adapter<AdapterEntrenador.EntrenadorViewHolder> {
    private ArrayList<Entrenador> entrenador;
    private AdapterEntrenador.OnEntrenadorClickListener clickListener;

    public AdapterEntrenador(ArrayList<Entrenador> entrenador, AdapterEntrenador.OnEntrenadorClickListener clickListener) {
        this.entrenador = entrenador;
        this.clickListener=clickListener;
    }

    @NonNull
    @Override
    public EntrenadorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_entrenador,parent,false);
        return new EntrenadorViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull EntrenadorViewHolder holder, int position) {
        final Entrenador p = entrenador.get(position);

        holder.foto.setImageResource(p.getFoto());
        holder.nombre.setText(p.getNombre());
        holder.edad.setText(p.getEdad());
        holder.ciudad.setText(p.getCiudad());


        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onEntrenadorClick(p);
            }
        });
    }


    @Override
    public int getItemCount() {
        return entrenador.size();
    }
    public static class EntrenadorViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView foto;
        private TextView nombre;
        private TextView edad;
        private TextView ciudad;
        private View v;

        public EntrenadorViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFoto);
            nombre = v.findViewById(R.id.lblNombreEntrenador);
            edad = v.findViewById(R.id.lblEdadEntrenador);
            ciudad = v.findViewById(R.id.lblCiudadEntrenador);

        }
    }
    public interface OnEntrenadorClickListener{
        void onEntrenadorClick(Entrenador a);
    }

}
