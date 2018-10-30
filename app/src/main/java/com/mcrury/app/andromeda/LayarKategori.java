package com.mcrury.app.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class LayarKategori extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_kategori);

        // ArrayAdapter digantikan SimpleAdapter karena bisa membawa beberapa data sekaligus dari
        // sebuah item dalam array, yakni image, judul dan deskripsinya tiap item sinetron (melalui
        // HashMap). Sedangkan ArrayAdapter sendiri hanya bisa menampung 1 data saja, misalnya
        // judul saja, atau deskripsinya saja.
        // Idealnya, untuk memakai ArrayAdapter pada layout yang kompleks, perlu dibuatkan custom
        // adapter tersendiri supaya dapat menangani beberapa data dari tiap item array.
        // Singkatnya, SimpleAdapter dapat dipakai sebagai alternatif tanpa perlu membuat custom
        // adapter tersendiri.

        // Menyiapkan array SinetronModel dlm layout simple_list_item_1
        // ArrayAdapter<SinetronModel> listAdapter = new ArrayAdapter<>(
        //        this, android.R.layout.simple_list_item_1, SinetronModel.drama);

        List<SinetronModel> aList = new ArrayList<>();
        // Iterasi untuk setiap item dari data sinetron
        for (int i = 0; i < SinetronModel.drama.length; i++) {
            // Mendapatkan data dari class SinetronModel
            aList.add(SinetronModel.drama[i]);
        }

        // Memanggil ListView
        ListView listSinetron = (ListView) findViewById(R.id.list_data);
        SinetronAdapter listAdapter = new SinetronAdapter(this, R.layout.list_item_layout,
                aList);

        // Memasukkan array SinetronModel ke ListView
        listSinetron.setAdapter(listAdapter);

        // Membuat listener on click setiap item untuk menuju layar detail
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listSinetron, View itemView, int position, long
                    id) {

                // Passing data ke intent
                Intent intent = new Intent(LayarKategori.this, LayarDetail.class);
                intent.putExtra(LayarDetail.EXTRA_SINEID, (int) id);
                startActivity(intent); }
        };
        // Menugaskan listener ke ListView
        listSinetron.setOnItemClickListener(itemClickListener);
    }
}
