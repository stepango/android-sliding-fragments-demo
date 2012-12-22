package com.pldemo;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.ActionBar.TabListener;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.nineoldandroids.view.ViewPropertyAnimator;
import com.pldemo.fragments.PlayerSmallFragment;

public class MainActivity
        extends SherlockFragmentActivity
        implements TabListener {


    RelativeLayout mRoot;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureActionBar();
        mRoot = (RelativeLayout) findViewById(R.id.root);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getId();
                expand(findViewById(R.id.container));
            }
        });
        getSupportFragmentManager().beginTransaction().add(R.id.container, new PlayerSmallFragment()).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    private void configureActionBar() {
        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        String[] locations = getResources().getStringArray(R.array.locations);
        for (String location : locations) {
            Tab tab = getSupportActionBar().newTab();
            tab.setText(location);
            tab.setTabListener(this);
            getSupportActionBar().addTab(tab);
        }
    }

    public void on1(View v) {
        Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
        collapse(findViewById(R.id.container));
    }

    public void on2(View v) {
        Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
    }

    public void on3(View v) {
        Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
    }

    public void on4(View v) {
        Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }

    public static void expand(final View v) {
        v.setVisibility(View.VISIBLE);
        ViewPropertyAnimator
                .animate(v)
                .y(0)
                .setDuration((int) (v.getHeight() / v.getContext().getResources().getDisplayMetrics().density) * 5)
                .start();
    }

    public static void collapse(final View v) {
        final int initialHeight = v.getMeasuredHeight();
        ViewPropertyAnimator
                .animate(v)
                .y(initialHeight)
                .setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density) * 5)
                .start();
    }

}
