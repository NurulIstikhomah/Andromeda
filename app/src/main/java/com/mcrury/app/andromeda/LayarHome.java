package com.mcrury.app.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class LayarHome extends AppCompatActivity {

    RelativeLayout btnTicketList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_home);

        // Membuat listener on click
        btnTicketList = findViewById(R.id.btnListTiket);
        btnTicketList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), LayarListTiket.class);
                startActivity(mIntent);
            }
        });

        // Memasukkan listener ke list kategori

    }

}
