package com.example.billy.jumpit;

/**
 * Created by lolrol1 on 14/5/17.
 */

public class ClassPowerUp {

    private String nombre;
    private int foto;
    private String descripcion;

    public ClassPowerUp(String nombre, int foto, String descripcion) {
        this.nombre = nombre;
        this.foto = foto;
        this.descripcion = descripcion;
    }

    public ClassPowerUp() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
