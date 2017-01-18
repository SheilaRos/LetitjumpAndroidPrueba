package com.example.billy.jumpit;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by dam on 12/1/17.
 */

public class Audio{
    private MediaPlayer mediaPlayer;
    public void load(Activity activity) {
        activity.setVolumeControlStream(AudioManager.STREAM_MUSIC);
        mediaPlayer = MediaPlayer.create(activity, R.raw.musicaprueba);
        mediaPlayer.setLooping(true);
    }
    public void startMusic() {
        mediaPlayer.start();
    }
    public void stopMusic() {
        mediaPlayer.pause();
    }

    public void unload() {
        mediaPlayer.release();
    }
    public void setVolume(float a, float b){
        mediaPlayer.setVolume(a, b);
    }

}
