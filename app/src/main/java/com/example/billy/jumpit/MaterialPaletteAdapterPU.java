package com.example.billy.jumpit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lolrol1 on 14/5/17.
 */

public class MaterialPaletteAdapterPU extends RecyclerView.Adapter<MaterialPaletteAdapterPU.PaletteViewHolder> {
    private List<ClassPowerUp> data;
    RecyclerView list;
    Context context;
    ArrayList<Integer> imagenes = new ArrayList();
    Button btnskin;
    int i = 0;

    public MaterialPaletteAdapterPU(@NonNull List<ClassPowerUp> data) {
        this.data = data;
    }

    @Override
    public MaterialPaletteAdapterPU.PaletteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementpowerup, parent, false);
        return new PaletteViewHolder(row);
    }

    @Override
    public void onBindViewHolder(MaterialPaletteAdapterPU.PaletteViewHolder holder, int position) {
        imagenes.add(R.drawable.audiooff);imagenes.add(R.drawable.audioon);imagenes.add(R.drawable.carro);
        imagenes.add(R.drawable.logros);imagenes.add(R.drawable.opciones);

        ClassPowerUp color = data.get(position);
        holder.getTitleTextView().setText(color.getNombre());
        holder.getImageskin().setImageResource(imagenes.get(i));
        holder.getTextPowerUp().setText(color.getDescripcion());
        i = i+1;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PaletteViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private ImageView imagePowerUp;
        private TextView textPowerUp;


        public PaletteViewHolder(View elementskin) {
            super(elementskin);
            titleTextView = (TextView) itemView.findViewById(R.id.namepowerup);
            imagePowerUp = (ImageView) itemView.findViewById(R.id.photopowerup);
            textPowerUp = (TextView) itemView.findViewById(R.id.textpowerup);
        }

        public TextView getTitleTextView() {
            return titleTextView;
        }

        public ImageView getImageskin() {
            return imagePowerUp;
        }

        public TextView getTextPowerUp() {
            return textPowerUp;
        }

    }


}
