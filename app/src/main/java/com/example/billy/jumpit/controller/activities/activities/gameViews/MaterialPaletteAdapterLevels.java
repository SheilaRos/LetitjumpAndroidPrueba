package com.example.billy.jumpit.controller.activities.activities.gameViews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.billy.jumpit.R;
import com.example.billy.jumpit.model.ClassLevel;
import com.example.billy.jumpit.model.User;

import java.util.ArrayList;
import java.util.List;

public class MaterialPaletteAdapterLevels extends RecyclerView.Adapter<MaterialPaletteAdapterLevels.PaletteViewHolder> {
    private List<ClassLevel> data;
    RecyclerView list;
    private User user = new User();
    Context context;
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
        holder.text.setText("nivell"+position);
        holder.getImageLevel();
        i = i+1;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PaletteViewHolder extends RecyclerView.ViewHolder {
        ImageButton imageLevel;
        TextView text;

        public PaletteViewHolder(View elementskin) {
            super(elementskin);
            imageLevel = (ImageButton) elementskin.findViewById(R.id.photolevel);
            text = (TextView) elementskin.findViewById(R.id.textlevelid);

            imageLevel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Log.d("nivell:---->", text.getText().toString());
                }
            });

        }

        public ImageButton getImageLevel() { return imageLevel; }
        public TextView getText() {
            return text;
        }

    }
}