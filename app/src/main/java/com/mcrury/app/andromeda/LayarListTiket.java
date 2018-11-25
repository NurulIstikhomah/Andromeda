package com.mcrury.app.andromeda;

import android.content.Context;
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
        Call<GetTiket> mTiketCall = mApiInterface.getTiket();
        mTiketCall.enqueue(new Callback<GetTiket>() {
            @Override
            public void onResponse(Call<GetTiket> call, Response<GetTiket> response) {
                Log.d("GetTiket",String.valueOf(response.body().getResult()));

                List<Tiket> listTiket = response.body().getResult();
                mAdapter = new TiketAdapter(listTiket);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetTiket> call, Throwable t) {
                Log.d("Get Pembeli",t.getMessage());
            }
        });
    }
}
