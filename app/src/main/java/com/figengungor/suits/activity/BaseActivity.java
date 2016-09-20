package com.figengungor.suits.activity;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.figengungor.suits.R;
public class BaseActivity extends AppCompatActivity {

    Toolbar toolbar;
    LinearLayout container;

    @Override
    public void setContentView(@LayoutRes int layoutResID) {

        container = (LinearLayout) getLayoutInflater().inflate(R.layout.activity_base, null);
        FrameLayout activityContent = (FrameLayout) container.findViewById(R.id.activityContent);
        getLayoutInflater().inflate(layoutResID, activityContent, true);

        super.setContentView(container);

        toolbar = (Toolbar) container.findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    public void setTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
