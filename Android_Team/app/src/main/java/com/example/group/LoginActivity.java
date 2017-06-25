package com.example.group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;


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
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, UserActivity.class);
                startActivity(intent);
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(LoginActivity.this, RegisActivity.class);
                startActivity(intent);
            }
        });
    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) { // 攔截返回鍵
            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);

                    builder.setTitle("確認視窗");
                    builder.setMessage("確定要結束應用程式嗎?");
                    builder.setPositiveButton("確定",
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {
                                    Intent intentHome = new Intent(Intent.ACTION_MAIN);
                                    intentHome.addCategory(Intent.CATEGORY_HOME);
                                    intentHome.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intentHome);



                                }
                            });
                    builder.setNegativeButton("取消",
                            new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialog,
                                                    int which) {

                                }
                            }).show();
        }
        return true;
    }
}
