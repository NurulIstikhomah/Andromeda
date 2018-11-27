package com.mcrury.app.andromeda;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mcrury.app.andromeda.Model.GetLogin;
import com.mcrury.app.andromeda.Rest.ApiClient;
import com.mcrury.app.andromeda.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnLogin;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = (EditText) findViewById(R.id.input_email);
        etPassword = (EditText) findViewById(R.id.input_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        // Cek apakah ada status isloggedin = true di shared pref
        // Jika true, maka lanjut ke layar home
        if(this.isLoggedIn()) {
            Intent intent = new Intent(this.getApplicationContext(), LayarHome.class);
            this.startActivity(intent);
        }

        // Login button Click Event
        btnLogin.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String email = etEmail.getText().toString().trim();
                String password = etPassword.getText().toString().trim();

                // Cek form login
                if (!email.isEmpty() && !password.isEmpty()) {
                    // Lakukan login
                    doLogin(email, password);
                } else {
                    // Notif user
                    Toast.makeText(getApplicationContext(),
                            "Isikan email dan password!", Toast.LENGTH_LONG)
                            .show();
                }
            }

        });

    }

    // Untuk mengecek status login
    private boolean isLoggedIn()
    {
        // Cek apakah ada shared pref login
        SharedPreferences pref = getSharedPreferences("TokTikLoginData", MODE_PRIVATE);
        return pref.getBoolean("isloggedin", false);

    }

    // Buka layar home
    private void openHome()
    {
        Intent intent = new Intent(this.getApplicationContext(), LayarHome.class);
        this.startActivity(intent);
    }

    private void saveLogin(String email, String id_pembeli)
    {
        // Simpan data login ke shared pref
        SharedPreferences sharedpref = getSharedPreferences("TokTikLoginData", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();

        // Simpan isloggedin true berupa boolean
        editor.putBoolean("isloggedin", true);
        // Simpan data lainnya berupa string
        editor.putString("email", email);
        editor.putString("id_pembeli", id_pembeli);
        editor.apply();
    }

    // Untuk proses login menggunakan REST
    private void doLogin(final String email,final String password){
        // Panggil request Api
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call loginCall = mApiInterface.loginPembeli(email, password);

        loginCall.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

                // Jika request sukses
                if(response.isSuccessful()){

                    // Buat object model GetLogin dari response
                    GetLogin loginobject = (GetLogin) response.body();
                    String id_pembeli = loginobject.getResult();

                    // Jika status = success (sesuai respon dari REST server)
                    if(loginobject.getStatus().equals("success")){

                        // Simpan data email user ke sharedpref
                        saveLogin(email, id_pembeli);
                        // Buka layar home
                        openHome();

                    } else {
                        Toast.makeText(MainActivity.this,
                                "Email atau password salah",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this,
                            "Error! Coba lagi!",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                // Jika gagal, beri notif
                Toast.makeText(MainActivity.this, "Gagal:" + t.getMessage(), Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }
}
