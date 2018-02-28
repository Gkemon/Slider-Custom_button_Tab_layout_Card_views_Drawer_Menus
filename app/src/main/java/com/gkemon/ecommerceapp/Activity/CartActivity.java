package com.gkemon.ecommerceapp.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.gkemon.ecommerceapp.Adapers.ConfirmAdapter;
import com.gkemon.ecommerceapp.Model.ConfirmItem;
import com.gkemon.ecommerceapp.R;

import java.util.ArrayList;

import static com.gkemon.ecommerceapp.Fragments.shipingFragments.listitems;

public class CartActivity extends AppCompatActivity {

    public static ArrayList<ConfirmItem> ConfirmItemList = new ArrayList<>();
    public RecyclerView recyclerViewForClass;
    public LinearLayoutManager linearLayoutManager;
    public int imageResourceOfConfirmItems[]={R.drawable.box,R.drawable.ball,R.drawable.bag,R.drawable.box,R.drawable.ball};
    public ArrayList<String> ProductNameList;
    public ArrayList<String> SizeList;
    public ArrayList<Double> ProductPricesList;
    public ArrayList<Integer> ProductQuantityList;
    public View ButtonGoToPayMentActivity;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //HIDING NOTIFICATION BAR
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setContentView(R.layout.activity_cart);


        ProductNameList=new ArrayList<>();
        SizeList=new ArrayList<>();
        ProductPricesList=new ArrayList<>();
        ProductQuantityList=new ArrayList<>();


        ProductNameList.add("Teak  and Steel\nPetanque Set");
        ProductNameList.add("Lemon Peel Baseball");
        ProductNameList.add("Seil Marschall Hiking\nPack");
        ProductNameList.add("Teak  and Steel\nPetanque Set");
        ProductNameList.add("Lemon Peel Baseball");

        SizeList.add("One Size");
        SizeList.add("One Size");
        SizeList.add("Size L");
        SizeList.add("One Size");
        SizeList.add("One Size");

        ProductPricesList.add(220.00);
        ProductPricesList.add(49.00);
        ProductPricesList.add(320.00);
        ProductPricesList.add(220.00);
        ProductPricesList.add(49.00);
        context=this;
        initializeList();

        recyclerViewForClass=findViewById(R.id.confirm_item_recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ConfirmAdapter itemsAdapter = new ConfirmAdapter(ConfirmItemList);
        recyclerViewForClass.setHasFixedSize(true);
        recyclerViewForClass.setAdapter(itemsAdapter);
        recyclerViewForClass.setLayoutManager(linearLayoutManager);
        ButtonGoToPayMentActivity=findViewById(R.id.ButtonGoToPayMentActivity);
        ButtonGoToPayMentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,paymentActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);
            }
        });


    }

    public void initializeList() {
        listitems.clear();
        for(int i =0;i<=4;i++){
            ConfirmItem item = new ConfirmItem(1,ProductNameList.get(i),SizeList.get(i),ProductPricesList.get(i),imageResourceOfConfirmItems[i]);
            ConfirmItemList.add(item);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.pull_in_left, R.anim.push_out_right);
    }
}

