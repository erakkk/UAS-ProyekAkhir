package com.example.dashboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class register extends AppCompatActivity {

    EditText name,username, password;
    Button save,reset;

    private String KEY_USER = "USER";
    private String KEY_PASS = "PASS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();
        name = findViewById(R.id.name);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        save = findViewById(R.id.save);
        reset = findViewById(R.id.reset);

//        preferences = getSharedPreferences("UserInfo", 0);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    //            String nama = name.getText().toString();

                    //  String nameValue = name.getText().toString();
                    String usernameValue = username.getText().toString();
                    String passwordValue = password.getText().toString();


                    if (usernameValue != null && usernameValue != "" || passwordValue != null && passwordValue != "") {
                        Intent i = new Intent(register.this, login.class);
                        i.putExtra(KEY_USER, usernameValue);
                        i.putExtra(KEY_PASS, passwordValue);
                        startActivity(i);

                    } else {
                        Toast.makeText(getApplication(), "YOU NEED TO FILL YOUR NAME", Toast.LENGTH_SHORT);
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(getApplication(), "ERROR, TRY AGAIN !", Toast.LENGTH_SHORT);
                }
            }
        });



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                username.setText("");
                password.setText("");
            }
        });
    }
}
