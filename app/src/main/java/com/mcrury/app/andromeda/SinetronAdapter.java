package com.mcrury.app.andromeda;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class SinetronAdapter extends RecyclerView.Adapter<SinetronHolder> {

    private final List<SinetronModel> dataSinetron;
    private Context context;
    private int itemResource;

    public SinetronAdapter(Context context, int itemResource, List<SinetronModel> dataSinetron) {

        // 1. Konstruktor adapter sinetron
        this.dataSinetron = dataSinetron;
        this.context = context;
        this.itemResource = itemResource;
    }

    // 2. Override method onCreateViewHolder
    @Override
    public SinetronHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // 3. Inflate view lalu return ke ViewHolder
        View view = LayoutInflater.from(parent.getContext())
                .inflate(this.itemResource, parent, false);
        return new SinetronHolder(this.context, view);
    }

    // 4. Override method onBindViewHolder
    @Override
    public void onBindViewHolder(SinetronHolder holder, int position) {

        // 5. Dapatkan posisi untuk mengakses object sinetron
        SinetronModel sinetron = this.dataSinetron.get(position);

        // 6. Bind object sinetron ke holder
        holder.bindSinetron(sinetron);
    }

    @Override
    public int getItemCount() {

        return this.dataSinetron.size();
    }
}