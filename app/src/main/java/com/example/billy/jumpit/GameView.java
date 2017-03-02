package com.example.billy.jumpit;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

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
        this.postInvalidateDelayed(50);
        if (bitmapSet == null) return;
        float sc = getHeight() / (16*16f);
        canvas.scale(sc, sc);
        endlessScene.draw(canvas);
        bonk.draw(canvas);
    }
}
