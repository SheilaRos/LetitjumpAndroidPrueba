package com.example.billy.jumpit;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by dam on 2/3/17.
 */

public class GameView extends View {
    private BitmapSet bitmapSet;
    private EndlessScene endlessScene;
    private Bonk bonk;
    private boolean jump = false;
    private int bonkDrawerCounter = 0;

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
        this.postInvalidateDelayed(10);
        if (bitmapSet == null) return;
        float sc = getHeight() / (16 * 16f);
        canvas.scale(sc, sc);
        if (jump)
            doJump();
        endlessScene.draw(canvas, 4);
        Log.e("bonk x: ", ""+bonk.getX());
        Log.e("bonk y: ", ""+bonk.getY());
        bonk.draw(canvas);
//        if (bonkDrawerCounter>1) {
//            bonk.draw(canvas);
//            bonkDrawerCounter = 0;
//        }else
//            bonkDrawerCounter++;
    }
    public void doJump(){
        if (checkGround() && !goingUp) {
            jumpLength = 0;
            goingUp = true;
            jump = false;
        } else {
            //salto y suavizado del mismo
            if (jumpLength < 25 && goingUp) {
                if (jumpLength > 20) {
                    count++;
                    if (count > 2) {
                        bonk.setY(bonk.getY() - 2);
                        jumpLength++;
                        count = 0;
                    }
                } else {
                    bonk.setY(bonk.getY() - 2);
                    jumpLength++;
                }
            }
            //altura maxima del salto
            if (jumpLength >= 25)
                goingUp = false;
            // descenso
            if (!goingUp) {
                count++;
                if (jumpLength > 20) {
                    count++;
                    if (count > 2) {
                        bonk.setY(bonk.getY() + 2);
                        jumpLength--;
                        count = 0;
                    }
                } else {
                    bonk.setY(bonk.getY() + 2);
                    jumpLength--;
                }
            }
        }
    }
// variables para controlar el salto
    boolean goingUp = true;
    int jumpLength = 0;
    int count = 0;//

//detectar el tap para saltar
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        jump = true;
        return true;
    }
// comprobar si hay suelo debajo y posicionar el personaje cuando este cayendo
    public boolean checkGround() {
        int r = bonk.getY() >> 4;
        int c = bonk.getX() >> 4;
        if (!endlessScene.isGround(r+2, c))
            return false;
        else if (!goingUp) {
            bonk.setY(r << 4);
            jumpLength=0;
        }
        return true;
    }
}
