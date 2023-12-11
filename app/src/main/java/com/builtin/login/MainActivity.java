package com.builtin.login;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    TextView h, username;
    MaterialButton logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init
        h = findViewById(R.id.textView);
        username = findViewById(R.id.username);
        logout = findViewById(R.id.logout);

        // status bar transparent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);

            // Set the status bar to be transparent
            window.setStatusBarColor(Color.TRANSPARENT);

            // Make the content appear behind the status bar
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }

        // Change bottom nav color based on app's night mode
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();

            int navColor;

            if ((getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES) {
                // Night mode
                navColor = ContextCompat.getColor(this, R.color.dark);
            } else {
                // Light or dark mode
                navColor = ContextCompat.getColor(this, R.color.d1);
            }

            window.setNavigationBarColor(navColor);
        }






        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogoutConfirmationDialog();

            }
        });


       // NotificationHelper.showNotification(MainActivity.this, "notification message");
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loggedInUsername = getLoggedInUsername();
                if (!loggedInUsername.isEmpty()) {
                    NotificationHelper.showCustomNotification(MainActivity.this, "Ping!!", "Hi "+loggedInUsername,3000);

                }

            }

        });


        // Check if the user is logged in
        if (!isLoggedIn()) {
            // User is not logged in, navigate to the login activity
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();  // Close the main activity to prevent going back to it from the login activity
        }

        // ...
        displayLoggedInUsername();
    }
    private void showLogoutConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Logout Confirmation")
                .setMessage("Are you sure you want to log out?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    // User clicked Yes
                    dialog.dismiss();
                    logout();
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    // User clicked Cancel
                    dialog.dismiss();
                })
                .show();
    }

    private void logout() {
        // Clear login status and username from shared preferences
        clearLoginStatus();

        // Show custom notification
        showLogoutNotification();

        // Navigate back to the login activity
        Intent intent = new Intent(MainActivity.this, Login.class);
        startActivity(intent);
        finish();  // Close the main activity to prevent going back to it from the login activity
    }

    private void showLogoutNotification() {

        NotificationHelper.showCustomNotification(MainActivity.this, "Logout", "You have been logged out",3000);
    }

    private boolean isLoggedIn() {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        return sharedPreferences.getBoolean("isLoggedIn", false);

    }
    private String getLoggedInUsername() {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        return sharedPreferences.getString("username", "");
    }
    private void clearLoginStatus() {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("isLoggedIn");
        editor.remove("username");
        editor.apply();
    }


    private void displayLoggedInUsername() {
        String loggedInUsername = getLoggedInUsername();
        if (!loggedInUsername.isEmpty()) {
            username.setText(loggedInUsername);
        }
    }

}