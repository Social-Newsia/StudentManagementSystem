package com.socialcodia.studentmanagementsystem.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.socialcodia.studentmanagementsystem.R;
import com.socialcodia.studentmanagementsystem.api.RetrofitClient;
import com.socialcodia.studentmanagementsystem.model.LoginResponse;
import com.socialcodia.studentmanagementsystem.model.ModelUser;
import com.socialcodia.studentmanagementsystem.storage.SharedPrefManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private TextView tvRegister;
    private Button btnLogin;
    SharedPrefManager sharedPrefManager;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        tvRegister = findViewById(R.id.tvRegister);
        btnLogin = findViewById(R.id.btnLogin);
        sharedPrefManager = new SharedPrefManager(getApplicationContext());

        intent = getIntent();
        if (!intent.getStringExtra("intentEmail").isEmpty() && !intent.getStringExtra("intentPassword").isEmpty())
        {
            inputEmail.setText(intent.getStringExtra("intentEmail"));
            inputPassword.setText(intent.getStringExtra("intentPassword"));
        }

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToRegister();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateData();
            }
        });

        if (sharedPrefManager.isLoggedIn())
        {
           sendToMain();
        }

    }

    private void validateData()
    {
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        
        if (email.isEmpty())
        {
            inputEmail.setError("Enter Email Address");
            inputEmail.requestFocus();
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() || email.length()>50)
        {
            inputEmail.setError("Enter Valid Email");
            inputEmail.requestFocus();
        }
        else if (password.isEmpty())
        {
            inputPassword.setError("Enter Password");
            inputPassword.requestFocus();
        }
        else if (password.length()<7 || password.length()>30)
        {
            inputPassword.setError("Enter Password Greater Than 8 Digit");
            inputPassword.requestFocus();
        }
        else
        {
            doLogin(email,password);
        }
    }

    private void doLogin(String email, String password)
    {
        Call<LoginResponse> call = RetrofitClient.getInstance().getApi().login(email,password);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse loginResponse = response.body();
                if (!loginResponse.isError())
                {
                    ModelUser user = loginResponse.getUser();
                    SharedPrefManager.getInstance(getApplicationContext()).saveUser(user);
                    sendToMain();
                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {

            }
        });
    }

    private void sendToRegister()
    {
        Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
        startActivity(intent);
    }

    private void sendToMain()
    {
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

}
