package com.example.billy.jumpit;

/**
 * Created by DAM on 20/3/17.
 */

import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Skin extends LinearLayout {
    private ImageView imgskin;
    private TextView nameskin;
    private List<ClassSkin> datas;
    private Button button, btnShowSkin;
    private View vistaShowSkin;


    public Skin(Context context) {
        this(context, null, 0);
    }

    public Skin(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Skin(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.skins, this);
        datas = new ArrayList<>();
        datas.add(new ClassSkin("pepe", R.drawable.audiooff));
        datas.add(new ClassSkin("quim", R.drawable.audioon));
        datas.add(new ClassSkin("adrian", R.drawable.audiooff));
        datas.add(new ClassSkin("bily", R.drawable.audiooff));
        datas.add(new ClassSkin("sheila", R.drawable.audiooff));
        //vistaShowSkin = (View) findViewById(R.id.showskin);
        //vistaShowSkin = (View) findViewById(R.id.showskin);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecycleView);
        recyclerView.setAdapter(new MaterialPaletteAdapter(datas));
        //recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));

        //vistaViewSkin();

    }



    /*public void vistaViewSkin(){
        vistaShowSkin.setVisibility(View.INVISIBLE);
        btnShowSkin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vistaShowSkin.setVisibility(View.VISIBLE);
                //invisibleBtn();
            }
        });
    }*/


}
