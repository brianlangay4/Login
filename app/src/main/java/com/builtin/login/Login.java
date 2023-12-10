package com.builtin.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
                    // Login successful
                    // You can perform actions such as navigating to another activity
                    // or displaying a welcome message.
                    preview0.setText("Login Successful!\nWelcome, " + ((User) loggedInUser).getName());
                } else {
                    // Login failed
                    preview0.setText("Invalid username or password. Please try again.");
                }
            } else {
                // Username or password is empty
                preview0.setText("Please enter both username and password.");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the database connection when the activity is destroyed
        dataSource.close();


    }
}