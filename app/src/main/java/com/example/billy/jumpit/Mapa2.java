package com.example.billy.jumpit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

/**
 * Created by dam on 25/1/17.
 */

public class Mapa2 extends SurfaceView implements Runnable {
    public Mapa2(Context context) {
        this(context, null, 0);
    }

    public Mapa2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Mapa2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void run() {
        update();
        draw();
        control();
    }
    private void update(){
    }
    private void draw(){
    }
    private void control(){
    }
}
