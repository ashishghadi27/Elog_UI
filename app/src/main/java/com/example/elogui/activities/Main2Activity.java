package com.example.elogui.activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.elogui.R;
import com.example.elogui.fragments.Home;
import com.example.elogui.fragments.Log;
import com.example.elogui.fragments.Profile;
import com.example.elogui.fragments.SignUp;
import com.example.elogui.fragments.Sof;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        addFragment(new Home(), "Home");

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                int choice  = menuItem.getItemId();

                switch (choice){

                    case R.id.home: addFragment(new Home(), "Home");
                    return true;

                    case R.id.log: addFragment(new Log(), "Log");
                        return true;

                    case R.id.sof: addFragment(new Sof(), "Sof");
                        return true;

                    case R.id.profile: addFragment(new Profile(), "Profile");
                        return true;

                    default:  addFragment(new Home(), "Home");
                    return true;
                }

            }
        });

    }

    private void addFragment(Fragment fragment, String tag){
        getSupportFragmentManager()
                .beginTransaction().replace(R.id.fragment_container, fragment, tag).addToBackStack(tag)
                .commit();
    }

}
