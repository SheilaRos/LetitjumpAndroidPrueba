package com.example.billy.jumpit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MaterialPaletteAdapterLevels extends RecyclerView.Adapter<MaterialPaletteAdapterLevels.PaletteViewHolder> {
    private List<ClassLevel> data;
    RecyclerView list;
    Context context;
    ArrayList <Integer> imagenes = new ArrayList();
    ImageButton imageLevel;
    int i = 0;

    public MaterialPaletteAdapterLevels(@NonNull List<ClassLevel> data) {
        this.data = data;
    }

    @Override
    public PaletteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementlevel, parent, false);
        return new PaletteViewHolder(row);
    }

    @Override
    public void onBindViewHolder(PaletteViewHolder holder, int position) {
        imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
        imagenes.add(R.drawable.opciones);//Posar imatges dels nivells
        imagenes.add(R.drawable.carro);//Posar imatges dels nivells
        imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
        imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells

        holder.imageLevel.setBackgroundResource(imagenes.get(i));
        i = i+1;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PaletteViewHolder extends RecyclerView.ViewHolder {
        ImageButton imageLevel;

        public PaletteViewHolder(View elementskin) {
            super(elementskin);
            imageLevel = (ImageButton) itemView.findViewById(R.id.photolevel);
        }


        public ImageButton getImageLevel() {
            return getImageLevel();
        }


    }
}