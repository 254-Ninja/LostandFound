package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.textfield.TextInputEditText;

public class LogIn extends AppCompatActivity {

    // Variable declarations
    private TextInputEditText mEmail, mPassword;
    private TextView mSignUp;
    private Button mSignIn;
    private ProgressBar mProgress;

    // Volley Variables
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        // Getting UI views from our xml file
        mEmail = findViewById(R.id.email);
        mPassword = findViewById(R.id.password);
        mSignIn = findViewById(R.id.buttonLogin);
        mSignUp = findViewById(R.id.signUpText);
        mProgress = findViewById(R.id.progress);

        mSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(LogIn.this,SignUp.class));

            }
        });


    }
}