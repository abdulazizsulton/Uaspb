package com.example.uaspb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.uaspb.data.SessionManager;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private ProfileFragment profileFragment = new ProfileFragment();
    private UnggahFragment unggahFragment = new UnggahFragment();
    private GaleriFragment galeriFragment = new GaleriFragment();
    private HomeFragment homeFragment = new HomeFragment();
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);
        if (!sessionManager.isLoggedIn()) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
            startActivity(intent);
            finish();
        }

        bottomNavigationView = findViewById(R.id.bottomView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        // Set fragment homeFragment sebagai default saat pertama kali dibuka
        getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.navigation_home) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, homeFragment).commit();
            return true;
        } else if (item.getItemId() == R.id.navigation_galeri) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, galeriFragment).commit();
            return true;
        } else if (item.getItemId() == R.id.navigation_unggah) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, unggahFragment).commit();
            return true;
        } else if (item.getItemId() == R.id.navigation_profil) {
            getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, profileFragment).commit();
            return true;
        }
        return false;
    }
}