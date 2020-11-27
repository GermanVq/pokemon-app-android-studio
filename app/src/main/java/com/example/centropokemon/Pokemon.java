package com.example.centropokemon;

public class Pokemon {
    private int foto;
    private int id;
    private String nombre;
    private Entrenador entrenador;
    private String elemento;
    private String nivel;

    public Pokemon(int foto, int id, String nombre, Entrenador entrenador, String elemento, String nivel) {
        this.foto = foto;
        this.id = id;
        this.nombre = nombre;
        this.entrenador = entrenador;
        this.elemento = elemento;
        this.nivel = nivel;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
}
