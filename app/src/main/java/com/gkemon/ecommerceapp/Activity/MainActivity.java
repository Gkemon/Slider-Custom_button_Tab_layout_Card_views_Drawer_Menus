package com.gkemon.ecommerceapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.gkemon.ecommerceapp.CustomView.CustomCardsForItem;
import com.gkemon.ecommerceapp.Fragments.WatchFragments;
import com.gkemon.ecommerceapp.Model.Items;
import com.gkemon.ecommerceapp.R;

import java.util.ArrayList;
import java.util.List;

//TODO: Use Toolbar in Appbarlayout because this Appbarlayout for Toolbar and others Upper UI elements to
// organize them vertically in the top side of an app

//TODO: Import Drawable from outside of android studio.Not Inside of android studio

//TODO: "There is no default constructor available in 'android.support.v7.widget.card" in custom view' that means uou have to call super class .see 'CustomCardsForItem.java' 14th line;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Items i1,i2,i3,i6,i4,i5,i7;
    private CustomCardsForItem customCardsForItem;
    public static ArrayList<Items> itemsArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        customCardsForItem=new CustomCardsForItem(this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        i1=new Items();
        i2=new Items();
        i3=new Items();
        i4=new Items();
        i5=new Items();

        i1.setOffer("Offer 70% off");
        i1.setProductName("Product Name");
        i1.setPromotion("Discover now!");
        i1.setImage(R.drawable.w3);

        i2.setOffer("Offer 70% off");
        i2.setProductName("Product Name");
        i2.setPromotion("Discover now!");
        i2.setImage(R.drawable.w3);

        i3.setOffer("Offer 70% off");
        i3.setProductName("Product Name");
        i3.setPromotion("Discover now!");
        i3.setImage(R.drawable.w3);

        i4.setOffer("Offer 70% off");
        i4.setProductName("Product Name");
        i4.setPromotion("Discover now!");
        i4.setImage(R.drawable.w3);

        i5.setOffer("Offer 70% off");
        i5.setProductName("Product Name");
        i5.setPromotion("Discover now!");
        i5.setImage(R.drawable.w3);

        itemsArrayList=new ArrayList<>();

        itemsArrayList.add(i1);
        itemsArrayList.add(i2);
        itemsArrayList.add(i3);
        itemsArrayList.add(i4);
        itemsArrayList.add(i5);
        itemsArrayList.add(i5);




        //Tabs
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.cartID) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_over_view) {
            Intent intent =new Intent(this,OverViewActivity.class);
            startActivity(intent);
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

    public void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new WatchFragments(), "ঘড়ি");
        adapter.addFrag(new WatchFragments(), "পারফিউম");
        adapter.addFrag(new WatchFragments(), "সকল পণ্য");
        viewPager.setAdapter(adapter);
    }
}
class ViewPagerAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager manager) {
        super(manager);
    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFrag(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
