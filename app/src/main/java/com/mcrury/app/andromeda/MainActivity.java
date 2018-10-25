package com.mcrury.app.andromeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogData("Ini event onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

        LogData("Ini event onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        LogData("Ini event onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();

        LogData("Ini event onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        LogData("Ini event onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        LogData("Ini event onDestroy");
    }

    void LogData(String data) {
        Toast.makeText(MainActivity.this, data, Toast.LENGTH_SHORT).show();
        Log.d("TAG_ACTIVITY", data);
    }
}
