package com.gkemon.ecommerceapp.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gkemon.ecommerceapp.Activity.MainActivity;
import com.gkemon.ecommerceapp.Activity.OverViewActivity;
import com.gkemon.ecommerceapp.Adapers.ItemsAdapter;
import com.gkemon.ecommerceapp.Listener.RecyclerItemClickListener;
import com.gkemon.ecommerceapp.R;


public class WatchFragments extends Fragment implements RecyclerItemClickListener {
    private View rootView;
    public FloatingActionButton btnAdd;
    private Context context;
    public  RecyclerView recyclerViewForClass;
    public ItemsAdapter itemAdapter;
    public GridLayoutManager gridLayoutManager;


    public WatchFragments() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =inflater.inflate(R.layout.fragment_watch, container, false);
        //VIEWS
        recyclerViewForClass = (RecyclerView) rootView.findViewById(R.id.recycleViewForItems);

        gridLayoutManager = new GridLayoutManager(context,2);
        recyclerViewForClass.setLayoutManager(gridLayoutManager);
        ItemsAdapter itemsAdapter = new ItemsAdapter(getActivity());

        itemAdapter = new ItemsAdapter(context);
        itemAdapter.setOnItemClickListener(this);
        //SET ADAPTER
        itemAdapter.addAll(MainActivity.itemsArrayList);
        recyclerViewForClass.setAdapter(itemAdapter);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onItemClick(int position, View view) {

        Intent i = new Intent(getActivity(),OverViewActivity.class);
        startActivity(i);
        getActivity().overridePendingTransition(R.anim.pull_in_right, R.anim.push_out_left);

    }

    @Override
    public void onItemLongPressed(int position, View view) {

    }
}
