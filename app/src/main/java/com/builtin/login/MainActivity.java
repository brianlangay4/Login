package com.builtin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Check if the user is logged in
        if (!isLoggedIn()) {
            // User is not logged in, navigate to the login activity
            Intent intent = new Intent(MainActivity.this, Login.class);
            startActivity(intent);
            finish();  // Close the main activity to prevent going back to it from the login activity
        }

        // ... (remaining code)
    }

    private boolean isLoggedIn() {
        SharedPreferences sharedPreferences = getSharedPreferences("LoginPrefs", MODE_PRIVATE);
        return sharedPreferences.getBoolean("isLoggedIn", false);

    }
}