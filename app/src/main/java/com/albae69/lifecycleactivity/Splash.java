package com.albae69.lifecycleactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

public class Splash extends AppCompatActivity {
    private int time = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        // tunggu 1 detik
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(this, Login.class);
            startActivity(intent);
            finish();
        }, time);
    }
}