package com.example.group;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;

        import android.widget.*;

public class CalendarActivity extends AppCompatActivity {
     private ListView mListView;
     private String[] list = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};

             @Override
     protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_calendar);
                mListView = (ListView)findViewById(R.id.list_view);
                mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));


                            }
 }



