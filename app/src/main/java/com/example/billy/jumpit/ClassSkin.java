package com.example.billy.jumpit;

import android.widget.Button;

/**
 * Created by dam on 21/3/17.
 */

public class ClassSkin {

    private String nombre;
    private int foto;

    public ClassSkin(String nombre, int foton) {
        this.nombre = nombre;
        this.foto = foto;
    }

    public ClassSkin() {
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




}