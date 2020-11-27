package com.example.centropokemon;

public class Entrenador {
    private int foto;
    private String id;
    private String nombre;
    private String edad;
    private String ciudad;
    private String sexo;

    public Entrenador(int foto, String id, String nombre, String edad, String ciudad, String sexo) {
        this.foto = foto;
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.ciudad = ciudad;
        this.sexo = sexo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public  void  guardarEn(){ Datos.guardarEn(this);}

    public void  eliminarEn(){
        Datos.eliminarEn(this);
    }
}
