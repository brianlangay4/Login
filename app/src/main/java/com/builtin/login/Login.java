package com.builtin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.builtin.login.models.User;

public class Login extends AppCompatActivity {


    TextView username1, password1, Regbtn, preview0;
    Button btnsignin1;

    String collectUser;

    UserDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initialize attributes
        username1 = findViewById(R.id.username1);
        password1 = findViewById(R.id.password1);
        btnsignin1 = findViewById(R.id.btnsignin1);
        preview0 = findViewById(R.id.preview0);
        Regbtn = findViewById(R.id.Regbtn);

        // Initialize the data source
        dataSource = new UserDataSource(this);
        dataSource.open();

        btnsignin1.setOnClickListener(v -> {
            String username = username1.getText().toString().trim();
            String password = password1.getText().toString().trim();

            if (!username.isEmpty() && !password.isEmpty()) {
                User loggedInUser = dataSource.getUser(username, password);

                if (loggedInUser != null) {
                    // Save login status to shared preferences
                    saveLoginStatus(true, loggedInUser.getNumber());

                    // Navigate to the main activity
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();  // Close the login activity to prevent going back to it from the main activity
                } else {
                    // Login failed
                    preview0.setText("Invalid username or password. Please try again.");
                }
            } else {
                // Username or password is empty
                preview0.setText("Please enter both username and password.");
            }
        });

        // open registration page
        Regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this , Register.class);
                startActivity(intent);
            }
        });
    }

    private void saveLoginStatus(boolean isLoggedIn, String username) {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", isLoggedIn);
        editor.putString("username", username);
        editor.apply();
    }
}