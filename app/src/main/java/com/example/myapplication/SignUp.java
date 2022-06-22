package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class SignUp extends AppCompatActivity {

    private TextInputEditText sfullname, semail, scontact, susername, spassword;
    private Button buttonSignUp;
    private TextView slogin;



    // Volley variables
    private StringRequest mStringRequest;
    private RequestQueue mRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        sfullname = findViewById(R.id.fullname);
        semail = findViewById(R.id.email);
        scontact = findViewById(R.id.contact);
        susername = findViewById(R.id.username);
        spassword = findViewById(R.id.password);
        slogin = findViewById(R.id.loginText);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        slogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(SignUp.this, LogIn.class));

            }
        });

        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser(sfullname.getText().toString(),semail.getText().toString(),susername.getText().toString(),scontact.getText().toString(),spassword.getText().toString());
            }
        });

    }

    private void createUser(final String fullname,final String email, final String username, final String contact, final String password){

        mRequestQueue = Volley.newRequestQueue(SignUp.this);
        // Progress
        buttonSignUp.setText("Creating User...");

        mStringRequest = new StringRequest(Request.Method.POST, getBaseUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject jsonObject = new JSONObject(response);

                    String success = jsonObject.getString("success");
                    String message = jsonObject.getString("message");

                    if (success.equals("1")) {

                        Toast.makeText(SignUp.this,message,Toast.LENGTH_SHORT).show();
                        buttonSignUp.setText("Sign Up");


                    }

                } catch (JSONException e) {

                    Toast.makeText(SignUp.this,e.toString(),Toast.LENGTH_LONG).show();
                    buttonSignUp.setText("Sign Up");

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(SignUp.this,error.toString(),Toast.LENGTH_LONG).show();
                buttonSignUp.setText("Sign Up");

            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("fullname",fullname);
                params.put("email",email);
                params.put("username",username);
                params.put("contact",contact);
                params.put("password",password);

                return params;
            }
        };

        mStringRequest.setShouldCache(false);
        mRequestQueue.add(mStringRequest);
    }

    private String getBaseUrl (){
        return "http://"+getResources().getString(R.string.machine_ip_address)+"/LoginRegister/signup";
    }
}