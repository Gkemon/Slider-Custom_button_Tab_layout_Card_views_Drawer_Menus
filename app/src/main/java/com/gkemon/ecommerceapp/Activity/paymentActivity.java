package com.gkemon.ecommerceapp.Activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gkemon.ecommerceapp.Fragments.ConfirmFragment;
import com.gkemon.ecommerceapp.Fragments.PaymentFragment;
import com.gkemon.ecommerceapp.Fragments.shipingFragments;
import com.gkemon.ecommerceapp.Model.Items;
import com.gkemon.ecommerceapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class paymentActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    LinearLayout linearLayout;
    public Typeface typeface;
    Context context;
    TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7;
    private Items i1,i2,i3,i6,i4,i5,i7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

//        textView1=(TextView) findViewById(R.id.t1);
//        textView2=(TextView) findViewById(R.id.t2);
//        textView3=(TextView) findViewById(R.id.t3);
//        textView4=(TextView) findViewById(R.id.t5);
//        textView5=(TextView) findViewById(R.id.t6);
//        textView6=(TextView) findViewById(R.id.t7);
        //textView7=(TextView) findViewById(R.id.t8);

        AssetManager am = this.getApplicationContext().getAssets();

        typeface = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "MavenPro-Regular.ttf"));
//
//        textView1.setTypeface(typeface);
//        textView2.setTypeface(typeface);
//        textView3.setTypeface(typeface);
//        textView4.setTypeface(typeface);
//        textView5.setTypeface(typeface);
//        textView6.setTypeface(typeface);
//        textView7.setTypeface(typeface);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        //Tabs
        viewPager = (ViewPager) findViewById(R.id.viewpagerInPayment);
        tabLayout = (TabLayout) findViewById(R.id.tabsInPayment);
        tabLayout.setupWithViewPager(viewPager);

        setupViewPager(viewPager);

        context=this;
        //For using custom front



    }
    public void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapterInPayment adapter = new ViewPagerAdapterInPayment(getSupportFragmentManager());

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            //noinspection ConstantConditions
            TextView tv=(TextView) LayoutInflater.from(this).inflate(R.layout.tab_text,null);
            tv.setTypeface(typeface);
            tabLayout.getTabAt(i).setCustomView(tv);
        }
        adapter.addFrag(new shipingFragments(), "SHIPPING");
        adapter.addFrag(new PaymentFragment(), "PAYMENT");
        adapter.addFrag(new ConfirmFragment(), "CONFIRMATION");


       // viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(adapter);


//        Set the number of pages that should be retained to either side of the current page in the view
//         hierarchy in an idle state. Pages beyond this limit will be recreated from the adapter when needed.

    }
}
class ViewPagerAdapterInPayment extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public ViewPagerAdapterInPayment(FragmentManager manager) {
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