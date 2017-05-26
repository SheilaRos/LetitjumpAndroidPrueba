package com.example.billy.jumpit.model;

/**
 * Created by DAM on 23/5/17.
 */

public class Player {
    private String usuari;
    private String password;
    private int nivell = 11;

    public String getUsuari() {
        return usuari;
    }

    public void setUsuari(String usuari) {
        this.usuari = usuari;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getNivell() {
        return nivell;
    }

    public void setNivell(int nivell) {
        this.nivell = nivell;
    }
}
