package com.mcrury.app.andromeda;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mcrury.app.andromeda.Adapter.MyTiketAdapter;
import com.mcrury.app.andromeda.Model.GetMyTiket;
import com.mcrury.app.andromeda.Model.MyTiket;
import com.mcrury.app.andromeda.Rest.ApiClient;
import com.mcrury.app.andromeda.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LayarMyTiket extends AppCompatActivity {

    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    Context mContext;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_my_tiket);

        mContext = getApplicationContext();
        mRecyclerView = (RecyclerView) findViewById(R.id.list_data_mytiket);
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
        Call<GetMyTiket> mMyTiketCall = mApiInterface.getMyTiket(idPembeli);
        mMyTiketCall.enqueue(new Callback<GetMyTiket>() {
            @Override
            public void onResponse(Call<GetMyTiket> call, Response<GetMyTiket> response) {
                Log.d("GetMyTiket",String.valueOf(response.body().getResult()));

                List<MyTiket> listTiket = response.body().getResult();
                // Dapatkan adapter listTiket dengan parameter tambahan Context
                // (karena ada AlertDialog)
                mAdapter = new MyTiketAdapter(listTiket, LayarMyTiket.this);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetMyTiket> call, Throwable t) {
                Log.d("GetMyTiket",t.getMessage());
            }
        });
    }
}
