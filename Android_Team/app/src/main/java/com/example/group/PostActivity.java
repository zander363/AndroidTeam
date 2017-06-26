package com.example.group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        Button button = (Button)findViewById(R.id.button8);
        final EditText editText =(EditText)findViewById(R.id.editText8);






        //實做OnClickListener界面
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("post",editText.getText().toString());
                intent.setClass(PostActivity.this, TeamActivity.class);
                startActivity(intent);
            }
        });
    }


}
