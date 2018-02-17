package com.gkemon.ecommerceapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gkemon.ecommerceapp.Adapers.ConfirmAdapter;
import com.gkemon.ecommerceapp.R;

import static com.gkemon.ecommerceapp.Fragments.shipingFragments.listitems;

public class ConfirmFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public RecyclerView recyclerViewForClass;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View rootView;
    public LinearLayoutManager linearLayoutManager;



    public ConfirmFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        rootView = inflater.inflate(R.layout.fragment_confirm, container, false);
        recyclerViewForClass=rootView.findViewById(R.id.confirm_item_recycler);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        ConfirmAdapter itemsAdapter = new ConfirmAdapter(listitems);
        recyclerViewForClass.setHasFixedSize(true);
        recyclerViewForClass.setAdapter(itemsAdapter);
        recyclerViewForClass.setLayoutManager(linearLayoutManager);


        return rootView;
    }



}
