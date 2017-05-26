package com.example.billy.jumpit.controller.activities.main;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.billy.jumpit.controller.activities.gameViews.Audio;
import com.example.billy.jumpit.controller.activities.gameViews.GameView;
import com.example.billy.jumpit.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;


public class MainActivity extends FragmentActivity implements SeekBar.OnSeekBarChangeListener, GoogleApiClient.OnConnectionFailedListener,
        View.OnClickListener{
    boolean musicaOn = true;
    private View vistaOpciones;
    private View vistaTienda, vistaskins,vistapowerups,vistagems, menuniveles;
    private SeekBar volumeControl;
    private ImageButton volume;
    private Bundle bundle;
    private ImageButton reloadEndless, goHome;
    private ImageButton skin, powerUp, gemas, exit;


    // barra de control del volumen
    @Override public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        final float volumen = (float) (1 - (Math.log(100 - volumeControl.getProgress()) / Math.log(100)));
        audio.setVolume(volumen, volumen);
        if (volumeControl.getProgress()==0){
            audio.stopMusic();
            musicaOn=false;
            volume.setBackgroundResource(R.drawable.audiooff);
        }else {
            audio.startMusic();
            musicaOn=true;
            volume.setBackgroundResource(R.drawable.audioon);
        }
    }
    @Override public void onStartTrackingTouch(SeekBar seekBar) { }
    @Override public void onStopTrackingTouch(SeekBar seekBar) { }

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
//---------- VARIABLES GOOGLE
    private GoogleApiClient mGoogleApiClient;
    private TextView mStatusTextView;
    private ProgressDialog mProgressDialog;
    private static final String TAG = "SignInActivity";
    private static final int RC_SIGN_IN = 9001;
//---------------------------
@Override
public void onClick(View v) {
    switch (v.getId()) {
        case R.id.sign_in_button:
            signIn();
            break;
        // ...
    }
}
    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleSignInResult(result);
        }
    }
    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        Log.e("prueba", "" + result.isSuccess());
        if (result.isSuccess()) {
            // Signed in successfully, show authenticated UI.
            GoogleSignInAccount acct = result.getSignInAccount();
            String personName = acct.getDisplayName();
            String personGivenName = acct.getGivenName();
            String personFamilyName = acct.getFamilyName();
            String personEmail = acct.getEmail();
            String personId = acct.getId();
            Uri personPhoto = acct.getPhotoUrl();
            mStatusTextView.setText(getString(R.string.signed_in_fmt, acct.getDisplayName()));
            Log.e("nombre", personEmail);
            updateUI(true);
        } else {
            // Signed out, show unauthenticated UI.
            updateUI(false);
        }
    }
    private void updateUI(boolean signedIn) {
        if (signedIn) {
            findViewById(R.id.sign_in_button).setVisibility(View.GONE);
            findViewById(R.id.sign_out_and_disconnect).setVisibility(View.VISIBLE);
        } else {
            mStatusTextView.setText(R.string.signed_out);

            findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
//            findViewById(R.id.sign_out_and_disconnect).setVisibility(View.GONE);
        }
    }
    private void revokeAccess() {
        Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
                new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        // [START_EXCLUDE]
                        updateUI(false);
                        // [END_EXCLUDE]
                    }
                });
    }
    // [END revokeAccess]

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        // An unresolvable error has occurred and Google APIs (including Sign-In) will not
        // be available.
        Log.d(TAG, "onConnectionFailed:" + connectionResult);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//------------PRUEBA SIGN IN GOOGLE
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        SignInButton signInButton = (SignInButton) findViewById(R.id.sign_in_button);
        signInButton.setSize(SignInButton.SIZE_STANDARD);

        mStatusTextView = (TextView) findViewById(R.id.status);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        findViewById(R.id.sign_in_button).setOnClickListener(this);
//------------------------------------

        bundle = savedInstanceState;

//crear animacion slideout
        final Animation slideout;
        slideout = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        slideout.setDuration(200);

//crear animacion fadeout
        final Animation fadeout;
        fadeout = AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        fadeout.setDuration(200);

//crear animacion fadein
        final Animation fadein;
        fadein = AnimationUtils.loadAnimation(this, android.R.anim.fade_in);
        fadein.setDuration(200);

