package com.example.billy.jumpit;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dam on 25/1/17.
 */
public class Scene {
    public final static int SCENE_HEIGHT = 16;
    private String[] scene;

    public void load(Activity activity) {
        // load scene
        scene = new String[SCENE_HEIGHT];
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    activity.getResources().openRawResource(R.raw.scene)));
            for (int i = 0; i < SCENE_HEIGHT; i++) {
                String linea = in.readLine();
                scene[i] = linea;
            }
            in.close();
        }
        catch (IOException e) {
            scene = null;
        }
    }

    public boolean isGround(int r, int c) {
        char s = scene[r].charAt(c);
        if (s == '-') return true;
        if (s == '<') return true;
        if (s == '>') return true;
        return false;
    }

    public int getBitmap(int r, int c) {
        char e = scene[r].charAt(c);
        int i = -1;
        switch (e) {
            case '<': i = 35; break;
            case '-': i = 36; break;
            case '>': i = 37; break;
            case '[': i = 44; break;
            case '#': i = 45; break;
            case ']': i = 46; break;
            case '|': i = 40; break;
            case '{': i = 21; break;
            case '}': i = 22; break;
        }
        return i;
    }
   /* private char scene[][];
    private Paint paint;
    private BitmapSet bitmapSet;

    public Scene(BitmapSet bitmapSet) {
        this.bitmapSet = bitmapSet;
        paint = new Paint();
        scene = new char[16][80];
        for(int y = 0; y < 30; y++) {
            for(int x = 0; x < 80; x++) {
                scene[y][x] = 0;
            }
        }
        for(int x = 0; x < 80; x++) {
            scene[29][x] = 2;
        }
        for(int i = 0; i < 30; i++) {
            int x = (int)(Math.random()*79);
            int y = (int)(Math.random()*20);
            scene[y][x] = 7;
            scene[y][x+1] = 8;
        }
    }

    public void draw(Canvas canvas) {
        for(int y = 0; y < 30; y++) {
            for(int x = 0; x < 80; x++) {
                Bitmap bitmap;
                switch(scene[y][x]) {
                    case '.': bitmap = bitmapSet.getBitmap(45); break;
                    case 7: bitmap = bitmapSet.getBitmap(21); break;
                    case 8: bitmap = bitmapSet.getBitmap(22); break;
                    default: bitmap = bitmapSet.getBitmap(23); break;
                }
                canvas.drawBitmap(bitmap, x*16, y*16, paint);
            }
        }
    }*/
}