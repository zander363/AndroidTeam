package com.example.group;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.*;
import android.support.v7.widget.*;




public class TeamActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private String[] arr=new String[3];
//    arr[0]="87";
//    arr[1]="88";
//    arr[2]="72";

    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_calendar:
                    Toast.makeText(TeamActivity.this,"Action calendar Clicked",Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_group:
                    Toast.makeText(TeamActivity.this,"Action group Clicked",Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.navigation_setting:
                    Toast.makeText(TeamActivity.this,"Action setting Clicked",Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

 //       ArrayAdapter<String> mAdapter = new RecyclerView.Adapter<>(TeamActivity.this,
  //              android.R.layout.simple_list_item_1,arr);
 //       mRecyclerView.setAdapter(mAdapter);
    }

}
