package com.mcrury.app.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
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

        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        // Iterasi untuk setiap item dari data sinetron
        for (int i = 0; i < SinetronModel.drama.length; i++) {
            // Mendapatkan data dari class SinetronModel
            SinetronModel sinetron = SinetronModel.drama[i];

            // Mendapatkan deskripsi singkat, dengan memotong 50 karakter dari deskripsi
            String deskripsi_singkat = sinetron.getDeskripsi().substring(0,50);

            // Memasangkan nama, deskripsi, dan image ke key sementara
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("item_judul", sinetron.getNama());
            hm.put("item_deskripsi", deskripsi_singkat);
            hm.put("item_image", Integer.toString(sinetron.getImageResourceId()));
            aList.add(hm);
        }
        // Mapping dari HashMap untuk dihubungkan dengan TextView di layout (sesuai id TextView-nya)
        String[] dari = {"item_image", "item_judul", "item_deskripsi"};
        int[] ke = {R.id.listview_image, R.id.listview_item_judul, R.id.listview_item_deskripsi};

        // Memasukkan pasangan data-TextView ke ke layout list_item_layout
        SimpleAdapter listAdapter = new SimpleAdapter(this, aList, R.layout.list_item_layout,
                dari, ke);

        // Memanggil ListView
        ListView listSinetron = (ListView) findViewById(R.id.list_data);

        // Memasukkan array SinetronModel ke ListView
        listSinetron.setAdapter(listAdapter);

        // Membuat listener on click setiap item untuk menuju layar detail
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            public void onItemClick(AdapterView<?> listDrinks, View itemView, int position, long
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
