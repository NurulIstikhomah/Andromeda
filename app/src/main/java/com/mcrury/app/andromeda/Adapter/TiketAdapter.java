package com.mcrury.app.andromeda.Adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mcrury.app.andromeda.Model.Tiket;
import com.mcrury.app.andromeda.R;
import com.mcrury.app.andromeda.Rest.ApiClient;

import java.util.List;

public class TiketAdapter extends RecyclerView.Adapter<TiketAdapter.TiketViewHolder> {

    List<Tiket> listTiket;

    public TiketAdapter(List<Tiket> listTiket) {
        this.listTiket = listTiket;
    }

    @Override
    public TiketAdapter.TiketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_tiket, parent,
                false);
        TiketViewHolder mHolder = new TiketViewHolder(view);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(TiketAdapter.TiketViewHolder holder, final int position) {

        holder.tvNamaKereta.setText(listTiket.get(position).getNamaKereta());
        holder.tvTujuan.setText(listTiket.get(position).getTujuan());
        holder.tvTglBerangkat.setText(listTiket.get(position).getTanggalBerangkat());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(view.getContext(), LayarBeliTiket.class);
//                intent.putExtra("id_pembeli", listTiket.get(position).getIdPembeli());
//                intent.putExtra("nama", listTiket.get(position).getNama());
//                intent.putExtra("alamat", listTiket.get(position).getAlamat());
//                intent.putExtra("telp", listTiket.get(position).getTelp());
//                intent.putExtra("photo_url", listTiket.get(position).getPhotoUrl());
//                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listTiket.size();
    }

    public class TiketViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaKereta, tvTujuan, tvTglBerangkat;

        public TiketViewHolder(View itemView) {
            super(itemView);
            tvNamaKereta = (TextView) itemView.findViewById(R.id.tvNamaKereta);
            tvTujuan = (TextView) itemView.findViewById(R.id.tvTujuan);
            tvTglBerangkat = (TextView) itemView.findViewById(R.id.tvTglBerangkat);
        }
    }
}
