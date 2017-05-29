package com.example.billy.jumpit.controller.activities.activities.gameViews;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;

import com.example.billy.jumpit.R;

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
