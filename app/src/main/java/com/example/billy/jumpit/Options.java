package com.example.billy.jumpit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by dam on 17/1/17.
 */

public class Options extends LinearLayout {
    public Options(Context context) {
        this(context, null, 0);
    }

    public Options(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Options(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater =
                (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.options, this);
    }
}
