package com.yash.news.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.yash.news.R;
import com.yash.news.util.AppSettings;

public class MainActivity extends AppCompatActivity {

    NavHostFragment navHostFragment;
    BottomNavigationView bottomNavigationView;
    AppSettings appSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        appSettings = new AppSettings(this);
        applyTheme(appSettings.getTheme());

        // Set Dark Theme
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // NAVIGATION WITH BOTTOM NAV
        setupNavigation();

    }

    private void applyTheme(int theme) {
        switch (theme) {
            case AppSettings.THEME_LIGHT:
                setTheme(R.style.AppTheme);
                break;
            case AppSettings.THEME_DARK:
                setTheme(R.style.DarkTheme);
                break;
            case AppSettings.THEME_DARK_AMOLED:
                setTheme(R.style.DarkTheme);
                break; // we didn't define an amoled theme yet so I just set to dark ..
            default:
                setTheme(R.style.AppTheme);
        }
    }

    private void setupNavigation() {
        navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.getNavController());
    }

}