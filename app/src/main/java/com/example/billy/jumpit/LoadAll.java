package com.example.billy.jumpit;

import android.app.Activity;

/**
 * Created by dam on 12/1/17.
 */

public class LoadAll extends Game{
    public LoadAll (Activity activity){super(activity);}

    private Audio audio;
    @Override public void start() {
        audio = new Audio();
        audio.load(activity);
    }
// comando para iniciar la musica

}
