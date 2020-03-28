package com.nisith.currencyandotherconverters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

public class StartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        final long sleepTime = 4000;
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(sleepTime);
                Intent intent = new Intent(StartingActivity.this,CurrencyActivity.class);
                startActivity(intent);
                finish();
            }
        });
        thread.start();

    }
}
