package com.example.billy.jumpit;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;

/**
 * Created by dam on 25/1/17.
 */

public class PlataformasGame extends Game {
    // 50ms : 1000/50 = 20fps
    @Override public int getDesiredDeltaTime() { return 20; }
    public PlataformasGame(Activity activity) {
        super(activity);
    }

    private final static int DESIRED_HEIGHT = Scene.SCENE_HEIGHT * 16;
    private final static int DESIRED_WIDTH = (int)(DESIRED_HEIGHT * 1.6);
    private final static int MAX_WIDTH = DESIRED_WIDTH + 40;

    private final static boolean DEBUG_COLLISION = false;

    private Paint paint, paintScore;

    private int t, l, w, h;
    private float sc;
    private int score;
    private TilePrueba bitmapSet;
    private Audio audio;
    private Scene scene;
    @Override public void start() {
        // adjust scale based on width:height ratio and decide scale
        w = DESIRED_WIDTH;
        h = (int) ((float) w * height / width);
        t = l = 0;
        sc = 1;
        if (h > DESIRED_HEIGHT) {
            t = (h - DESIRED_HEIGHT) / 2;
            h = DESIRED_HEIGHT;
        } else {
            sc = (float) DESIRED_HEIGHT / h;
            h = DESIRED_HEIGHT;
            w = (int) (w * sc);
            if (w > MAX_WIDTH) {
                l = (int) ((w - MAX_WIDTH) / 2);
                w = MAX_WIDTH;
            }
        }
        sc = (float) (height) / (h + 2 * t);

        // load bitmaps
        bitmapSet = new TilePrueba(activity.getResources());
        scene = new Scene();
        scene.load(activity);
    }
    public void newGame() {
        resumeGame();
    }
    @Override
    public void finish() {

    }

    @Override
    public void attend(MotionEvent event) {

    }

    private int sceneOffset = 0;
    @Override public void update(long delta) {
        if (paused) return;



        mustRender = true;
    }
    @Override public void render(Canvas canvas) {
        if (scene == null) return;
        if (paint == null) {
            paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paintScore = new Paint();
            paintScore.setColor(Color.WHITE);
            paintScore.setShadowLayer(2, 2, 2, Color.LTGRAY);
            paintScore.setTextSize(20);
        }

        // compute offset of screen and apply with scale
        canvas.drawColor(Color.BLACK);
        canvas.scale(sc, sc);
        canvas.translate(l, t);

        // paint scene
        paint.setColor(Color.WHITE);
        canvas.clipRect(0, 0, w, h);
        for (int r = 0; r < h / 16; r++) {
            int y = r * 16;
            int back = 23;
            if (r == 13) back = 24;
            else if (r > 13) back = 25;
            for (int c = sceneOffset / 16; c < (w + sceneOffset) / 16 + 1; c++) {
                if (c == 80) break;
                int x = c * 16 - sceneOffset;
                int i = scene.getBitmap(r, c);
                canvas.drawBitmap(bitmapSet.getBitmap(back), x, y, paint);
                if (i != -1) {
                    canvas.drawBitmap(bitmapSet.getBitmap(i), x, y, paint);
                }
            }
        }

        // COINS


        // SCORES
        String msg = "Score: " + score;
        canvas.drawText(msg, 2, 20, paintScore);

        // if paused, draw a pause symbol on screen
        if (paused) {
            paint.setColor(0x80808080);
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawCircle(w/2, h/2, 40, paint);
            paint.setColor(0x80FFFFFF);
            canvas.drawRect(w/2-15, h/2-20, w/2-5, h/2+20, paint);
            canvas.drawRect(w/2+5, h/2-20, w/2+15, h/2+20, paint);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.WHITE);
        }
    }
}
