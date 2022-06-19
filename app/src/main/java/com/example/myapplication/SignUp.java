package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


public class SignUp extends AppCompatActivity {

    private TextInputEditText fullname, email, contact, username, password;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        fullname = findViewById(R.id.fullname);
        email = findViewById(R.id.email);
        contact = findViewById(R.id.contact);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        buttonSignUp = findViewById(R.id.buttonSignUp);

    }


}