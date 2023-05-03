package com.example.vehiclefinancing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class splashscreen extends AppCompatActivity {
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        lottie = findViewById(R.id.lottie);

        lottie.animate().translationX(-2000).setDuration(1000).setStartDelay(1500);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent (splashscreen.this,MainActivity.class);
                startActivity(i);

            }
        }, 2500);
    }
}