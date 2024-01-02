package com.example.cse;

import static com.example.cse.constants.NAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button Login;
    TextView Forgot,Newuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username=findViewById(R.id.name);
        password=findViewById(R.id.password);
        Login=findViewById(R.id.login);
        Forgot=findViewById(R.id.forgotpassword);
        Newuser=findViewById(R.id.newuser);
        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                NAME=username.getText().toString();
                String message="Wellcome "+NAME;
                Toast.makeText(MainActivity.this,message,Toast.LENGTH_SHORT);
                Intent intent=new Intent(MainActivity.this,home.class);
                startActivity(intent);
            }
        });
    }
}