package com.mcrury.app.andromeda;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class LayarHome extends AppCompatActivity {

    RelativeLayout btnTicketList, btnMyTicket;

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

        btnMyTicket = findViewById(R.id.btnMyTiket);
        btnMyTicket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(getApplicationContext(), LayarMyTiket.class);
                startActivity(mIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_aplikasi, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent mIntent;
        switch (item.getItemId()) {

            case R.id.menuLogout:

                SharedPreferences pref = getSharedPreferences("TokTikLoginData", MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();

                editor.clear();
                editor.apply();

                mIntent = new Intent(this, MainActivity.class);
                startActivity(mIntent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
