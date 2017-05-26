package com.example.billy.jumpit.controller.activities.gameViews;

import android.content.Context;
import android.content.DialogInterface;
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

import com.example.billy.jumpit.R;
import com.example.billy.jumpit.model.ClassPowerUp;

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

    public MaterialPaletteAdapterPU(@NonNull List<ClassPowerUp> data, Context context) {
        this.data = data;
        this.context = context;
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
        holder.getBtnpowerup();
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
        private Button btnpowerup;


        public PaletteViewHolder(View elementskin) {
            super(elementskin);
            titleTextView = (TextView) elementskin.findViewById(R.id.namepowerup);
            imagePowerUp = (ImageView) elementskin.findViewById(R.id.photopowerup);
            textPowerUp = (TextView) elementskin.findViewById(R.id.textpowerup);
            btnpowerup = (Button) elementskin.findViewById(R.id.buttonpowerup);

            btnpowerup.setOnClickListener(new View.OnClickListener() {
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
            return imagePowerUp;
        }

        public TextView getTextPowerUp() {
            return textPowerUp;
        }

        public Button getBtnpowerup() {
            return btnpowerup;
        }

    }


}
