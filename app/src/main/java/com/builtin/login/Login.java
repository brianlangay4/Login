package com.builtin.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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


        // status bar transparent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            // Set the status bar to be transparent
            window.setStatusBarColor(Color.TRANSPARENT);

            // Make the content appear behind the status bar
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        // change bottom nav color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.setNavigationBarColor(ContextCompat.getColor(this, R.color.yellow));
        }

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

                    // Check if it's the first-time login
                    if (isFirstTimeLogin()) {
                        // Show custom notification for the first-time login
                        showFirstTimeLoginNotification();
                        // Set the flag to indicate that the user has logged in for the first time
                        setFirstTimeLoginFlag(false);
                    }

                    // Navigate to the main activity
                    Intent intent = new Intent(Login.this, MainActivity.class);
                    startActivity(intent);
                    finish();  // Close the login activity to prevent going back to it from the main activity
                    //LoginApp Notification
                    NotificationHelper.showCustomNotification(Login.this, "LoginApp Notification", "Welcome! "+username1.getText().toString(), 3000);
                } else {
                    // Login failed
                    //preview0.setText("Invalid username or password. Please try again.");
                    NotificationHelper.showCustomNotification(Login.this, "LoginApp Error Message \uD83D\uDEAB", "Invalid username or password. Please try again. ", 3000);
                }
            } else {
                // Username or password is empty
                //preview0.setText("Please enter both username and password.");
                NotificationHelper.showCustomNotification(Login.this, "LoginApp Error Message \uD83D\uDEAB", "Please enter both username and password.", 3000);
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
    private boolean isFirstTimeLogin() {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        return sharedPreferences.getBoolean("isFirstTimeLogin", true);
    }

    private void setFirstTimeLoginFlag(boolean isFirstTimeLogin) {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isFirstTimeLogin", isFirstTimeLogin);
        editor.apply();
    }

    private void showFirstTimeLoginNotification() {
        NotificationHelper.showCustomNotification(Login.this, "Welcome to Login", "Welcome! You have successfully logged in for the first time.", 3000);
    }



    private void saveLoginStatus(boolean isLoggedIn, String username) {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isLoggedIn", isLoggedIn);
        editor.putString("username", username);
        editor.apply();
    }
}