package com.example.billy.jumpit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by dam on 17/1/17.
 */

public class VistaNiveles extends LinearLayout {

    public VistaNiveles(Context context) {
        this(context, null, 0);
    }

    public VistaNiveles(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VistaNiveles(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.menuniveles, this);
        final View vistaHistoria = (View) findViewById(R.id.listamenulevels);
        vistaHistoria.setVisibility(INVISIBLE);
        Animation fadeout;

        fadeout = AnimationUtils.loadAnimation(context, android.R.anim.fade_out);
        fadeout.setDuration(200);

        ImageButton historia = (ImageButton) findViewById(R.id.btnhistoria);

        historia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaHistoria.setVisibility(VISIBLE);
            }
        });

    }
}
