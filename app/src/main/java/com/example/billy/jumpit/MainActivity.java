package com.example.billy.jumpit;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.Delayed;


public class MainActivity extends Activity {
    boolean musicaOn = true;
// Metodos para crear musica que inicie con la app en primer plano y que pare en segundo plano
    Audio audio = new Audio();
    @Override
    protected void onPause() {
        super.onPause();
        audio.stopMusic();
        audio.unload();
    }

    @Override
    protected void onResume() {
        super.onResume();
        audio.load(this);
        audio.startMusic();
    }
    // comandos para poner la pantalla completa y que sea automatico
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View decorView = getWindow().getDecorView();
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//crear animacion slideout
        final Animation slideout;
        slideout = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        slideout.setDuration(500);

//crear animacion fadeout
        final Animation fadeout;
        fadeout = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        fadeout.setDuration(500);

//crear variables del menu
        final ImageButton play = (ImageButton)findViewById(R.id.play);
        final ImageButton volume = (ImageButton)findViewById(R.id.volumeButton);
        final TextView title = (TextView)findViewById(R.id.Title);
        final TextView coins = (TextView)findViewById(R.id.coins);
        final TextView diamonds = (TextView)findViewById(R.id.diamonds);
        final ImageView coins_image = (ImageView)findViewById(R.id.coin_image);
        final ImageView diamonds_image = (ImageView)findViewById(R.id.diamonds_image);

//crear listener del play
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //usar animacion fadeout para los elementos del menu
                play.startAnimation(fadeout);
                play.setVisibility(View.INVISIBLE);
                title.startAnimation(fadeout);
                title.setVisibility(View.INVISIBLE);
                coins.startAnimation(fadeout);
                coins.setVisibility(View.INVISIBLE);
                coins_image.startAnimation(fadeout);
                coins_image.setVisibility(View.INVISIBLE);
                diamonds.startAnimation(fadeout);
                diamonds.setVisibility(View.INVISIBLE);
                diamonds_image.startAnimation(fadeout);
                diamonds_image.setVisibility(View.INVISIBLE);
                volume.startAnimation(fadeout);
                volume.setVisibility(View.INVISIBLE);
            }
        });

//crear listener del volume para mute o play again
        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (musicaOn==true){
                    audio.stopMusic();
                    musicaOn=false;
                    volume.setBackgroundResource(R.drawable.audiooff);
                }else {
                    audio.startMusic();
                    musicaOn=true;
                    volume.setBackgroundResource(R.drawable.audioon);
                }
            }
        });
    }
}

