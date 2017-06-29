package com.example.group;



import android.widget.ArrayAdapter;
import android.widget.ListView;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;



public class GroupActivity extends AppCompatActivity {
    private Comment[] comments = new Comment[0];
    private String[] arr = new String[30];
    private int a= 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);


        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr);
        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);

        FloatingActionButton fab_group = (FloatingActionButton)findViewById(R.id.fab_post);
        fab_group.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(GroupActivity.this,PostActivity.class);
            }
        });
    }
}
