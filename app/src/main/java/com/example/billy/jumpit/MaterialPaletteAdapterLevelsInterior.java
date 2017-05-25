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

public class MaterialPaletteAdapterLevelsInterior extends RecyclerView.Adapter<MaterialPaletteAdapterLevelsInterior.PaletteViewHolder> {
    private List<ClassLevel> data;
    RecyclerView list;
    private Player player;
    Context context;
    ArrayList <Integer> imagenes = new ArrayList();
    ImageButton imageLevel;
    int i = 0;

    public MaterialPaletteAdapterLevelsInterior(@NonNull List<ClassLevel> data) {
        this.data = data;
    }

    @Override
    public PaletteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementlevel, parent, false);
        return new PaletteViewHolder(row);
    }

    @Override
    public void onBindViewHolder(PaletteViewHolder holder, int position) {
        player.setNivell(1);
            holder.imageLevel.invalidate();
        if(player.getNivell()>10 && player.getNivell()<16){
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells¡
        }else if(player.getNivell()>20 && player.getNivell()<26){
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
        }else if(player.getNivell()>30 && player.getNivell()<36){
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
        }else if(player.getNivell()>40 && player.getNivell()<46){
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
        }else if(player.getNivell()>50 && player.getNivell()<56){
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
            imagenes.add(R.drawable.audiooff);//Posar imatges dels nivells
        }

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