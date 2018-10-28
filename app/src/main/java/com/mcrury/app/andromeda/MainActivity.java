package com.mcrury.app.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void klikLogin(View view) {
        Intent intentpengirim = new Intent(this, LayarHome.class);

        EditText et_email = (EditText)findViewById(R.id.input_email);
        String inputemail = et_email.getText().toString();

        intentpengirim.putExtra("EXTRA_EMAIL",inputemail);

        startActivity(intentpengirim);
    }
}
