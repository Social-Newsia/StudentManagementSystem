package com.socialcodia.studentmanagementsystem.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

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
import com.socialcodia.studentmanagementsystem.model.UserModel;
import com.socialcodia.studentmanagementsystem.storage.SharedPrefManager;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView username;
    SharedPrefManager sharedPrefManager;
    BottomNavigationView navigationView;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.username);
        navigationView = findViewById(R.id.bottomNavigation);

        actionBar = getSupportActionBar();

        UserModel user = SharedPrefManager.getInstance(getApplicationContext()).getUser();

        username.setText("Welcome Back " + user.getName());

        if (!SharedPrefManager.getInstance(getApplicationContext()).isLoggedIn())
        {
            sendToLogin();
        }

        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id)
                {
                    case R.id.miHome:
                        actionBar.setTitle("Home");
                        break;
                    case R.id.miUsers:
                        actionBar.setTitle("Users");
                        break;
                    case R.id.miSettings:
                        actionBar.setTitle("Settings");
                        break;
                }
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


