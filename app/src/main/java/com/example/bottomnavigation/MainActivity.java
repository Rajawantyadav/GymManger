package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.bottomnavigation.fragments.ContactFragment;
import com.example.bottomnavigation.fragments.HomeFragment;
import com.example.bottomnavigation.fragments.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView navigationView;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.fragment_container);
        navigationView = findViewById(R.id.bottomNavigationView);
        loadFragment(new HomeFragment(), "add");
        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.nav_contact) {
                    loadFragment(new ContactFragment(), "replace");
                } else if (itemId == R.id.nav_search) {
                    loadFragment(new SearchFragment(), "replace");
                } else {
                    loadFragment(new HomeFragment(), "replace");
                }
                return true;
            }
        });

    }

    public void loadFragment(Fragment fragment, String action) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        if (action.equalsIgnoreCase("add")) {
            ft.add(R.id.fragment_container, fragment);
            ft.commit();
        } else {
            ft.replace(R.id.fragment_container, fragment);
            ft.commit();
        }
    }
}