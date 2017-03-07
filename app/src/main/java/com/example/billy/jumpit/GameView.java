package com.example.billy.jumpit;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Handler;
import android.util.AttributeSet;
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

    public GameView(Context context) { this(context, null, 0); }
    public GameView(Context context, AttributeSet attrs) { this(context, attrs, 0); }
    public GameView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        bitmapSet = new BitmapSet(this.getResources());
        endlessScene = new EndlessScene(bitmapSet);
        bonk = new Bonk(bitmapSet);
    }

    @Override public void onDraw(Canvas canvas) {
        this.postInvalidateDelayed(20);
        if (bitmapSet == null) return;
        float sc = getHeight() / (16*16f);
        canvas.scale(sc, sc);
        for (int i = 0; i<7;i++){
            endlessScene.draw(canvas);
        }
        bonk.draw(canvas);
    }
    boolean goingUp = true;
    int jumpLength = 0;
    Timer timer = null;
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            if (jumpLength<50 && goingUp) {
                bonk.setY(bonk.getY() - 1);
                jumpLength++;
            }
            if (jumpLength == 50)
                goingUp = false;

            if (jumpLength>0 && !goingUp){
                bonk.setY(bonk.getY() + 1);
                jumpLength--;
            }
            if (jumpLength == 0 && !goingUp) {
                stop();
                goingUp = true;
            }
        }
    };
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        event.getRawX();
        event.getRawY();
            start();
        return true;
    }

    public void start() {
        if(timer != null) {
            return;
        }
        timer = new Timer();
        timer.schedule(timerTask, 0, 20);
    }

    public void stop() {
        timer.cancel();
        timer = null;
    }
}
