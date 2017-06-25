package com.example.group;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.animation.Animation;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ListView mListView;
    private String[] list = {"可...可惡"};

    FloatingActionButton fab_plus, fab_plus1, fab_plus2;
    Animation fab_open, fab_close, fab_Rcw, fab_Rccw;
    TextView textView1, textView2;
    boolean isopen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mListView = (ListView) findViewById(R.id.team_list);
        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list));

        fab_close = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
        fab_open = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
        fab_Rcw = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_clockwise);
        fab_Rccw = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_counterclockwise);

        textView1 = (TextView) findViewById(R.id.textView11);
        textView2 = (TextView) findViewById(R.id.textView13);
        fab_plus2 = (FloatingActionButton) findViewById(R.id.fab_plus2);
        fab_plus1 = (FloatingActionButton) findViewById(R.id.fab_plus1);
        fab_plus = (FloatingActionButton) findViewById(R.id.fab_plus);
        fab_plus.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {

                if (isopen) {
                    textView1.startAnimation(fab_close);
                    textView2.startAnimation(fab_close);
                    fab_plus1.startAnimation(fab_close);
                    fab_plus2.startAnimation(fab_close);
                    fab_plus.startAnimation(fab_Rccw);
                    fab_plus1.setClickable(false);
                    fab_plus2.setClickable(false);
                    isopen = false;
                } else {
                    textView1.startAnimation(fab_open);
                    textView2.startAnimation(fab_open);
                    fab_plus1.startAnimation(fab_open);
                    fab_plus2.startAnimation(fab_open);
                    fab_plus.startAnimation(fab_Rcw);
                    fab_plus1.setClickable(true);
                    fab_plus2.setClickable(true);
                    isopen = true;
                }
            }
        });
        fab_plus1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(UserActivity.this, JoinTeamActivity.class);
                startActivity(intent);
            }

        });
        fab_plus2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(UserActivity.this, CreateActivity.class);
                startActivity(intent);
            }

        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_modify_name) {
            NameFragment nameFragment = new NameFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.layout_for_fragment, nameFragment, nameFragment.getTag()).commit();
            Toast.makeText(this, "修改名字", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_modify_account) {
            ModifyAccountFragment modifyAccountFragment = new ModifyAccountFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.layout_for_fragment, modifyAccountFragment, modifyAccountFragment.getTag()).commit();
            Toast.makeText(this, "修改密碼", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_manage) {
            ManageFragment manageFragment = new ManageFragment();
            FragmentManager manager = getSupportFragmentManager();
            manager.beginTransaction().replace(R.id.layout_for_fragment, manageFragment, manageFragment.getTag()).commit();
            Toast.makeText(this, "管理", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_logout) {
            Toast.makeText(this, "登出", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) { // 攔截返回鍵


                Intent intent = new Intent();
                intent.setClass(UserActivity.this, UserActivity.class);
                startActivity(intent);


            }
            return true;
        }
    }

