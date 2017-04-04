package com.example.billy.jumpit;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import static android.R.drawable.ic_media_pause;
import static android.R.drawable.ic_media_play;

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
    private int score = 0;
    private MainActivity mainActivity;
    private ImageButton goHome;
    private ImageButton reload;
    private TextView scoreText;


    private TextView scoreTextView;

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
        // vel = bonk.getVel();
        // jumpMaxHeigh = bonk.getJumpMaxHeigh();
    }

    // dibujar la pantalla
    @Override
    public void onDraw(Canvas canvas) {
        this.postInvalidateDelayed(10);
        if (!paused) {
            if (bitmapSet == null) return;
            float sc = getHeight() / (16 * 16f);
            canvas.scale(sc, sc);
            if (jump) {
                doGoingUp();
            } else if (!checkGround()) {
                doGoingDown();
            }
            endlessScene.draw(canvas, vel);
            bonk.draw(canvas);
            if (score % 200 == 1) {
                scoreTextView.setText("Score = " + (score - 1));
//                if (score % 3000 == 1) {
//                    vel++;
//                    bonk.setVel(vel);
//                }
            }
            score++;
        }else {
            if (bitmapSet == null) return;
            float sc = getHeight() / (16 * 16f);
            canvas.scale(sc, sc);
            endlessScene.draw(canvas, vel);
            bonk.draw(canvas);
              //  mainActivity.onCreate(mainActivity.getBundle());
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        pauseButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                if (paused){
                    vel = 4;
                    paused = false;
                    pauseButton.setBackgroundResource(ic_media_pause);
                }else{
                    vel = 0;
                    paused = true;
                    pauseButton.setBackgroundResource(ic_media_play);
                }
            }
        });
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
        if (r >=16){
            scoreTextView.setText("Score = " + score);
            paused = true;
            end();
        }
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

    public void end(){
        goHome.setVisibility(VISIBLE);
        reload.setVisibility(VISIBLE);
        scoreText.setText("SCORE: "+score);
        scoreText.setVisibility(VISIBLE);

        goHome.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity.onCreate(mainActivity.getBundle());
            }
        });
        reload.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                endlessScene = new EndlessScene(bitmapSet);
                bonk = new Bonk(bitmapSet);
                vel = 4;
                paused = false;
                jump = false;
                stateJumping = false;
                jumpCounter = 0;
                jumpIncrement = 2;
                jumpMaxHeigh = 70;
                score = 0;
                goHome.setVisibility(INVISIBLE);
                reload.setVisibility(INVISIBLE);
                scoreText.setVisibility(INVISIBLE);
            }
        });
    }

    public TextView getScoreTextView() {
        return scoreTextView;
    }

    public void setScoreTextView(TextView scoreTextView) {
        this.scoreTextView = scoreTextView;
    }

    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public ImageButton getPauseButton() {
        return pauseButton;
    }

    public void setPauseButton(ImageButton pauseButton) {
        this.pauseButton = pauseButton;
    }

    public ImageButton getGoHome() {
        return goHome;
    }

    public void setGoHome(ImageButton goHome) {
        this.goHome = goHome;
    }

    public ImageButton getReload() {
        return reload;
    }

    public void setReload(ImageButton reload) {
        this.reload = reload;
    }

    public TextView getScoreText() {
        return scoreText;
    }

    public void setScoreText(TextView scoreText) {
        this.scoreText = scoreText;
    }
}
