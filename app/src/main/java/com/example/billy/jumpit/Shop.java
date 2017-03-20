package com.example.billy.jumpit;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by dam on 17/1/17.
 */

public class Shop extends LinearLayout {
    private ImageButton skin,powerUp,monedas,gemas,exit;
    private View vistaSkin = (View)findViewById(R.id.vistaSkins);

    public Shop(Context context) {
        this(context, null, 0);
    }

    public Shop(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Shop(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.shop, this);
        skin = (ImageButton) view.findViewById(R.id.skinBtnShop);
        powerUp = (ImageButton) view.findViewById(R.id.powerupBtnShop);
        monedas = (ImageButton) view.findViewById(R.id.monedas);
        gemas = (ImageButton) view.findViewById(R.id.gemas);
        exit = (ImageButton) view.findViewById(R.id.exitBtn);

        final Animation fadein;
        fadein = AnimationUtils.loadAnimation(context, android.R.anim.fade_in);
        fadein.setDuration(200);


        //vistaSkin.setVisibility(View.INVISIBLE);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaSkin.startAnimation(fadein);
                vistaSkin.setVisibility(View.VISIBLE);
            }
        });
    }


}
