package com.example.billy.jumpit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MaterialPaletteAdapterGems extends RecyclerView.Adapter<MaterialPaletteAdapterGems.PaletteViewHolder> {
    private List<ClassGems> data;
    RecyclerView list;
    Context context;
    RelativeLayout fondo;
    ArrayList <Integer> imagenes = new ArrayList();
    Button btnskin;

    public MaterialPaletteAdapterGems(@NonNull List<ClassGems> data) {
        this.data = data;
    }

    @Override
    public PaletteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementgems, parent, false);
        return new PaletteViewHolder(row);
    }

    @Override
    public void onBindViewHolder(PaletteViewHolder holder, int position) {
        imagenes.add(R.drawable.audiooff);imagenes.add(R.drawable.audioon);imagenes.add(R.drawable.carro);
        imagenes.add(R.drawable.logros);

        ClassGems color = data.get(position);
        holder.getFondo().setBackgroundResource(imagenes.get(position));
        holder.getImagebutton();
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PaletteViewHolder extends RecyclerView.ViewHolder {
        private RelativeLayout fondo;
        private Button imagebutton;

        public PaletteViewHolder(View elementskin) {
            super(elementskin);
            fondo = (RelativeLayout) itemView.findViewById(R.id.fondo);
            imagebutton = (Button) itemView.findViewById(R.id.buttongems);
        }

        public RelativeLayout getFondo() {
            return fondo;
        }

        public Button getImagebutton() {
            return imagebutton;
        }

    }

}