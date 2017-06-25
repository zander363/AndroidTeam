package com.example.group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button = (Button)findViewById(R.id.button);
        Button button7 = (Button)findViewById(R.id.button7);

        //實做OnClickListener界面
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //初始化Intent物件
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, UserActivity.class);
                //開啟Activity
                startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //初始化Intent物件
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegisterActivity.class);
                //開啟Activity
                startActivity(intent);
            }
        });
    }


}
