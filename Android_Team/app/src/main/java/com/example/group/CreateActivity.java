package com.example.group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateActivity extends AppCompatActivity {
    EditText editText6,editText7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try{
            editText6 =(EditText) findViewById(R.id.editText6);
            editText7 =(EditText) findViewById(R.id.editText7);

            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Button button = (Button) findViewById(R.id.button5);

        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                if("".equals(editText6.getText().toString()))
                    Toast.makeText(CreateActivity.this,"未輸入群組名稱",Toast.LENGTH_SHORT).show();
                else {

                    Intent intent = new Intent();
                    intent.putExtra("team_name", editText6.getText().toString());
                    intent.putExtra("ID_String", editText7.getText().toString());
                    intent.setClass(CreateActivity.this, UserActivity.class);
                    startActivity(intent);
                }
            }
            });

        }catch (Exception e){
            Toast.makeText(CreateActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
}
