package com.example.billy.jumpit;

import java.util.ArrayList;

/**
 * Created by dam on 10/2/17.
 */

public class EndlessScene {
    private String [][] mapa = new String[16][80];

    public String[][] updateMap(){
        for (int i = 0; i<16;i++){
            for (int j = 0; j<80;j++){
               // if (mapa[][])
            }
        }
        return mapa;
    }
    public void initiateMap(){
        for (int i = 0; i<16;i++){
            for (int j = 0; j<80;j++){
                if (i<15)mapa[i][j] = ".";
                else mapa [i][j] = "_";
            }
        }
    }
}
/*
ver que plataformas hay hechas
maximo de plataformas??
velocidad??
random progresivo de longitud de plataforma long: 2-90% 3-70% 4-50% 5-20%
distancia entre plataformas
altura distinta, diferencia de 2?? determinado por random

*/