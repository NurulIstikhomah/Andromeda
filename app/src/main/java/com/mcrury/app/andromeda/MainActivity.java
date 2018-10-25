package com.mcrury.app.andromeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mengubah TextView yang sudah ada di layout xml
        TextView t = findViewById(R.id.tv);
        t.setText("Ini adalah contoh men-set isi TextView dari file java");

    }
}
