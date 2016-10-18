package com.figengungor.suits.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.figengungor.suits.R;
import com.figengungor.suits.adapter.ViewPagerAdapter;
import com.figengungor.suits.databinding.ActivityMainBinding;
import com.figengungor.suits.fragment.SezonFragment;
import com.figengungor.suits.fragment.TanitimFragment;

public class MainActivity extends AppCompatActivity {


    ActionBarDrawerToggle actionBarDrawerToggle;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        toolbarAyarla();
        navigationViewAyarla();
        viewPagerTabLayoutAyarla();

    }

    private void viewPagerTabLayoutAyarla() {
            ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
            adapter.addFragment(new TanitimFragment(), getString(R.string.information));
            adapter.addFragment(new SezonFragment(), getString(R.string.season));
            binding.viewPager.setAdapter(adapter);
            binding.tabLayout.setupWithViewPager(binding.viewPager);
    }

    public void toolbarAyarla(){
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbarLayout.toolbar, R.string.drawerOpened, R.string.drawerClosed){

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
                binding.content.setTranslationX(slideOffset * drawerView.getWidth());
            }
        };

        setSupportActionBar(binding.toolbarLayout.toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void navigationViewAyarla() {

        binding.navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
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
                if(binding.drawerLayout.isDrawerOpen(GravityCompat.START))
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                else
                    binding.drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
