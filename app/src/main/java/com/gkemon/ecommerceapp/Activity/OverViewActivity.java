package com.gkemon.ecommerceapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.balysv.materialripple.MaterialRippleLayout;
import com.gkemon.ecommerceapp.Adapers.ItemsAdapter;
import com.gkemon.ecommerceapp.Listener.RecyclerItemClickListener;
import com.gkemon.ecommerceapp.R;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by uy on 2/13/2018.
 */

public class OverViewActivity extends AppCompatActivity implements RecyclerItemClickListener {
    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private LinearLayout dotsLayout;
    private TextView[] dots;
    private int[] layouts;
    public Typeface typeface;
    public Context context;

    //recycle
    public RecyclerView recyclerViewForItems;
    public ItemsAdapter itemAdapter;
    public GridLayoutManager gridLayoutManager;
    public View mainlayout,Back;
    public TextView cartCounter;



    private AlphaAnimation alphaAnimation;
    //private PrefManager prefManager;
    //FaceBook
    ImageView pluse1,pluse2,pluse3,minus1,minus2,minus3;
    TextView description1,description2,description3;
    FloatingActionButton FABforCart;
    View cartLayout;
    public static ArrayList<Integer> cartCounterArrayList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(100);
        context=this;

        // Making notification bar transparent
//        if (Build.VERSION.SDK_INT >= 21) {
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
//        }



        //HIDING NOTIFICATION BAR
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_product_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //CART
        FABforCart =findViewById(R.id.cart);
        cartLayout=findViewById(R.id.cartLayout);
        cartLayout.setAnimation(alphaAnimation);
        mainlayout=findViewById(R.id.main_layout);
        cartCounter=findViewById(R.id.cartItemCountNumber);

        if(cartCounterArrayList.size()==0)cartCounter.setVisibility(View.GONE);
        cartCounter.setText(String.valueOf(cartCounterArrayList.size()));

        FABforCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cartCounterArrayList.add(1);
                cartCounter.setVisibility(View.VISIBLE);
                cartCounter.setText(String.valueOf(cartCounterArrayList.size()));

            }
        });

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


        //recycler
        recyclerViewForItems=findViewById(R.id.recycleViewForItems);
        gridLayoutManager = new GridLayoutManager(context,2);
        recyclerViewForItems.setLayoutManager(gridLayoutManager);
        itemAdapter = new ItemsAdapter(this);
        itemAdapter.setOnItemClickListener(this);
        //SET ADAPTER
        itemAdapter.addAll(MainActivity.itemsArrayList);
        recyclerViewForItems.setAdapter(itemAdapter);

        //BACK
        Back=findViewById(R.id.backPress);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        //For hide and show description (Extendable view)
        pluse1=(ImageView)findViewById(R.id.plus1);
        pluse2=(ImageView)findViewById(R.id.plus2);
        pluse3=(ImageView)findViewById(R.id.plus3);

        minus1=(ImageView)findViewById(R.id.minus1);
        minus2=(ImageView)findViewById(R.id.minus2);
        minus3=(ImageView)findViewById(R.id.minus3);

        description1=(TextView) findViewById(R.id.description1);
        description2=(TextView) findViewById(R.id.description2);
        description3=(TextView) findViewById(R.id.description3);

        description1.setVisibility(View.VISIBLE);
        description2.setVisibility(View.GONE);
        description3.setVisibility(View.GONE);

        minus1.setVisibility(View.VISIBLE);
        minus2.setVisibility(View.GONE);
        minus3.setVisibility(View.GONE);

        //For animation
        minus1.setAnimation(alphaAnimation);
        minus2.setAnimation(alphaAnimation);
        minus3.setAnimation(alphaAnimation);

        pluse1.setVisibility(View.GONE);
        pluse1.setAnimation(alphaAnimation);
        pluse1.setAnimation(alphaAnimation);
        pluse1.setAnimation(alphaAnimation);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,ProductsViewActivity.class);
                startActivity(i);
            }
        });

        //For using custom front
        AssetManager am = this.getApplicationContext().getAssets();

        typeface = Typeface.createFromAsset(am,
                String.format(Locale.US, "fonts/%s", "MavenPro-Regular.ttf"));

        description1.setTypeface(typeface);
        description2.setTypeface(typeface);
        description3.setTypeface(typeface);


        pluse1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pluse1.setVisibility(View.GONE);
                minus1.setVisibility(View.VISIBLE);
                description1.setVisibility(View.VISIBLE);
                minus1.startAnimation(alphaAnimation);
                description1.startAnimation(alphaAnimation);
            }
        });

        pluse2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pluse2.setVisibility(View.GONE);
                minus2.setVisibility(View.VISIBLE);
                description2.setVisibility(View.VISIBLE);
                minus2.startAnimation(alphaAnimation);
                description2.startAnimation(alphaAnimation);
            }
        });

        pluse3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pluse3.setVisibility(View.GONE);
                minus3.setVisibility(View.VISIBLE);
                description3.setVisibility(View.VISIBLE);
                minus3.startAnimation(alphaAnimation);
                description3.startAnimation(alphaAnimation);
            }
        });



        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pluse1.setVisibility(View.VISIBLE);
                minus1.setVisibility(View.GONE);
               // description1.startAnimation(alphaAnimation);
                description1.setVisibility(View.GONE);
                pluse1.startAnimation(alphaAnimation);
            }
        });
        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pluse2.setVisibility(View.VISIBLE);
                minus2.setVisibility(View.GONE);
              //  description2.startAnimation(alphaAnimation);
                description2.setVisibility(View.GONE);
                pluse2.startAnimation(alphaAnimation);
            }
        });
        minus3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pluse3.setVisibility(View.VISIBLE);
                minus3.setVisibility(View.GONE);
               // description3.startAnimation(alphaAnimation);
                description3.setVisibility(View.GONE);
                pluse3.startAnimation(alphaAnimation);
            }
        });



        viewPager = (ViewPager) findViewById(R.id.view_pager);
        dotsLayout = (LinearLayout) findViewById(R.id.layoutDots);


        // layouts of all welcome sliders
        // add few more layouts if you want
        layouts = new int[]{
                R.layout.intr1,
                R.layout.intr2,
                R.layout.intr3,
        };

        // adding bottom dots
        addBottomDots(0);

        // making notification bar transparent
        // changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);


//        btnNext.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // checking for last page
//                // if last page home screen will be launched
////                int current = getItem(+1);
////                if (current < layouts.length) {
////                    // move to next screen
////                    viewPager.setCurrentItem(current);
////                } else {
////                    launchHomeScreen();
////                }
//                Intent i=new Intent(WelcomeActivity.this,MainActivity.class);
//                startActivity(i);
//
//            }
//        });
    }

    private void addBottomDots(int currentPage) {
        dots = new TextView[layouts.length];

        int[] colorsActive = getResources().getIntArray(R.array.array_dot_active);
        int[] colorsInactive = getResources().getIntArray(R.array.array_dot_inactive);

        dotsLayout.removeAllViews();
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));//Dot is a character  ,Here its come from HTML.
            dots[i].setTextSize(25);
            dots[i].setTextColor(colorsInactive[currentPage]);
            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(colorsActive[currentPage]);
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }


    //  viewpager change listener
    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            if(position>3){
                addBottomDots(0);
                return;
            }
            addBottomDots(position);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

    };

    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;

        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context,ProductsViewActivity.class);
                    startActivity(i);
                }
            });

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }

    }
    @Override
    public void onItemClick(int position, View view) {

//        Intent i = new Intent(getActivity(),OverViewActivity.class);
//        startActivity(i);

    }

    @Override
    public void onItemLongPressed(int position, View view) {

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }

}
