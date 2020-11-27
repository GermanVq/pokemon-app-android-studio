package com.example.centropokemon;

public class Entrenador {
    private int foto;
    private String id;
    private String nombre;
    private String edad;
    private String ciudad;

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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Entrenador(int foto, String id, String nombre, String edad, String ciudad) {
        this.foto = foto;
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
    }
    public  void  guardarEn(){ Datos.guardarEn(this);}

    public void  eliminarEn(){
        Datos.eliminarEn(this);
    }
}
