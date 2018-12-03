package com.mcrury.app.andromeda.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mcrury.app.andromeda.Model.MyTiket;
import com.mcrury.app.andromeda.R;
import com.mcrury.app.andromeda.Rest.ApiClient;
import com.mcrury.app.andromeda.Rest.ApiInterface;

import java.util.List;

public class MyTiketAdapter extends RecyclerView.Adapter<MyTiketAdapter.MyTiketViewHolder> {

    List<MyTiket> listTiket;
    Context mContext;
    ApiInterface mApiInterface;

    public MyTiketAdapter(List<MyTiket> listTiket, Context mContext) {
        this.listTiket = listTiket;
        this.mContext = mContext;
    }

    @Override
    public MyTiketAdapter.MyTiketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_mytiket,
                parent,
                false);
        MyTiketViewHolder mHolder = new MyTiketViewHolder(view, mContext);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(MyTiketAdapter.MyTiketViewHolder holder, final int position) {

        holder.tvNamaKereta.setText(listTiket.get(position).getNamaKereta());
        holder.tvTujuan.setText(listTiket.get(position).getTujuan());
        holder.tvTglBerangkat.setText(listTiket.get(position).getTanggalBerangkat());
        holder.tvTglBeli.setText("Dibeli " + listTiket.get(position).getTglBeli());
        holder.tvHarga.setText(listTiket.get(position).getHarga());

    }

    @Override
    public int getItemCount() {
        return listTiket.size();
    }

    public class MyTiketViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaKereta, tvTujuan, tvTglBerangkat, tvTglBeli, tvHarga;
        RecyclerView recyclerView;

        public MyTiketViewHolder(View itemView, final Context mContext) {
            super(itemView);

            tvNamaKereta = (TextView) itemView.findViewById(R.id.tvNamaKereta);
            tvTujuan = (TextView) itemView.findViewById(R.id.tvTujuan);
            tvTglBerangkat = (TextView) itemView.findViewById(R.id.tvTglBerangkat);
            tvTglBeli = (TextView) itemView.findViewById(R.id.tvTglBeli);
            tvHarga = (TextView) itemView.findViewById(R.id.tvHarga);

            recyclerView = (RecyclerView) itemView.findViewById(R.id.list_data_mytiket);

            mApiInterface = ApiClient.getClient().create(ApiInterface.class);


        }
    }
}
