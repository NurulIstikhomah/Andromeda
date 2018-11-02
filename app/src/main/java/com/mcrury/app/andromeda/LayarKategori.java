package com.mcrury.app.andromeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class LayarKategori extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_kategori);

        List<SinetronModel> aList = new ArrayList<>();
        // Iterasi untuk setiap item dari data sinetron
        for (int i = 0; i < SinetronModel.drama.length; i++) {
            // Mendapatkan data dari class SinetronModel
            aList.add(SinetronModel.drama[i]);
        }

        // Memanggil RecyclerView
        RecyclerView listSinetron = (RecyclerView) findViewById(R.id.list_data);
        SinetronAdapter listAdapter = new SinetronAdapter(this, R.layout.list_item_layout,
                aList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        // Memasukkan array SinetronModel ke ListView
        listSinetron.setLayoutManager(layoutManager);

        // Memasukkan array SinetronModel ke ListView
        listSinetron.setAdapter(listAdapter);

    }
}
