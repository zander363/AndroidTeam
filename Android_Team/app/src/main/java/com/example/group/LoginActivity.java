package com.example.group;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;


public class LoginActivity extends AppCompatActivity {
    private UserDBHelper helper;
    OOPUser oopuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText email=(EditText) findViewById(R.id.email);
        final EditText password=(EditText)findViewById(R.id.password);
        Button button = (Button)findViewById(R.id.button);
        Button button7 = (Button)findViewById(R.id.button7);

        try{
            helper = new UserDBHelper(this, "oop.movie", null, 1);

        oopuser = new OOPUser(this);
        /*if (oopuser.getCount() == 0) {
            oopuser.loadSample();
        }*/
        }
        catch (Exception e){
            Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }

        //實做OnClickListener界面
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                User user=oopuser.get(email.getText().toString(),password.getText().toString());
                if(user!=null) {
                    Intent intent = new Intent();
                    intent.setClass(LoginActivity.this, UserActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(LoginActivity.this, "try again!", Toast.LENGTH_LONG).show();
                }
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
