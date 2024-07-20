package com.nim.carsspeed;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.nim.carsspeed.view.CustomSpeedometerView;
import com.nim.carsspeed.view.SpeedDigitView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomSpeedometerView speedometer = findViewById(R.id.speedometer);
        SpeedDigitView digitView = findViewById(R.id.digit_view);
        speedometer.setOnSpeedChangeListener(newSpeed -> digitView.updateDigit((int) newSpeed));

        speedometer.setSpeed(7000);
    }

}