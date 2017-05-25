package com.example.billy.jumpit;

import android.widget.ImageButton;

/**
 * Created by lolrol1 on 14/5/17.
 */

public class ClassLevel {

    private String nombre;
    private ImageButton button;

    public ClassLevel(String nombre, ImageButton button) {
        this.nombre = nombre;
        this.button = button;
    }

    public ClassLevel() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ImageButton getButton() {
        return button;
    }

    public void setButton(ImageButton button) {
        this.button = button;
    }
}
