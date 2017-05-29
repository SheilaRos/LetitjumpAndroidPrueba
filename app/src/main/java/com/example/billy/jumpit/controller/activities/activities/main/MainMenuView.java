package com.example.billy.jumpit.controller.activities.activities.main;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.billy.jumpit.controller.activities.activities.MainMenuBackgroundScene;
import com.example.billy.jumpit.model.BitmapSet;
import com.example.billy.jumpit.model.Bonk;

/**
 * Created by dam on 20/3/17.
 */

public class MainMenuView extends View {
    private BitmapSet bitmapSet;
    private MainMenuBackgroundScene mainMenuBackgroundScene;
    private Bonk bonk;
    private boolean jump = false;
    private int bonkDrawerCounter = 0;
    public MainMenuView(Context context) {
        this(context, null, 0);
    }

    public MainMenuView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MainMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmapSet = new BitmapSet(this.getResources());
        mainMenuBackgroundScene = new MainMenuBackgroundScene(bitmapSet);
        bonk = new Bonk(bitmapSet);
    }

    @Override
    public void onDraw(Canvas canvas) {
        this.postInvalidateDelayed(1);
        if (bitmapSet == null) return;
        float sc = getHeight() / (16 * 16f);
        canvas.scale(sc, sc);
        if (jump)
            doJump();
        mainMenuBackgroundScene.draw(canvas);
        bonk.draw(canvas);
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
        if (!mainMenuBackgroundScene.isGround(r+2, c))
            return false;
        else if (!goingUp) {
            bonk.setY(r << 4);
            jumpLength=0;
        }
        return true;
    }
}
