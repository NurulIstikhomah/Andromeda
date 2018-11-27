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
import android.widget.Toast;

import com.mcrury.app.andromeda.Model.PostPutDelPembelian;
import com.mcrury.app.andromeda.Model.Tiket;
import com.mcrury.app.andromeda.R;
import com.mcrury.app.andromeda.Rest.ApiClient;
import com.mcrury.app.andromeda.Rest.ApiInterface;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TiketAdapter extends RecyclerView.Adapter<TiketAdapter.TiketViewHolder> {

    List<Tiket> listTiket;
    Context mContext;
    ApiInterface mApiInterface;

    public TiketAdapter(List<Tiket> listTiket, Context mContext) {
        this.listTiket = listTiket;
        this.mContext = mContext;
    }

    @Override
    public TiketAdapter.TiketViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_tiket, parent,
                false);
        TiketViewHolder mHolder = new TiketViewHolder(view, mContext);
        return mHolder;
    }

    @Override
    public void onBindViewHolder(TiketAdapter.TiketViewHolder holder, final int position) {

        holder.tvNamaKereta.setText(listTiket.get(position).getNamaKereta());
        holder.tvTujuan.setText(listTiket.get(position).getTujuan());
        holder.tvTglBerangkat.setText(listTiket.get(position).getTanggalBerangkat());
        holder.tvKuota.setText(listTiket.get(position).getKuota() + " seat");
        holder.tvHarga.setText(listTiket.get(position).getHarga());

    }

    @Override
    public int getItemCount() {
        return listTiket.size();
    }

    public class TiketViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaKereta, tvTujuan, tvTglBerangkat, tvKuota, tvHarga;
        RecyclerView recyclerView;

        public TiketViewHolder(View itemView, final Context mContext) {
            super(itemView);

            tvNamaKereta = (TextView) itemView.findViewById(R.id.tvNamaKereta);
            tvTujuan = (TextView) itemView.findViewById(R.id.tvTujuan);
            tvTglBerangkat = (TextView) itemView.findViewById(R.id.tvTglBerangkat);
            tvKuota = (TextView) itemView.findViewById(R.id.tvKuota);
            tvHarga = (TextView) itemView.findViewById(R.id.tvHarga);

            recyclerView = (RecyclerView) itemView.findViewById(R.id.list_data_tiket);

            mApiInterface = ApiClient.getClient().create(ApiInterface.class);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    // Menggunakan Dialog untuk pembelian Tiket
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
                    alertDialog.setTitle("Beli Tiket Ini?");
                    alertDialog.setMessage("Anda akan membeli tiket jurusan "
                            + listTiket.get(getAdapterPosition()).getTujuan()
                            + " untuk tanggal "
                            + listTiket.get(getAdapterPosition()).getTanggalBerangkat());

                    alertDialog.setNegativeButton("BATAL", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });

                    alertDialog.setPositiveButton("YA, BELI SEKARANG", new DialogInterface
                            .OnClickListener
                            () {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            // Dapatkan tanggal saat ini dengan format 1945-08-17
                            Date tgl = Calendar.getInstance().getTime();
                            SimpleDateFormat df = new SimpleDateFormat("yyyy-M-dd");
                            String hariIni = df.format(tgl);

                            // TODO: dapatkan idPembeli dari Login session
                            // TODO: dapatkan harga Tiket (ubah tabel Tiket dg menambah kolom harga)
                            // Untuk sementara, asumsinya adalah:
                            // idPembeli yang login = 11
                            // totalHarga = 450000

                            // Dapatkan id_pembeli yang login melalui shared pref
                            SharedPreferences pref = mContext.getSharedPreferences
                                    ("TokTikLoginData", Context.MODE_PRIVATE);
                            String idPembeli = pref.getString("id_pembeli", "");

                            Call<PostPutDelPembelian> postPembelianCall = mApiInterface.postPembelian(
                                    idPembeli,
                                    hariIni,
                                    "450000",
                                    listTiket.get(getAdapterPosition()).getIdTiket());

                            postPembelianCall.enqueue(new Callback<PostPutDelPembelian>() {
                                @Override
                                public void onResponse(Call<PostPutDelPembelian> call,
                                                       Response<PostPutDelPembelian> response) {
                                    // Hapus item dari recyclerView dan update list
                                    listTiket.remove(getAdapterPosition());
                                    notifyItemRemoved(getAdapterPosition());
                                    notifyItemRangeChanged(getAdapterPosition(), getItemCount());

                                    // Beri info pembelian berhasil
                                    Toast.makeText(mContext, "Pembelian "
                                            + response.body().getStatus(), Toast.LENGTH_SHORT).show();
                                }

                                @Override
                                public void onFailure(Call<PostPutDelPembelian> call, Throwable t) {
                                    Toast.makeText(mContext, "Pembelian "
                                            + t.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });

                        }
                    });

                    // Tampilkan Dialog
                    AlertDialog dialog = alertDialog.create();
                    dialog.show();

                }
            });
        }
    }
}
