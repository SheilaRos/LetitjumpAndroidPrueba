package com.example.billy.jumpit;

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

import java.util.ArrayList;
import java.util.List;

public class Levels extends LinearLayout {
    private List<ClassLevel> datas;

    public Levels(Context context) {
        this(context, null, 0);
    }

    public Levels(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Levels(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.levels, this);

        datas = new ArrayList<>();
        datas.add(new ClassLevel(R.drawable.audiooff));
        datas.add(new ClassLevel(R.drawable.audiooff));
        datas.add(new ClassLevel(R.drawable.audiooff));
        datas.add(new ClassLevel(R.drawable.audiooff));
        datas.add(new ClassLevel(R.drawable.audiooff));


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecycleViewLevel);
        recyclerView.setAdapter(new MaterialPaletteAdapterLevels(datas));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

    }

}
