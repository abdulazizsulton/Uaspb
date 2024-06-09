package com.example.uaspb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.uaspb.data.SessionManager;

public class SplasActivity extends AppCompatActivity {
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splas);

        sessionManager = new SessionManager(SplasActivity.this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!sessionManager.isLoggedIn()) {
                    moveToLogin();
                } else {
                    Intent intent = new Intent(SplasActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        },2000);
    }

    private void moveToLogin() {
        Intent intent = new Intent(SplasActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}