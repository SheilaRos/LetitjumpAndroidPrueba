package com.example.billy.jumpit;

/**
 * Created by DAM on 20/3/17.
 */

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class PowerUp extends LinearLayout {

    public PowerUp(Context context) {
        this(context, null, 0);
    }

    public PowerUp(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PowerUp(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.powerup, this);
    }

}
