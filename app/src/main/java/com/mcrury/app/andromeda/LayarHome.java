package com.mcrury.app.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

    public void klikShare(View view) {

        // Membuat intent dengan parameter ACTION_SEND untuk mengirim info ke aplikasi lain
        Intent intentpengirim = new Intent(Intent.ACTION_SEND);

        // Sebagai contoh, kita kirimkan textview alamat email
        TextView et_email = (TextView)findViewById(R.id.textView2);
        String inputemail = et_email.getText().toString();

        // Set tipe data email
        intentpengirim.setType("text/plain");

        // Memasukkan data email ke intent
        intentpengirim.putExtra(Intent.EXTRA_TEXT,inputemail);

        // Android akan menampilkan opsi aplikasi apa saja yang bisa menerima data text/plain
        startActivity(intentpengirim);
    }
}
