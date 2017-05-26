package com.example.billy.jumpit.controller.activities.gameViews;

/**
 * Created by DAM on 20/3/17.
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.billy.jumpit.R;
import com.example.billy.jumpit.controller.activities.gameViews.MaterialPaletteAdapterPU;
import com.example.billy.jumpit.model.ClassPowerUp;

import java.util.ArrayList;
import java.util.List;

public class PowerUp extends LinearLayout {
    private List<ClassPowerUp> datas;

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

        datas = new ArrayList<>();
        datas.add(new ClassPowerUp("pepe", R.drawable.audiooff, "EL PUTO AMO"));
        datas.add(new ClassPowerUp("quim", R.drawable.audioon, " Te hace ser dios en el rocketleage"));
        datas.add(new ClassPowerUp("adrian", R.drawable.audiooff, "ES GOROOOOOOOOO"));
        datas.add(new ClassPowerUp("bily", R.drawable.audiooff, "GOD WITH XERATH"));
        datas.add(new ClassPowerUp("sheila", R.drawable.audiooff, "YOLO POWER"));


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecycleViewPU);
        recyclerView.setAdapter(new MaterialPaletteAdapterPU(datas, context));
        //recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHorizontalScrollBarEnabled(false);

    }

}
