package com.example.billy.jumpit.model;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;

import com.example.billy.jumpit.R;

/**
 * Created by dam on 5/4/17.
 */

public class DragonBitmapSet extends BitmapSet{
    private Bitmap[] bitmaps;

    private int[][] sheetInfo = {
            { 281, 165, 30, 22, 0 },//  0: firing right 1
            { 317, 165, 37, 22, 0 },//  1: firing right 2
            { 360, 163, 41, 24, 0 },	//  2: firing right 3
            { 407, 167, 44, 22, 0 },	//  3: firing right 4
            { 110, 39, 33, 21, 0 }, //  4: flying right 1
            { 145, 42, 34, 18, 0 }, //  5: flying right 2
            { 181, 41, 33, 19, 0 }, //  6: flying right 3
    };

    public Bitmap getBitmap(int i) { return bitmaps[i]; }

    public DragonBitmapSet(Resources res) {
        super(res);
        BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inScaled = false;

        Bitmap bitmapsBMP = BitmapFactory.decodeResource(res, R.raw.blackdragonpeke, opts);
        Matrix rot1 = new Matrix();
        bitmaps = new Bitmap[sheetInfo.length];
        for (int i = 0; i < sheetInfo.length; i++) {
            int x = sheetInfo[i][0];
            int y = sheetInfo[i][1];
            int w = sheetInfo[i][2];
            int h = sheetInfo[i][3];
            bitmaps[i] = Bitmap.createBitmap(bitmapsBMP, x, y, w, h,
                    rot1, true);
        }
        bitmapsBMP.recycle();
    }
}
