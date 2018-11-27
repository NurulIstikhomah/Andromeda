package com.mcrury.app.andromeda;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mcrury.app.andromeda.Adapter.TiketAdapter;
import com.mcrury.app.andromeda.Model.GetTiket;
import com.mcrury.app.andromeda.Model.Tiket;
import com.mcrury.app.andromeda.Rest.ApiClient;
import com.mcrury.app.andromeda.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarListTiket extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Context mContext;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_list_tiket);

        mContext = getApplicationContext();
        mRecyclerView = (RecyclerView) findViewById(R.id.list_data_tiket);
        mLayoutManager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(mLayoutManager);

        dapatkanData();

    }

    private void dapatkanData() {
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        // Dapatkan idPembeli dari shared pref,
        SharedPreferences pref = getSharedPreferences("TokTikLoginData", MODE_PRIVATE);
        String idPembeli = pref.getString("id_pembeli", "");

        // Sehingga, kita bisa dapatkan tiket yang tersedia buat user yang sedang login
        // jangan lupa, buat juga fungsi available_post() pada REST Server yang menangkap id Pembeli
        Call<GetTiket> mTiketCall = mApiInterface.getTiketforPembeli(idPembeli);
        mTiketCall.enqueue(new Callback<GetTiket>() {
            @Override
            public void onResponse(Call<GetTiket> call, Response<GetTiket> response) {
                Log.d("GetTiket",String.valueOf(response.body().getResult()));

                List<Tiket> listTiket = response.body().getResult();
                // Dapatkan adapter listTiket dengan parameter tambahan Context
                // (karena ada AlertDialog)
                mAdapter = new TiketAdapter(listTiket, LayarListTiket.this);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetTiket> call, Throwable t) {
                Log.d("Get Pembeli",t.getMessage());
            }
        });
    }
}
