package com.example.billy.jumpit.model;

import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by lolrol1 on 14/5/17.
 */

public class ClassLevel {

    private String nombre;
    private ImageButton button;
    private TextView textView;

    public ClassLevel(String nombre, ImageButton button, TextView textView) {
        this.nombre = nombre;
        this.button = button;
        this.textView = textView;
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
