package com.mcrury.app.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LayarHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layar_home);

        Intent intentpenerima = getIntent();
        String email = intentpenerima.getStringExtra("EXTRA_EMAIL");

        TextView tv_email = (TextView) findViewById(R.id.textView2);

        tv_email.setText(email);
    }
}
