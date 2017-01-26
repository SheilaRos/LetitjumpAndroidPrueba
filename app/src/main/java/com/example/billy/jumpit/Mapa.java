package com.example.billy.jumpit;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by dam on 25/1/17.
 */

public class Mapa extends Activity {
    PlataformasGame game;
    GameView view;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        game = new PlataformasGame(this);
        view = new GameView(this, game);

        setContentView(view);
        game.newGame();

    }

    @Override public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {

            return true;

    }

    @Override public void onPause() {
        super.onPause();
    }

    @Override public void onResume() {
        super.onResume();
    }

    @Override public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}
