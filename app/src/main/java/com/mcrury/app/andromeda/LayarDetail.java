package com.mcrury.app.andromeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class LayarDetail extends AppCompatActivity {

    public static final String EXTRA_SINEID = "dataNo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_detail);

        // Mendapatkan data
        int dataNo = (Integer)getIntent().getExtras().get(EXTRA_SINEID);
        SinetronModel sinetron = SinetronModel.drama[dataNo];

        // Menampilkan gambar
        ImageView photo = (ImageView)findViewById(R.id.foto);
        photo.setImageResource(sinetron.getImageResourceId());
        // ContentDescription ini untuk aksesibilitas
        photo.setContentDescription(sinetron.getNama());

        // Menampilkan judul
        TextView name = (TextView)findViewById(R.id.judul);
        name.setText(sinetron.getNama());

        // Menampilkan deskripsi
        TextView description = (TextView)findViewById(R.id.deskripsi);
        description.setText(sinetron.getDeskripsi());
    }
}
