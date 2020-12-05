package com.example.instagramapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import com.example.instagramapp.ui.HeartFragment;
import com.example.instagramapp.ui.PlusFragment;
import com.example.instagramapp.ui.ProfileFragment;
import com.example.instagramapp.ui.SearchFragment;
import com.example.instagramapp.ui.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navView = findViewById(R.id.nav_view);


        // Custom toolbar
        Toolbar toolbar = findViewById(R.id.top_toolbar);
        setSupportActionBar(toolbar);


        // Setting on click listener on the camera icon
        ImageView camera = toolbar.findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Camera is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Setting on click listener on the instatv icon
        ImageView instatv = toolbar.findViewById(R.id.instatv);
        instatv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Instatv is clicked", Toast.LENGTH_SHORT).show();
            }
        });

        // Setting on click listener on the send icon
        ImageView send = toolbar.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Send is clicked", Toast.LENGTH_SHORT).show();
            }
        });


        // Setting on navigation item click listener on the bottom toolbar
        // This method is called when any of the item from bottom toolbar is selected
        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){

                    case R.id.navigation_home:
                        HomeFragment homeFragment = new HomeFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.nav_host_fragment, homeFragment);
                        transaction.commit();
                        break;

                    case R.id.search:
                        SearchFragment searchFragment = new SearchFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.nav_host_fragment, searchFragment);
                        transaction.commit();
                        break;

                    case R.id.plus:
                        PlusFragment plusFragment = new PlusFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.nav_host_fragment, plusFragment);
                        transaction.commit();
                        break;

                    case R.id.heart:
                        HeartFragment heartFragment = new HeartFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.nav_host_fragment, heartFragment);
                        transaction.commit();
                        break;

                    case R.id.profile:
                        ProfileFragment profileFragment = new ProfileFragment();
                        transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.nav_host_fragment, profileFragment);
                        transaction.commit();
                        break;

                    default:

                }
                return true;

            }
        });

    }

}