package com.example.billy.jumpit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MaterialPaletteAdapterLevels extends RecyclerView.Adapter<MaterialPaletteAdapterLevels.PaletteViewHolder> {
    private List<ClassLevel> data;
    RecyclerView list;
    private Player player = new Player();
    Context context;
    ImageButton imageLevel;
    ArrayList <Integer> imagenes = new ArrayList();
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
        imagenes.add(R.drawable.audiooff);imagenes.add(R.drawable.audioon);imagenes.add(R.drawable.carro);
        imagenes.add(R.drawable.logros);imagenes.add(R.drawable.opciones);
        ClassLevel objecte = data.get(position);
        holder.getImageLevel().setBackgroundResource(imagenes.get(position));
        i = i+1;


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PaletteViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private ImageButton imageLevel;

        public PaletteViewHolder(View elementskin) {
            super(elementskin);
            imageLevel = (ImageButton) itemView.findViewById(R.id.photolevel);
        }

        public TextView getTitleTextView() {
            return titleTextView;
        }

        public ImageButton getImageLevel() { return imageLevel; }
    }
}