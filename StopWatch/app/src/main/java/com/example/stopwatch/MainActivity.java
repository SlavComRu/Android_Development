package com.example.stopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView textViewTimer;

    private int seconds = 0;
    private boolean isRunning = false;
    private boolean wasRunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewTimer = findViewById(R.id.textViewTimer);
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            isRunning = savedInstanceState.getBoolean("isRunning");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    @Override
    protected void onResume() {
        super.onResume();
        isRunning= wasRunning;
    }


    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = isRunning;
        isRunning = false;

    }

    public void onClickStartTimer(View view) {
        isRunning = true;

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("isRunning", isRunning);
        outState.putBoolean("wasRunning", wasRunning);
    }

    public void onClickStopTimer(View view) {
        isRunning = false;
    }

    public void onClickResetTimer(View view) {
        isRunning = false;
        seconds = 0;
    }

    private void runTimer() {
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                int hour = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds % 60;
                String timer = String.format(Locale.getDefault(), "%d:%02d:%02d", hour, minutes, sec);
                textViewTimer.setText(timer);

                if (isRunning) {
                    seconds++;
                }
                handler.postDelayed(this, 1000);
            }
        });


    }
}