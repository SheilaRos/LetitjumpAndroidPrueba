package com.example.billy.jumpit.controller.activities.activities.gameViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.example.billy.jumpit.R;

public class Options extends LinearLayout implements SeekBar.OnSeekBarChangeListener {
    private int value, min, max;
    private SeekBar seekBar;
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
        seekBar = (SeekBar) view.findViewById(R.id.volumeBar);
        seekBar.setOnSeekBarChangeListener(this);
        setMin(0);
        setMax(100);
        setValue(100);
    }
    private SeekBar.OnSeekBarChangeListener listener;
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener listener) {
        this.listener = listener;
    }
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        this.setValue(i);
        if (listener != null) listener.onProgressChanged(seekBar, this.value, true);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < this.min) value = this.min;
        if (value > this.max) value = this.max;
        this.value = value;
        seekBar.setProgress(value);
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
        int rang = this.max - this.min;
        seekBar.setMax(rang);
        if (this.value < this.min) this.setValue(this.min);
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
        int rang = this.max - this.min;
        seekBar.setMax(rang);
        if (this.value > this.max) this.setValue(this.max);
    }
}
