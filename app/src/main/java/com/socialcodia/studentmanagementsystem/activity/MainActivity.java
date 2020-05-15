package com.socialcodia.studentmanagementsystem.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.socialcodia.studentmanagementsystem.R;
import com.socialcodia.studentmanagementsystem.fragment.HomeFragment;
import com.socialcodia.studentmanagementsystem.fragment.SettingsFragment;
import com.socialcodia.studentmanagementsystem.fragment.UsersFragment;
import com.socialcodia.studentmanagementsystem.model.UserModel;
import com.socialcodia.studentmanagementsystem.storage.SharedPrefManager;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    SharedPrefManager sharedPrefManager;
    BottomNavigationView navigationView;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.bottomNavigation);

        actionBar = getSupportActionBar();



        if (!SharedPrefManager.getInstance(getApplicationContext()).isLoggedIn())
        {
            sendToLogin();
        }

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                Fragment fragment = new HomeFragment();
                switch (id)
                {
                    case R.id.miHome:
                        actionBar.setTitle("Home");
                        fragment = new HomeFragment();
                        break;
                    case R.id.miUsers:
                        actionBar.setTitle("Users");
                        fragment = new UsersFragment();
                        break;
                    case R.id.miSettings:
                        actionBar.setTitle("Settings");
                        fragment = new SettingsFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).commit();
                return true;
            }
        });

    }


    private void sendToLogin()
    {
        Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}


