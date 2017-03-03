package com.example.billy.jumpit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by dam on 10/2/17.
 */

public class EndlessScene {
    private char scene[][] = new char[16][30];
    private Paint paint;
    private BitmapSet bitmapSet;
    private int cont = 0;

    public EndlessScene(BitmapSet bitmapSet) {
        this.bitmapSet = bitmapSet;
        this.scene = initiateMap(scene);
        paint = new Paint();
    }

    public void draw(Canvas canvas) {
            scene = updateMap();
        for(int y = 0; y < 16; y++) {
            for(int x = 0; x < 30; x++) {
                Bitmap bitmap;
                switch(scene[y][x]) {
                    case '.': bitmap = bitmapSet.getBitmap(23); break;
                    case '-': bitmap = bitmapSet.getBitmap(45); break;
                    default: bitmap = bitmapSet.getBitmap(23); break;
                }
                canvas.drawBitmap(bitmap, x*16-cont, y*16, paint);
                //canvas.drawBitmap(sprite, x, y, paint);
            }
        }
    }
    public char[][] updateMap() {
        if (cont < 16) {
            cont++;
            return scene;
        }else {
            int platforms = 0;
            int groundCounter = 0;

            // buscamos info
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 29; j++) {
                    // contamos las plataformas
                    if (scene[i][j] == ('-'/* plataforma */) && scene[i][j + 1] == ('.' /* cielo */)) {
                        platforms++;
                    }
                    // contamos el suelo
                    if (i == 15 && scene[15][j] == '-') {
                        groundCounter++;
                    }
                }
            }
            // avanzamos el scene una posicion
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 29; j++) {
                    scene[i][j] = scene[i][j + 1];
                }
            }
            // pintamos la ultima linea
            for (int i = 0; i < 16; i++) {

                scene[i][29] = '.';
                if (i == 15 /*&& groundCounter<10*/)
                    scene[i][29] = '-';
            }
            cont = 0;
            return scene;
        }
    }

    public char [][] initiateMap(char [][] map){
        for (int i = 0; i<16;i++){
            for (int j = 0; j<30;j++){
                map[i][j] = '.';
                map [15][j] = '-';
            }
        }
        return map;
    }

}
/*
- ver que plataformas hay hechas
- maximo de plataformas??
- velocidad??
- random progresivo de longitud de plataforma long: 2-90% 3-70% 4-50% 5-20%
- distancia entre plataformas
- altura distinta, diferencia de 2?? determinado por random
- enemigos
- power ups
*/