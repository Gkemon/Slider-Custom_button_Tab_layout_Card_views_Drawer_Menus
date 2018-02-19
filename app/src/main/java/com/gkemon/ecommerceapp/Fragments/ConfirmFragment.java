package com.gkemon.ecommerceapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gkemon.ecommerceapp.Adapers.ConfirmAdapter;
import com.gkemon.ecommerceapp.Model.ConfirmItem;
import com.gkemon.ecommerceapp.Model.DeliveryItems;
import com.gkemon.ecommerceapp.Model.PaymentItems;
import com.gkemon.ecommerceapp.R;

import java.util.ArrayList;

import static com.gkemon.ecommerceapp.Fragments.shipingFragments.listitems;

public class ConfirmFragment extends Fragment {

    public static ArrayList<ConfirmItem> ConfirmItemList = new ArrayList<>();
    public RecyclerView recyclerViewForClass;
    private View rootView;
    public LinearLayoutManager linearLayoutManager;
    public int imageResourceOfConfirmItems[]={R.drawable.box,R.drawable.ball,R.drawable.bag,R.drawable.box,R.drawable.ball};
    public ArrayList<String> ProductNameList;
    public ArrayList<String> SizeList;
    public ArrayList<Double> ProductPricesList;
    public ArrayList<Integer> ProductQuantityList;


    public ConfirmFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        initializeList();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_confirm, container, false);
        recyclerViewForClass=rootView.findViewById(R.id.confirm_item_recycler);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ConfirmAdapter itemsAdapter = new ConfirmAdapter(ConfirmItemList);
        recyclerViewForClass.setHasFixedSize(true);
        recyclerViewForClass.setAdapter(itemsAdapter);
        recyclerViewForClass.setLayoutManager(linearLayoutManager);


        return rootView;
    }

    public void initializeList() {
        listitems.clear();
        for(int i =0;i<=4;i++){
            ConfirmItem item = new ConfirmItem(1,ProductNameList.get(i),SizeList.get(i),ProductPricesList.get(i),imageResourceOfConfirmItems[i]);
            ConfirmItemList.add(item);
        }

    }



}
