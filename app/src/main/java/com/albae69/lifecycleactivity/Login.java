package com.albae69.lifecycleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.albae69.lifecycleactivity.utils.Utils;


public class Login extends AppCompatActivity {
    EditText email, password;
    TextView askRegister, forgotPassword;
    Button btnLogin;
    Utils util;


    //intent
    void getIntent(Class c, Boolean isClose) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
        if (isClose) {
            finish();
        }
    }

    //convert input from edit text view to string
    public String getString(EditText e) {
        return e.getText().toString();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // edit text input
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);

        // button login
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(email).isEmpty() && getString(password).isEmpty()) {
                    util.showToast(Login.this, "Email atau password tidak boleh kosong!");
                } else if (getString(email).equals("admin") && getString(password).equals("admin")) {
                    getIntent(MainActivity.class, true);
                } else {
                    util.showToast(Login.this, "Email atau password salah!");
                }
            }
        });

        //text view ask register
        askRegister = findViewById(R.id.tvAskRegister);
        askRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntent(Register.class, false);
            }
        });
        //text view ask register
        forgotPassword = findViewById(R.id.tvForgotPassword);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntent(ForgotPassword.class, false);
            }
        });


    }

}