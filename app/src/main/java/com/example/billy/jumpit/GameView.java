package com.example.billy.jumpit;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by dam on 2/3/17.
 */

public class GameView extends View {
    private BitmapSet bitmapSet;
    private EndlessScene endlessScene;
    private Bonk bonk;
    private ImageButton pauseButton;
    private int vel = 4;
    private boolean paused = false;
    private boolean jump = false;
    private boolean stateJumping = false;
    private int jumpCounter = 0;
    private int jumpIncrement = 2;
    private int jumpMaxHeigh = 70;
    private int jumpAux;

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
        pauseButton = (ImageButton) findViewById(R.id.pause);
        // vel = bonk.getVel();
        // jumpMaxHeigh = bonk.getJumpMaxHeigh();
    }
    // dibujar la pantalla
    @Override
    public void onDraw(Canvas canvas) {
        if (!paused)
            this.postInvalidateDelayed(10);
        if (bitmapSet == null) return;
        float sc = getHeight() / (16 * 16f);
        canvas.scale(sc, sc);
        if (jump){
            doGoingUp();
        }else if (!checkGround()){
            doGoingDown();
        }
        endlessScene.draw(canvas, vel);
        bonk.draw(canvas);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN && !stateJumping){
            jump = true;
            stateJumping = true;
        }
        if (event.getAction() == MotionEvent.ACTION_UP){
            jump = false;
        }
        return true;
    }
    public void doGoingUp(){
        if (jumpCounter<jumpMaxHeigh-10){
            bonk.setY(bonk.getY()-jumpIncrement);
            jumpCounter += jumpIncrement;
            jumpAux = jumpCounter;
        }else if(jumpCounter<jumpMaxHeigh){
            bonk.setY(bonk.getY() - jumpIncrement+1);
            jumpCounter += jumpIncrement-1;
            jumpAux = jumpCounter;
        }else if (jumpCounter >= jumpMaxHeigh){
            jump = false;
        }
    }
    public void doGoingDown(){
        if (jumpCounter>jumpAux-10){
            bonk.setY(bonk.getY() + jumpIncrement-1);
            jumpCounter -= jumpIncrement-1;
        }else {
            bonk.setY(bonk.getY()+jumpIncrement);
            jumpCounter -= jumpIncrement;
        }
    }
    public boolean checkGround() {
        int r = bonk.getY() >> 4;
        int c = bonk.getX() >> 4;
        if (!endlessScene.isGround(r+2, c)){
            stateJumping = true;
            return false;
        }else {
            if (!jump) {
                bonk.setY(r << 4);
                stateJumping = false;
                jumpCounter = 0;
            }
        }
        return true;
    }
}
