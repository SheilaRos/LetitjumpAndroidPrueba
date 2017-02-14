package com.example.billy.jumpit;

import java.util.ArrayList;

/**
 * Created by dam on 10/2/17.
 */

public class EndlessScene {
    private String [][] mapa = new String[16][80];

    public String[][] updateMap(){
        int platforms = 0;
        int groundCounter = 0;

        // buscamos info
        for (int i = 0; i<16;i++){
            for (int j = 0; j<80;j++){
                // contamos las plataformas
                if (mapa[i][j].equals("-"/* plataforma */) && mapa[i][j+1].equals("." /* cielo */)){
                    platforms++;
                }
                // contamos el suelo
                if (i == 16 && mapa[16][j].equals("_")){
                    groundCounter++;
                }
            }
        }
        // avanzamos el mapa una posicion
        for (int i = 0; i<16;i++){
            for (int j = 0; j<80;j++){
                if (j>1)
                    mapa[i][j-1] = mapa [i][j];
            }
        }
        // pintamos la ultima linea
        for (int i = 0; i<16;i++){
            if (i == 16 && groundCounter<5)
                mapa[i][80] = "_";

            mapa[i][80] = ".";
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