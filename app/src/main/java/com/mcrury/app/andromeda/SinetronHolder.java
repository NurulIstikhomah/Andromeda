package com.mcrury.app.andromeda;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SinetronHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private final ImageView sinetronImage;
    private final TextView sinetronJudul;
    private final TextView sinetronDeskripsi;

    private SinetronModel sinetron;
    private Context context;

    public SinetronHolder(Context context, View itemView) {

        super(itemView);

        // 1. Set context
        this.context = context;

        // 2. Inflate UI widgets
        this.sinetronImage = (ImageView) itemView.findViewById(R.id.listview_image);
        this.sinetronJudul = (TextView) itemView.findViewById(R.id.listview_item_judul);
        this.sinetronDeskripsi = (TextView) itemView.findViewById(R.id.listview_item_deskripsi);

        // 3. Set "onClick" listener
        itemView.setOnClickListener(this);
    }

    public void bindSinetron(SinetronModel sinetron) {

        // 4. Set (bind) item data sinetron ke ViewHolder
        this.sinetron = sinetron;
        this.sinetronJudul.setText(sinetron.getNama());
        this.sinetronDeskripsi.setText(sinetron.getDeskripsi());
        this.sinetronImage.setImageResource(sinetron.getImageResourceId());
    }

    @Override
    public void onClick(View v) {

        // 5. Handle onClick event untuk ViewHolder
        if (this.sinetron != null) {

            // 6. Passing data ke intent
            Intent intent = new Intent(context, LayarDetail.class);
            intent.putExtra(LayarDetail.EXTRA_SINEID, getLayoutPosition());
            context.startActivity(intent);

        }
    }
}