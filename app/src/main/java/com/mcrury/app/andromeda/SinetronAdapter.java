package com.mcrury.app.andromeda;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SinetronAdapter extends ArrayAdapter<SinetronModel> {

    private final List<SinetronModel> dataSinetron;
    private Context context;
    private int itemResource;

    public SinetronAdapter(Context context, int itemResource, List<SinetronModel> dataSinetron) {

        // 1. Konstruktor adapter sinetron
        super(context, R.layout.list_item_layout, dataSinetron);
        this.dataSinetron = dataSinetron;
        this.context = context;
        this.itemResource = itemResource;
    }

    @Override
    public View getView(int position, View myView, ViewGroup parent) {

        View itemView;
        // 2. Apakah view sudah diisi (inflated)?
        if (myView != null) {
            // 2a. Jika sudah, tinggal pakai
            itemView = myView;
        }
        else {
            // 2b. Jika belum, isi/inflate
            LayoutInflater inflater = LayoutInflater.from(getContext());
            itemView = inflater.inflate(this.itemResource, parent, false);
        }

        // 3. Tampilkan item data sinetron
        SinetronModel sinetron = this.dataSinetron.get(position);

        if (sinetron != null) {

            // 4. Inflate UI widgets yang dibutuhkan
            ImageView sinetronImage = (ImageView) itemView.findViewById(R.id.listview_image);
            TextView sinetronJudul = (TextView) itemView.findViewById(R.id.listview_item_judul);
            TextView sinetronDeskripsi = (TextView) itemView.findViewById(R.id
                    .listview_item_deskripsi);

            // 5. Set UI widgets dengan data dari SinetronModel
            sinetronJudul.setText(sinetron.getNama());
            sinetronDeskripsi.setText(sinetron.getDeskripsi());
            sinetronImage.setImageResource(sinetron.getImageResourceId());
        }

        return itemView;
    }
}