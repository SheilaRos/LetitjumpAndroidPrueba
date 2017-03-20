package com.example.billy.jumpit;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by dam on 20/3/17.
 */

public class MainMenuBackgroundScene {
    private char scene[][] = new char[16][30];
    private Paint paint;
    private BitmapSet bitmapSet;
    private int cont = 0;

    public MainMenuBackgroundScene(BitmapSet bitmapSet) {
        this.bitmapSet = bitmapSet;
        this.scene = initiateMap(scene);
        paint = new Paint();
    }
    public boolean isGround(int y, int x){
        if (y>=16)
            return false;
        char s = scene[y][x];
        if (s == '-') return true;
        if (s == '<') return true;
        if (s == '>') return true;
        return false;
    }
    public void draw(Canvas canvas) {
        if (cont>15) {
            scene = updateMap();
            cont = 0;
        }
        for(int y = 0; y < 16; y++) {
            for(int x = 0; x < 30; x++) {
                Bitmap bitmap;
                switch(scene[y][x]) {
                    case '.': bitmap = bitmapSet.getBitmap(23); break;
                    case '-': bitmap = bitmapSet.getBitmap(45); break;
                    default: bitmap = bitmapSet.getBitmap(23); break;
                }
                canvas.drawBitmap(bitmap, x*16-cont, y*16, paint);
            }
        }
        cont = cont+3;
    }
    public char[][] updateMap() {
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
            if (i == 15)
                scene[i][29] = '-';
        }
        return scene;

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
