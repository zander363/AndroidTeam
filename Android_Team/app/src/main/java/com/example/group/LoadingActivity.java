package com.example.group;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class LoadingActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler =new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(progressStatus<100) {
                    progressStatus++;
                    android.os.SystemClock.sleep(20);
                    if(progressStatus == 35)
                        android.os.SystemClock.sleep(2000);
                    if(progressStatus == 74)
                        android.os.SystemClock.sleep(1000);
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progressStatus);
                        }
                    });
                }

                if(progressStatus == 100){
                    Intent intent = new Intent();
                    intent.setClass(LoadingActivity.this, LoginActivity.class);
                    startActivity(intent);
                }

            }
        }).start();

    }
}
