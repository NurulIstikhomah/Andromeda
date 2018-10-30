package com.mcrury.app.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class LayarHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_home);

        // Membuat listener on click
        AdapterView.OnItemClickListener itemClickListener = new AdapterView
                .OnItemClickListener(){

            public void onItemClick(AdapterView<?> listView, View itemView, int position, long
                    id) {
                // Membuat item click untuk kategori Drama (posisinya 1, lihat di array
                // kategori_data di file strings.xml)
                if(position == 1) {
                    Intent intent = new Intent(LayarHome.this, LayarKategori.class);
                    startActivity(intent);
                }
            }
        };

        // Memasukkan listener ke list kategori
        ListView listView = (ListView) findViewById(R.id.lv_kategori_street_food);
        listView.setOnItemClickListener (itemClickListener);

    }

}
