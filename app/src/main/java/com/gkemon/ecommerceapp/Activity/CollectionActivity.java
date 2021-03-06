package com.gkemon.ecommerceapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.gkemon.ecommerceapp.R;

import static com.gkemon.ecommerceapp.Activity.WelcomeActivity.cartCounterArrayList;

public class CollectionActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public View watch;
    public Context context;
    public TextView cartCounter;

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("GK","onstart of main activity" +String.valueOf(cartCounterArrayList.size()) );


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarInCollection);
        setSupportActionBar(toolbar);

        //Cart
        final Context context;
        context=this;


        cartCounter=findViewById(R.id.cartItemCountNumber);

        if(cartCounterArrayList.size()==0)cartCounter.setVisibility(View.GONE);
        else cartCounter.setVisibility(View.VISIBLE);
        cartCounter.setText(String.valueOf(cartCounterArrayList.size()));

        cartCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartCounter.setVisibility(View.GONE);
                cartCounterArrayList.clear();
                Intent intent = new Intent(context,CartActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            }
        });
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=this;

        //HIDING NOTIFICATION BAR
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_collection);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarInCollection);
        setSupportActionBar(toolbar);


        cartCounter=findViewById(R.id.cartItemCountNumber);

        if(cartCounterArrayList.size()==0)cartCounter.setVisibility(View.GONE);
        cartCounter.setText(String.valueOf(cartCounterArrayList.size()));

        cartCounter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartCounter.setVisibility(View.GONE);
                cartCounterArrayList.clear();
                Intent intent = new Intent(context,CartActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            }
        });


        watch=findViewById(R.id.watch);

        watch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,MainActivity.class);
                startActivity(i);
                overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
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
            overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.collection, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
