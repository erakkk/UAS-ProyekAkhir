package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends AppCompatActivity {

    EditText username, password;
    Button login;
    TextView register;

    private String KEY_USER = "USER";
    private String KEY_PASS = "PASS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);


//        preferences = getSharedPreferences("UserInfo", 0);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameValue = username.getText().toString();
                String passwordValue = password.getText().toString();

                Bundle extras = getIntent().getExtras();
               String user = extras.getString(KEY_USER);
                String pass = extras.getString(KEY_PASS);

//                String registeredUsername = preferences.getString("username", "");
//                String registeredPassword = preferences.getString("password", "");

                if (usernameValue.equals(user) && passwordValue.equals(pass)){

                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(login.this, "Invalid Username & Password", Toast.LENGTH_SHORT).show();
                }
              }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, register.class);
                startActivity(intent);
            }
        });


    }
}