//crear variables del menu
        final ImageButton play = (ImageButton)findViewById(R.id.play);
        volume = (ImageButton)findViewById(R.id.volumeButton);
        final ImageButton options = (ImageButton)findViewById(R.id.optionsButton);
        final ImageButton shopButton = (ImageButton)findViewById(R.id.shopButton);
        ImageButton closeOption = (ImageButton)findViewById(R.id.closeButton);
        ImageButton closeShop = (ImageButton)findViewById(R.id.exitBtn);
        final TextView title = (TextView)findViewById(R.id.Title);
        final TextView coins = (TextView)findViewById(R.id.coins);
        final TextView diamonds = (TextView)findViewById(R.id.diamonds);
        final ImageView coins_image = (ImageView)findViewById(R.id.coin_image);
        final ImageView diamonds_image = (ImageView)findViewById(R.id.diamonds_image);
        vistaOpciones = (View)findViewById(R.id.options);
        volumeControl = (SeekBar)findViewById(R.id.volumeBar);
        vistaTienda = (View)findViewById(R.id.shopView);
        menuniveles = (View)findViewById(R.id.vistaNiveles);
        final GameView gameView = (GameView) findViewById(R.id.view4);
        final View mainMenuView = (View)findViewById(R.id.view);
        final ImageButton pause = (ImageButton)findViewById(R.id.pause);
        reloadEndless = (ImageButton)findViewById(R.id.reloadEndless);
        goHome = (ImageButton)findViewById(R.id.goHome);
        final ImageButton endless = (ImageButton) findViewById(R.id.btnendless);

        /*---------------------*/
        vistaskins = findViewById(R.id.view5);
        vistapowerups = findViewById(R.id.view6);
        vistagems = findViewById(R.id.view7);
        skin = (ImageButton) findViewById(R.id.skinBtnShop);
        powerUp = (ImageButton) findViewById(R.id.powerupBtnShop);
        gemas = (ImageButton) findViewById(R.id.gemas);
        /*----------------------*/
        gameView.setMainActivity(this);
        gameView.setPauseButton(pause);
        gameView.setGoHome(goHome);
        gameView.setReload(reloadEndless);

//Visibilities
        goHome.setVisibility(View.INVISIBLE);
        reloadEndless.setVisibility(View.INVISIBLE);

//listener de la barra de control del volumen
        volumeControl.setOnSeekBarChangeListener(this);

//hacer invisible las views
        vistaOpciones.setVisibility(View.INVISIBLE);
        vistaTienda.setVisibility(View.INVISIBLE);
        menuniveles.setVisibility(View.INVISIBLE);

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
                options.startAnimation(fadeout);
                options.setVisibility(View.INVISIBLE);
                shopButton.startAnimation(fadeout);
                shopButton.setVisibility(View.INVISIBLE);
                menuniveles.setVisibility(View.VISIBLE);
            }
        });

        endless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pause.setVisibility(View.VISIBLE);
                gameView.setVisibility(View.VISIBLE);
                mainMenuView.setVisibility(View.INVISIBLE);
                menuniveles.setVisibility(View.INVISIBLE);
            }
        });

//crear listener del volume para mute o play again
        volume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (musicaOn){
                    audio.stopMusic();
                    musicaOn=false;
                    volume.setBackgroundResource(R.drawable.audiooff);
                    volumeControl.setProgress(0);
                }else {
                    audio.startMusic();
                    musicaOn=true;
                    volume.setBackgroundResource(R.drawable.audioon);
                    volumeControl.setProgress(50);
                }
            }
        });
//crear listener de la tienda
     shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaTienda.startAnimation(fadein);
                vistaTienda.setVisibility(View.VISIBLE);
                vistaskins.setVisibility(View.INVISIBLE);
                vistapowerups.setVisibility(View.INVISIBLE);
                vistagems.setVisibility(View.INVISIBLE);
                skin.setVisibility(View.VISIBLE);
                powerUp.setVisibility(View.VISIBLE);
                gemas.setVisibility(View.VISIBLE);

            }
        });
//crear listener para cerrar las opciones
        closeShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaTienda.startAnimation(fadeout);
                vistaTienda.setVisibility(View.INVISIBLE);
            }
        });
//crear listener de las opciones
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaOpciones.startAnimation(fadein);
                vistaOpciones.setVisibility(View.VISIBLE);
            }
        });

//crear listener para cerrar las opciones
        closeOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaOpciones.startAnimation(fadeout);
                vistaOpciones.setVisibility(View.INVISIBLE);
            }
        });

    }

    public Bundle getBundle() {
        return bundle;
    }
}

