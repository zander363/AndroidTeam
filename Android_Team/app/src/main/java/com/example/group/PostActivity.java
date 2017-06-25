package com.example.group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Button button = (Button)findViewById(R.id.button);

        //實做OnClickListener界面
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                //初始化Intent物件
                Intent intent = new Intent();
                intent.setClass(PostActivity.this, TeamActivity.class);
                //開啟Activity
                startActivity(intent);
            }
        });
    }


}
