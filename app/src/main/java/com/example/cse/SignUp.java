package com.example.cse;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {

    EditText name, username, password, clgname;
    Button next;
    DatabaseHelper  dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.editTextName);
        username = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        clgname = findViewById(R.id.editTextclg);
        next = findViewById(R.id.btnNext);

        dbHelper = new DatabaseHelper(this);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Save user data to the database
                saveUserData();
                Intent intent=new Intent(SignUp.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }

    private void saveUserData() {
        // Get the data from EditText fields
        String userName = name.getText().toString().trim();
        String userUsername = username.getText().toString().trim();
        String userPassword = password.getText().toString().trim();
        String userClgName = clgname.getText().toString().trim();

        // Get a writable database
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        if (userName.isEmpty()) {
            Toast.makeText(SignUp.this, "Please enter a name.", Toast.LENGTH_SHORT).show();
            return; // Stop execution if the name is empty
        }
        if (userUsername.isEmpty()) {
            Toast.makeText(SignUp.this, "Please enter a Username.", Toast.LENGTH_SHORT).show();
            return; // Stop execution if the name is empty
        }
        if (userPassword.isEmpty()) {
            Toast.makeText(SignUp.this, "Please enter a password.", Toast.LENGTH_SHORT).show();
            return; // Stop execution if the name is empty
        }
        if (userClgName.isEmpty()) {
            Toast.makeText(SignUp.this, "Please enter a college name.", Toast.LENGTH_SHORT).show();
            return; // Stop execution if the name is empty
        }




        // Create a ContentValues object to store the data
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_NAME, userName);
        values.put(DatabaseHelper.COLUMN_USERNAME, userUsername);
        values.put(DatabaseHelper.COLUMN_PASSWORD, userPassword);
        values.put(DatabaseHelper.COLUMN_CLG_NAME, userClgName);

        // Insert the data into the database
        long newRowId = db.insert(DatabaseHelper.TABLE_NAME, null, values);

        // Check if the insertion was successful
        if (newRowId != -1) {
            Toast.makeText(SignUp.this, "User data inserted successfully!", Toast.LENGTH_SHORT).show();
        } else {
            // Insertion failed
            Toast.makeText(SignUp.this, "Failed to insert user data. Please try again.", Toast.LENGTH_SHORT).show();
        }

        // Close the database connection
        db.close();
    }
}
