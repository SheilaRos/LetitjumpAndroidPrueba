package com.example.billy.jumpit;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

/**
 * Created by dam on 5/4/17.
 */

public class DragonBitmapSet {
    private Bitmap[] bitmaps;

    private int[][] sheetInfo = {
            { 37, 33, 22, 22, 0 },	//  0: Running right 1
            { 28, 65, 32, 28, 0 },	//  1: Running right 2
            { 28, 96, 32, 28, 0 },	//  2: Running right 3
            { 28, 124, 32, 32, 0 },	//  3: Biking right 1
            { 28, 156, 32, 32, 0 }, //  4: Biking right 2
            { 28, 188, 32, 32, 0 }, //  5: Biking right 3
            { 60, 156, 32, 32, 0 }, //  6: Biking jump right 1
            { 60, 220, 32, 32, 0 }, //  7: Biking jump right 2
    };

    public Bitmap getBitmap(int i) { return bitmaps[i]; }

    public DragonBitmapSet(Resources res) {
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inScaled = false;

        Bitmap bitmapsBMP = BitmapFactory.decodeResource(res, R.raw.dppokemonsprites, opts);
        Matrix rot1 = new Matrix();
        Matrix rot2 = new Matrix();
        rot2.setScale(-1, 1);
        bitmaps = new Bitmap[sheetInfo.length];
        for (int i = 0; i < sheetInfo.length; i++) {
            int x = sheetInfo[i][0];
            int y = sheetInfo[i][1];
            int w = sheetInfo[i][2];
            int h = sheetInfo[i][3];
            boolean mustRotate = (sheetInfo[i][4] == 1);
            bitmaps[i] = Bitmap.createBitmap(bitmapsBMP, x, y, w, h,
                    mustRotate?rot2:rot1, true);
        }
        bitmapsBMP.recycle();
    }
}
