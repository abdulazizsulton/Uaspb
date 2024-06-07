package com.example.uaspb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private EditText etUserName, etName, etKatasandi;
    private TextView tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUserName = findViewById(R.id.etUsername);
        etName = findViewById(R.id.etNama);
        etKatasandi = findViewById(R.id.etKataSandi);
        tvRegister = findViewById(R.id.tvDaftar);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUserName.getText().toString().trim();
                String name = etName.getText().toString().trim();
                String katasandi = etKatasandi.getText().toString().trim();

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}