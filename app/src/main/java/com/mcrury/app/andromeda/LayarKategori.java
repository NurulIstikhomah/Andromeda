package com.mcrury.app.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LayarKategori extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_kategori);

        // Menyiapkan array SinetronModel dlm layout simple_list_item_1
        ArrayAdapter<SinetronModel> listAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, SinetronModel.drama);

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
