package com.example.cse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button Login;
    TextView Newuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.name);
        password = findViewById(R.id.password);
        Login = findViewById(R.id.login);
        Newuser = findViewById(R.id.newuser);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredUsername = username.getText().toString();
                String enteredPassword = password.getText().toString();

                // Check if the username and password are correct using the database
                if (isValidCredentials(enteredUsername, enteredPassword)) {
                    String message = "Welcome " + enteredUsername;
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MainActivity.this, home.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect username or password", Toast.LENGTH_SHORT).show();
                }
            }

            private boolean isValidCredentials(String enteredUsername, String enteredPassword) {
                DatabaseHelper dbHelper = new DatabaseHelper(MainActivity.this);
                return dbHelper.checkCredentials(enteredUsername, enteredPassword);
            }
        });

        Newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}
