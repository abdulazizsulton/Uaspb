package com.example.uaspb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText etUserName, etKatasandi;
    private TextView tvLoginn, tvDaftarr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUserName = findViewById(R.id.etUsername);
        etKatasandi = findViewById(R.id.etKataSandi);
        tvLoginn = findViewById(R.id.tvLogin);
        tvDaftarr = findViewById(R.id.tvDaftar);

        tvLoginn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUserName.getText().toString().trim();
                String katasandi = etKatasandi.getText().toString().trim();

                Intent intent = new Intent(LoginActivity.this, InfoActivity.class);
                startActivity(intent);
                finish();
            }
        });

        tvDaftarr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}