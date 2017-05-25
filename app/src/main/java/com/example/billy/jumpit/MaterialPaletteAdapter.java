package com.example.billy.jumpit;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MaterialPaletteAdapter extends RecyclerView.Adapter<MaterialPaletteAdapter.PaletteViewHolder> {
    private List<ClassSkin> data;
    RecyclerView list;
    Context context;
    ArrayList <Integer> imagenes = new ArrayList();
    Button btnskin;
    int i = 0;

    public MaterialPaletteAdapter(@NonNull List<ClassSkin> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public PaletteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View row = LayoutInflater.from(parent.getContext()).inflate(R.layout.elementskin, parent, false);
        return new PaletteViewHolder(row);
    }

    @Override
    public void onBindViewHolder(PaletteViewHolder holder, int position) {
        imagenes.add(R.drawable.audiooff);imagenes.add(R.drawable.audioon);imagenes.add(R.drawable.carro);
        imagenes.add(R.drawable.logros);imagenes.add(R.drawable.opciones);

        ClassSkin color = data.get(position);
        Log.e("Mostrar mierda: ", color.getNombre());
        holder.getTitleTextView().setText(color.getNombre());
        holder.getImageskin().setImageResource(imagenes.get(i));
        holder.getBtnskin();
        i = i+1;
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class PaletteViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private ImageView imageskin;

        public PaletteViewHolder(View elementskin) {
            super(elementskin);
            titleTextView = (TextView) elementskin.findViewById(R.id.nameskin);
            imageskin = (ImageView) elementskin.findViewById(R.id.photoskin);
            btnskin = (Button) elementskin.findViewById(R.id.buttonskin);

            btnskin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("pep", ".........................................");

                    AlertDialog.Builder builder = new AlertDialog.Builder(context);

                    builder.setMessage("Quieres confirmar la compra?")
                            .setTitle("Compra:");
                    builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User clicked OK button
                        }
                    });
                    builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
                    AlertDialog dialog = builder.create();
                    dialog.show();


                }
            });
        }

        public TextView getTitleTextView() {
            return titleTextView;
        }

        public ImageView getImageskin() {
            return imageskin;
        }

        public Button getBtnskin() {
            return btnskin;
        }

    }

    public void pepe(){
        btnskin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}