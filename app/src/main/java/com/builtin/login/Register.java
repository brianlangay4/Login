package com.builtin.login;
/*creator Brian Barnabas Langay
 email brianlangay0@gmail.com*/

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.builtin.login.models.User;

public class Register extends AppCompatActivity {

    TextView preview;
    Button signupButton;

    EditText usernameEditText;
    EditText passwordEditText;
    EditText retypePasswordEditText;

    UserDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

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

        // Initialize the data source
        dataSource = new UserDataSource(this);
        dataSource.open();

        // Initialize UI elements
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        retypePasswordEditText = findViewById(R.id.repassword);
        preview = findViewById(R.id.preview);
        preview.setVisibility(View.INVISIBLE);
        signupButton = findViewById(R.id.btnsignup);

        // Set up the registration logic
        signupButton.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString().trim();
            String password = passwordEditText.getText().toString().trim();
            String retypePassword = retypePasswordEditText.getText().toString().trim();

            if (!username.isEmpty() && !password.isEmpty() && !retypePassword.isEmpty()) {
                if (password.equals(retypePassword)) {
                    // Passwords match, proceed with registration
                    User newUser = new User();
                    newUser.setNumber(username);
                    newUser.setPassword(password);
                    // You can set other user details if needed

                    long userId = dataSource.createUser(newUser);

                    if (userId != -1) {
                        // Registration successful
                        preview.setText("Registration Successful!\nUser ID: " + userId);
                        preview.setVisibility(View.VISIBLE);
                        NotificationHelper.showCustomNotification(Register.this, "Account created Successfully \uD83D\uDE80", "Welcome! "+username, 3000);
                        Intent intent = new Intent(Register.this,Login.class);
                        startActivity(intent);
                        finish();
                    } else {
                        // Registration failed
                        //preview.setText("Registration failed. Please try again.");
                        ///preview.setVisibility(View.VISIBLE);
                        NotificationHelper.showCustomNotification(Register.this, "Registration failed. \uD83D\uDEAB", "Please try again.", 3000);
                    }
                } else {
                    // Passwords do not match
                    //Toast.makeText(Register.this, "Passwords do not match. Please retype.", Toast.LENGTH_SHORT).show();
                    NotificationHelper.showCustomNotification(Register.this, "Registration failed. \uD83D\uDEAB", "Passwords do not match. Please retype.", 3000);
                    passwordEditText.setError("Passwords do not match. Please retype.");

                }
            } else {
                // Username or password is empty
                //Toast.makeText(Register.this, "Please enter both username and password.", Toast.LENGTH_SHORT).show();
                NotificationHelper.showCustomNotification(Register.this, "Registration failed.", "Please enter both username and password.", 3000);
                usernameEditText.setError("Please enter both username and password.");
                passwordEditText.setError("Please enter both username and password.");
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
