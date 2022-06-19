package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.textfield.TextInputEditText;


public class SignUp extends AppCompatActivity {

    private TextInputEditText fullname, email, contact, username, password;
    private Button buttonSignUp;

    // Volley variables
    private StringRequest mStringRequest;
    private RequestQueue mRequestQueue;

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

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser(fullname.getText().toString(),email.getText().toString(),username.getText().toString(),contact.getText().toString(),password.getText().toString());
            }
        });

    }

    private void createUser(final String fullname,final String email, final String username, final String contact, final String password){

    }

    private String getBaseUrl (){
        return "http://"+getResources().getString(R.string.machine_ip_address)+"/LoginRegister/signup.php";
    }
}