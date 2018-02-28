package com.gkemon.ecommerceapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.gkemon.ecommerceapp.R;

import static com.gkemon.ecommerceapp.Activity.WelcomeActivity.cartCounterArrayList;

public class ProductsViewActivity extends AppCompatActivity {

    View Back;
    public TextView cartCounter;

    @Override
    protected void onStart() {
        super.onStart();
        //Cart
        final Context context;
        context=this;


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
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //HIDING NOTIFICATION BAR
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_products_view);

        Back=findViewById(R.id.backPress);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }
}
