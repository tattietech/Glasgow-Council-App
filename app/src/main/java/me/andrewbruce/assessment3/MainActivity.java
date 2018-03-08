package me.andrewbruce.assessment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.concurrent.TimeUnit;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // calls finishSplashScreen() method after 1.5 seconds
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finishSplashScreen();
            }
        }, 1500);

    }

    public void finishSplashScreen() {
        // finishes the splash screen activity and starts the main menu
        finish();
        Intent i = new Intent(this, LoginActivity.class);
        startActivity(i);
    }
}
