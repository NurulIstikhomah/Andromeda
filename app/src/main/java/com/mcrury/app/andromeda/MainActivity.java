package com.mcrury.app.andromeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mengubah TextView yang sudah ada di layout xml
        TextView t = findViewById(R.id.tv);
        t.setText("Ini adalah contoh men-set isi TextView dari file java");


        // Membuat ImageView programmatically
        ImageView gambarku = new ImageView(this);
        gambarku.setImageResource(R.drawable.android_png_hd);

        // Membuat LinearLayout
        LinearLayout layoutku = new LinearLayout(this);
        layoutku.setOrientation(LinearLayout.VERTICAL);

        layoutku.setLayoutParams(
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT )
        );

        layoutku.addView(gambarku);

        setContentView(layoutku);

    }
}
