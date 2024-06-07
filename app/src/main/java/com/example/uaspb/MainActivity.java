package com.example.uaspb;

import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private ProfileFragment profileFragment = new ProfileFragment();
    private UnggahFragment unggahFragment = new UnggahFragment();
    private GaleriFragment galeriFragment = new GaleriFragment();
    private HomeFragment homeFragment = new HomeFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
