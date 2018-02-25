package com.veloce.veloce;

import android.Manifest;
import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;

import android.os.AsyncTask;

import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;
// used for rest api call
import org.json.JSONException;
import org.json.JSONObject;


import java.net.MalformedURLException;
import java.net.URL;
import android.support.v7.widget.Toolbar;


public class MainActivity extends AppCompatActivity{

    private Button mBtLaunchActivity;
    private Button menuDrawer;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        mBtLaunchActivity = (Button) findViewById(R.id.bt_launch_activity);
        mBtLaunchActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchProfile();
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                myToolbar,
                R.string.drawer_open,
                R.string.drawer_close) {
        };

        // assign the new drawer toggle to the drawer layout
        mDrawerLayout.addDrawerListener(mDrawerToggle);

        NavigationView navigationView = (NavigationView) findViewById(R.id.left_nav);
        if (navigationView.equals(null)) {
            Toast.makeText(this, "fakes", Toast.LENGTH_SHORT).show();
        } else {
            navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        switch (menuItem.getItemId()) {
                            case R.id.nav_profile: launchProfile(); break;
                            case R.id.nav_current_trip_map: launchCurrentTrip(); break;
                            default: break;

                        }

                        return true;
                    }
                });
        }
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        //
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        mDrawerToggle.syncState();

    }

    private void launchProfile() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
    private void launchCurrentTrip(){
        Intent intent = new Intent(this, CurrentTripsActivity.class);
        startActivity(intent);
    }

    public void submitBtn(View v) {

    }

    public void openNavProfile() {
        Toast.makeText(this, "Profile Opened", Toast.LENGTH_SHORT);
    }

}