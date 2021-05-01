package com.albae69.lifecycleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.albae69.lifecycleactivity.utils.Utils;

public class ForgotPassword extends AppCompatActivity {
    EditText email;
    Button btnSend;
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
        setContentView(R.layout.activity_forgot_password);

        email = findViewById(R.id.etEmailForgotPassword);
        btnSend = findViewById(R.id.btnForgotPassword);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(email).isEmpty()) {
                    util.showToast(ForgotPassword.this, "Email tidak boleh kosong!");
                } else {
                    getIntent(Splash.class, true);
                    util.showToast(ForgotPassword.this, "Silahkan periksa email anda!");
                }
            }
        });
    }

}