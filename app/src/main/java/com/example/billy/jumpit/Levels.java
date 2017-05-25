package com.example.billy.jumpit;

/**
 * Created by DAM on 20/3/17.
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Levels extends LinearLayout {
    private List<ClassLevel> datas;
    private ImageButton image1;
    private ImageButton image2;
    private ImageButton image3;
    private ImageButton image4;
    private ImageButton image5;

    private TextView text1;
    private TextView text2;
    private TextView text3;
    private TextView text4;
    private TextView text5;


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
        datas.add(new ClassLevel("nivell1", image1, text1));
        datas.add(new ClassLevel("nivell2", image2, text2));
        datas.add(new ClassLevel("nivell3", image3, text3));
        datas.add(new ClassLevel("nivell4", image4, text4));
        datas.add(new ClassLevel("nivell5", image5, text5));


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecycleViewLevel);
        recyclerView.setAdapter(new MaterialPaletteAdapterLevels(datas));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
    }
}
