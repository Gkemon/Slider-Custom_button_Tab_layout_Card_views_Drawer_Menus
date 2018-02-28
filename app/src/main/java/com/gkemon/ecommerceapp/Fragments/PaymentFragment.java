package com.gkemon.ecommerceapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gkemon.ecommerceapp.Adapers.DeliveryAdapter;
import com.gkemon.ecommerceapp.Adapers.PaymentAdapter;
import com.gkemon.ecommerceapp.Model.DeliveryItems;
import com.gkemon.ecommerceapp.Model.PaymentItems;
import com.gkemon.ecommerceapp.R;

import java.util.ArrayList;

import static com.gkemon.ecommerceapp.Activity.paymentActivity.viewPager;
import static com.gkemon.ecommerceapp.Fragments.shipingFragments.listitems;

public class PaymentFragment extends Fragment {
    public RecyclerView recyclerViewForClass;

    public static ArrayList<PaymentItems> PaymentItemLists = new ArrayList<>();
    private View rootView;
    public LinearLayoutManager linearLayoutManager;

    public static ArrayList<String> methodOfPayment;
    public int imageResourceOfPayment[]={R.drawable.paypal,R.drawable.visa,R.drawable.netbanking,R.drawable.payu};
    View continueToConfirmation;

    public PaymentFragment() {
        // Required empty public constructor

        methodOfPayment=new ArrayList<>();

        methodOfPayment.add("PAYPAL");
        methodOfPayment.add("DEBIT CARD");
        methodOfPayment.add("NETBANK");
        methodOfPayment.add("PAY U MONEY");
        initializeList();
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_payment, container, false);
        recyclerViewForClass=rootView.findViewById(R.id.deliveryRecycler1);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        PaymentAdapter itemsAdapter = new PaymentAdapter(PaymentItemLists);
        recyclerViewForClass.setHasFixedSize(true);
        recyclerViewForClass.setAdapter(itemsAdapter);
        recyclerViewForClass.setLayoutManager(linearLayoutManager);

        //CONTINUE ORDER

        continueToConfirmation = rootView.findViewById(R.id.continueToConfirmation);
        continueToConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(2);
            }
        });

        return rootView;
    }

    public void initializeList() {
        listitems.clear();
        for(int i =0;i<4;i++){
            PaymentItems item = new PaymentItems(imageResourceOfPayment[i],methodOfPayment.get(i));
            PaymentItemLists.add(item);
        }

    }



}
