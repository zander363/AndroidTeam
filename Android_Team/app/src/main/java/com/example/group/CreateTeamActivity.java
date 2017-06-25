package com.example.group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateTeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createteam);
        Button button = (Button)findViewById(R.id.button5);

        //實做OnClickListener界面
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //初始化Intent物件
                Intent intent = new Intent();
                intent.setClass(CreateTeamActivity.this, TeamActivity.class);
                //開啟Activity
                startActivity(intent);
            }
        });
    }
}
