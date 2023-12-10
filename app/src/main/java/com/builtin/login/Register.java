package com.builtin.login;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
                    } else {
                        // Registration failed
                        preview.setText("Registration failed. Please try again.");
                        preview.setVisibility(View.VISIBLE);
                    }
                } else {
                    // Passwords do not match
                    Toast.makeText(Register.this, "Passwords do not match. Please retype.", Toast.LENGTH_SHORT).show();
                }
            } else {
                // Username or password is empty
                Toast.makeText(Register.this, "Please enter both username and password.", Toast.LENGTH_SHORT).show();
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
