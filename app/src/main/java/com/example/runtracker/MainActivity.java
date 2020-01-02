package com.example.runtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button startButton;
    Button stopButton;


    public void startTracking(View view) {
        switchButton();
    }

    public void stopTracking(View view) {
        switchButton();
    }


    public void switchButton() {
        if (startButton.getVisibility() == View.VISIBLE) {
            startButton.setVisibility(View.INVISIBLE);
        } else {
            startButton.setVisibility(View.VISIBLE);
        }
        if (stopButton.getVisibility() == View.VISIBLE) {
            stopButton.setVisibility(View.INVISIBLE);
        } else {
            stopButton.setVisibility(View.VISIBLE);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startButton = findViewById(R.id.start_button);
        stopButton = findViewById(R.id.stop_button);

    }

    public void showMap(View view) {

    }

}
