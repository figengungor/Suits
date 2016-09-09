package com.figengungor.suits;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    RelativeLayout content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.navigationView);
        content = (RelativeLayout) findViewById(R.id.content);
        toolbarAyarla();
        navigationViewAyarla();
    }

    public void toolbarAyarla(){
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.drawerOpened, R.string.drawerClosed){

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                content.setTranslationX(slideOffset * drawerView.getWidth());
            }
        };

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void navigationViewAyarla() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.linear: startActivity(new Intent(MainActivity.this, LinearRecyclerViewActivity.class)); break;
                    case R.id.grid: startActivity(new Intent(MainActivity.this, GridRecyclerViewActivity.class)); break;
                    case R.id.card: startActivity(new Intent(MainActivity.this, CardRecyclerViewActivity.class)); break;
                }
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                if(drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else
                    drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
