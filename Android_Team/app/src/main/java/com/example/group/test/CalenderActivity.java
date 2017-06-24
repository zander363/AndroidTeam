package com.example.group.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.AbsListView.OnScrollListener;
import android.view.View;
import android.widget.*;
import com.example.group.R;
//import android.widget.CalendarView;

public class CalenderActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] list = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calender);
        mListView = (ListView)findViewById(R.id.list_view);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));


    }
}
