package com.example.uaspb;



import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;

import com.example.uaspb.data.SessionManager;
import com.example.uaspb.databinding.ActivityHomelogBinding;

public class HomelogActivity extends AppCompatActivity {

    SessionManager sessionManager;
    String usernameMain, nameMain;

    private ActivityHomelogBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomelogBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sessionManager = new SessionManager(HomelogActivity.this);
        if (!sessionManager.isLoggedIn()) {
            moveToLogin();
        }

        usernameMain = sessionManager.getUserDetail().get(SessionManager.USERNAME);
        nameMain = sessionManager.getUserDetail().get(SessionManager.NAME);

        binding.tvUsername.setText(usernameMain);
        binding.tvName.setText(nameMain);
    }

    private void moveToLogin() {
        Intent intent = new Intent(HomelogActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}
