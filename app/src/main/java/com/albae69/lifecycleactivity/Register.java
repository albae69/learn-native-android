package com.albae69.lifecycleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.albae69.lifecycleactivity.utils.Utils;

public class Register extends AppCompatActivity {
    EditText name, email, password;
    TextView askLogin;
    Button btnRegister;
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
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.etName);
        email = findViewById(R.id.etEmailRegister);
        password = findViewById(R.id.etPasswordRegister);

        //button register
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (getString(name).isEmpty() && getString(email).isEmpty() && getString(password).isEmpty()) {
                    util.showToast(Register.this, "Tidak boleh terdapat data yang kosong");
                } else {
                    getIntent(Splash.class, true);
                    util.showToast(Register.this, "Berhasil register");
                }
            }
        });

        // ask login
        askLogin = findViewById(R.id.tvAskLogin);
        askLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIntent(Login.class, false);
            }
        });
    }
}