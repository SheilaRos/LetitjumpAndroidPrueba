package com.example.billy.jumpit;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by dam on 2/3/17.
 */

public class GameView extends View {
    private BitmapSet bitmapSet;
    private EndlessScene endlessScene;
    private Bonk bonk;

    public GameView(Context context) {
        this(context, null, 0);
    }

    public GameView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmapSet = new BitmapSet(this.getResources());
        endlessScene = new EndlessScene(bitmapSet);
        bonk = new Bonk(bitmapSet);
    }
// dibujar la pantalla
    @Override
    public void onDraw(Canvas canvas) {
        this.postInvalidateDelayed(20);
        if (bitmapSet == null) return;
        float sc = getHeight() / (16 * 16f);
        canvas.scale(sc, sc);
        for (int i = 0; i < 7; i++) {
            endlessScene.draw(canvas);
        }
        bonk.draw(canvas);
    }
// variables para controlar el salto
    boolean goingUp = true;
    int jumpLength = 0;
    int count = 0;//

    //Tarea a realizar cuando se hace touch (jump)
    class MyTimerTask extends TimerTask {
        public void run() {
            //comprobar si hay suelo debajo
            if (checkGround() && !goingUp) {
                jumpLength = 0;
                goingUp = true;
                stop();
            } else {
                //salto y suavizado del mismo
                if (jumpLength < 50 && goingUp) {
                    if (jumpLength > 45) {
                        count++;
                        if (count > 2) {
                            bonk.setY(bonk.getY() - 1);
                            jumpLength++;
                            count = 0;
                        }
                    } else {
                        bonk.setY(bonk.getY() - 1);
                        jumpLength++;
                    }
                }
                //altura maxima del salto
                if (jumpLength == 50)
                    goingUp = false;
                // descenso
                if (!goingUp) {
                    count++;
                    if (jumpLength > 45) {
                        count++;
                        if (count > 2) {
                            bonk.setY(bonk.getY() + 1);
                            jumpLength--;
                            count = 0;
                        }
                    } else {
                        bonk.setY(bonk.getY() + 1);
                        jumpLength--;
                    }
                }
            }
        }
    }

    Timer timer = null;
    MyTimerTask myTimerTask = new MyTimerTask();
//detectar el tap para saltar
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        event.getRawX();
        event.getRawY();
        start();
        return true;
    }
//empezar el timer
    public void start() {
        if (timer != null) {
            return;
        }
        timer = new Timer();
        myTimerTask = new MyTimerTask();
        timer.schedule(myTimerTask, 0, bonk.getJumpVel());

    }
//parar el timer
    public void stop() {
        timer.cancel();
        timer.purge();
        timer = null;
    }
// comprobar si hay suelo debajo y posicionar el personaje cuando este cayendo
    public boolean checkGround() {
        int r = bonk.getY() >> 4;
        int c = bonk.getX() >> 4;
        if (!endlessScene.isGround(r+2, c))
            return false;
        else if (!goingUp)
            bonk.setY(r << 4);
        return true;
    }
}
