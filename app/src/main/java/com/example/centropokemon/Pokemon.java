package com.example.centropokemon;

public class Pokemon {
    private int foto;
    private String id;
    private String nombre;
    private String entrenador;
    private String elemento;
    private String nivel;

    public Pokemon(int foto, String id, String nombre, String entrenador, String elemento, String nivel) {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String  getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
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

    @Override
    public String toString() {
        return nombre;
    }

    public  void  guardarPo(){ Datos.guardarPo(this);}

    public void  eliminarPo(){
        Datos.eliminarPo(this);
    }
}
