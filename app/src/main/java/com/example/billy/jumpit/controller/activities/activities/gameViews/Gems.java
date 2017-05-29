package com.example.billy.jumpit.controller.activities.activities.gameViews;

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
import com.example.billy.jumpit.model.ClassGems;

import java.util.ArrayList;
import java.util.List;

public class Gems extends LinearLayout {

    private List<ClassGems> datas;

    public Gems(Context context) {
        this(context, null, 0);
    }

    public Gems(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Gems(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.gems, this);

        datas = new ArrayList<>();
        datas.add(new ClassGems(R.drawable.audiooff));
        datas.add(new ClassGems(R.drawable.audioon));
        datas.add(new ClassGems( R.drawable.audiooff));
        datas.add(new ClassGems(R.drawable.audiooff));


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecycleViewGEMS1);
        recyclerView.setAdapter(new MaterialPaletteAdapterGems(datas, context));
        //recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setHorizontalScrollBarEnabled(false);
        RecyclerView recyclerView2 = (RecyclerView) findViewById(R.id.RecycleViewGEMS2);
        recyclerView2.setAdapter(new MaterialPaletteAdapterGems(datas, context));
        //recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView2.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView2.setHorizontalScrollBarEnabled(false);
    }

}
