package com.example.billy.jumpit;

import android.app.Activity;

/**
 * Created by dam on 12/1/17.
 */

public abstract class Game {
    protected Activity activity;
    public Game(Activity activity) {
        this.activity = activity;
    }
    public abstract void start();
}
