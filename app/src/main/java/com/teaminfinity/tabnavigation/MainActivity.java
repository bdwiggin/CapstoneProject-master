package com.teaminfinity.tabnavigation;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new HomeFragment(), "Home");
        viewPagerAdapter.addFragments(new AnatomicalChartsFragment(), "Anatomical Charts");
        viewPagerAdapter.addFragments(new EditProfileFragment(), "Manage Profile");
        viewPagerAdapter.addFragments(new TimetableFragment(), "Time table");
        viewPagerAdapter.addFragments(new StartFragment(), "Start Tracking");
        viewPagerAdapter.addFragments(new EndFragment(), "End Tracking");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    public void onButtonClick(View view) {
        if (view.getId() == R.id.editProfile) {
            Intent i = new Intent(MainActivity.this, EditProfilePage.class);
            startActivity(i);
        }
        if (view.getId() == R.id.imageButton1) {
            Intent i = new Intent(MainActivity.this, UpperBackDiagram.class);
            startActivity(i);
        }
        if (view.getId() == R.id.imageButton2) {
            Intent i = new Intent(MainActivity.this, LowerBackDiagram.class);
            startActivity(i);
        }
        if (view.getId() == R.id.editThreshold) {
            Intent i = new Intent(MainActivity.this, EditThresholdPage.class);
            startActivity(i);

        }
        if (view.getId() == R.id.customizeAlerts) {
            Intent i = new Intent(MainActivity.this, CustomizeAlertsPage.class);
            startActivity(i);
        }

    }
}





