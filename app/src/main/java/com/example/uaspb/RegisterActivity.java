package com.example.uaspb;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uaspb.api.ApiConfig;
import com.example.uaspb.api.ApiService;
import com.example.uaspb.response.register.Register;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUsernameRegister;
    private EditText etNamaRegister;
    private EditText etKataSandiRegister;
    private TextView tvDaftar;
    private TextView tvSudahAdaAkun;
    ApiService apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsernameRegister = findViewById(R.id.etUsernameRegister);
        etNamaRegister = findViewById(R.id.etNamaRegister);
        etKataSandiRegister = findViewById(R.id.etKataSandiRegister);
        tvDaftar = findViewById(R.id.tvDaftar);
        tvSudahAdaAkun = findViewById(R.id.tvSudahAdaAkun);

        tvDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsernameRegister.getText().toString();
                String name = etNamaRegister.getText().toString();
                String password = etKataSandiRegister.getText().toString();

                if (username.isEmpty()) {
                    etUsernameRegister.setError("ISI KOCAK");
                } else if (name.isEmpty()) {
                    etNamaRegister.setError("ISI KOCAK");
                } else if (password.isEmpty()) {
                    etKataSandiRegister.setError("ISI KOCAK");
                } else {
                    register(username, name, password);
                }
            }
        });

        tvSudahAdaAkun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void register(String username, String name, String password) {
        apiInterface = ApiConfig.getClient().create(ApiService.class);
        Call<Register> registerCall = apiInterface.register(username, name, password);
        registerCall.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterActivity.this, HomelogActivity.class); // Redirect to HomeActivity
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
