
package com.example.group;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class SettingsActivity extends AppCompatActivity {
    private TextView textview13;
    private TextView textview14;
    private TextView textview15;
    private TextView textview16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_settings);
        textview13 = (TextView) findViewById(R.id.textView13);
        textview14 = (TextView) findViewById(R.id.textView14);
        textview15 = (TextView) findViewById(R.id.textView15);
        textview16 = (TextView) findViewById(R.id.textView16);

        textview13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SettingsActivity.this,addFriend.class);
                startActivity(intent);
            }
        });
        textview14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SettingsActivity.this,addFriend.class);
                startActivity(intent);
            }
        });
        textview15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingsActivity.this, "已刪除群組", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent();
                intent.setClass(SettingsActivity.this,UserActivity.class);
                startActivity(intent);
            }
        });
        textview16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingsActivity.this, "已列為最愛", Toast.LENGTH_SHORT).show();
            }
        });
    }


}