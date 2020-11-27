package com.example.centropokemon;

import java.util.ArrayList;

public class Datos {

    private static ArrayList<Pokemon> pokemon = new ArrayList();
    private static ArrayList<Entrenador> entrenador = new ArrayList();

    public static void guardarPo(Pokemon p){
        pokemon.add(p);
    }
    public static void guardarEn(Entrenador p){
        entrenador.add(p);
    }


    public static void eliminarPo(Pokemon p){
        for (int i = 0; i < pokemon.size(); i++){
            if(pokemon.get(i).getId().equals(p.getId())){
                pokemon.remove(i);
                break;
            }
        }
    }
    public static void eliminarEn(Entrenador p){
        for (int i = 0; i < entrenador.size(); i++){
            if(entrenador.get(i).getId().equals(p.getId())){
                entrenador.remove(i);
                break;
            }
        }
    }

    public static ArrayList<Pokemon> obtenerPo(){
        return pokemon;
    }
    public static ArrayList<Entrenador> obtenerEn(){
        return entrenador;
    }

}